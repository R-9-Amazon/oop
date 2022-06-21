package lab8_home;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Lab8_Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab8_Main window = new Lab8_Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lab8_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Лабораторная работа №8");
		frame.setBounds(100, 100, 532, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 495, 375);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Загрузить");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser upload = new JFileChooser();
				if(upload.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					try {
						textArea.setText(upload.getSelectedFile().getAbsolutePath());
						Scanner sc = new Scanner(new File(upload.getSelectedFile().getAbsolutePath()));
						String text = "";
						
						while(sc.hasNext()) {
							text += sc.nextLine() + "\n";						
						}
						
						sc.close();
						textArea.setText(text);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
		btnNewButton.setBounds(44, 395, 100, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Обработать");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AltString string = new AltString(textArea.getText().toCharArray());

	                int firstLetterIndex = 0;
	                int lastLetterIndex = string.length()-1;
	                for (int i = 0; i < string.length(); i++) {
	                    char currLetter = string.getArray()[i];
	                    if (currLetter == ' ' || currLetter == ',' || currLetter == '.' || currLetter == '!' || currLetter == '?') { 
	                        lastLetterIndex = i-1;
	                        if (string.getArray()[firstLetterIndex] == string.getArray()[lastLetterIndex]) {
	                            for (int k = lastLetterIndex-firstLetterIndex; k >= 0; k--) {
	                                for (int j = firstLetterIndex; j < string.length()-1; j++) {
	                                    string.getArray()[j] = string.getArray()[j+1];
	                                }
	                            }
	                            i = lastLetterIndex-1;
	                        }
	                        firstLetterIndex = i+1;
	                    }
	                }

	                textArea.setText(new String(string.getArray()));
			}
		});
		btnNewButton_1.setBounds(209, 395, 100, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Сохранить");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser save = new JFileChooser();
				if(save.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(save.getSelectedFile().getAbsolutePath()));
						bw.write(textArea.getText());
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
				
			}
		});
		btnNewButton_1_1.setBounds(382, 395, 100, 21);
		frame.getContentPane().add(btnNewButton_1_1);
	}

}
