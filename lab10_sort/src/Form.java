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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Form {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    private int iterazia = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Form window = new Form();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Form() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Лаб Работа №10");
        frame.setBounds(100, 100, 735, 612);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Входной файл");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 10, 100, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(125, 10, 470, 24);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textArea.setBounds(10, 100, 700, 415);
        frame.getContentPane().add(textArea);

        JButton btnNewButton = new JButton("Выбрать...");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fd = new JFileChooser();
                if (fd.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try {
                        textField.setText(fd.getSelectedFile().getAbsolutePath());
                        Scanner sc = new Scanner(new File(fd.getSelectedFile().getAbsolutePath()));
                        String text = "";

                        while (sc.hasNext()) {
                            text += sc.nextLine() + "\n";
                        }

                        sc.close();
                        textArea.setText(text);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton.setBounds(610, 10, 100, 23);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Выходной файл");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(10, 55, 110, 20);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_1.setColumns(10);
        textField_1.setBounds(125, 55, 470, 24);
        frame.getContentPane().add(textField_1);

        JButton btnNewButton_1 = new JButton("Выбрать...");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fd = new JFileChooser();
                if (fd.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    textField_1.setText(fd.getSelectedFile().getAbsolutePath());
                }
            }
        });
        btnNewButton_1.setBounds(610, 55, 100, 23);
        frame.getContentPane().add(btnNewButton_1);


        JButton btnNewButton_2 = new JButton("Обработать");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] words = textArea.getText().split("\n");

                Timer timer = new Timer(500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
						if (iterazia == words.length) {
							
                            // останавливаем таймер, так как он больше не нужен
                            ((Timer)e.getSource()).stop();
                            System.out.print("Сартировка окончена!");
                            

                            try {
                                BufferedWriter bw = new BufferedWriter(new FileWriter(textField_1.getText()));
                                bw.write(textArea.getText());
                                bw.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }

                        for (int i = words.length-1; i > words.length-2; i--) {
                            for (int j = 0; j < i; j++) {
                                // используем аналог strcmp из C и сортируем пузырьком
                                if (strcmp(words[j], words[j+1]) > 0) {
                                    String t = words[j];
                                    words[j] = words[j+1];
                                    words[j+1] = t;
                                    
                                }
                                
                            }

                            textArea.setText(String.join("\n", words));
                          
                        }
                        
                        iterazia++;
                        
                    }
                });
          
                
                
                
                timer.start();
                
            }
            
        });
        
        btnNewButton_2.setBounds(10, 535, 700, 26);
        frame.getContentPane().add(btnNewButton_2);
        
    }

    

    public int strcmp(String s1, String s2) {
    	
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int ml = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < ml; i++) {
            if (arr1[i] != arr2[i]) {
                return arr1[i]-arr2[i];
            }
        }

        return arr1.length-arr2.length;
    }
    

}

