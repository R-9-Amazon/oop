package lab6_home;
import java.util.Scanner;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class MainWin {

	private JFrame frmLab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frmLab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public int w;
	public int h;
	public int[][]arr;
	public MainWin() {
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLab = new JFrame();
		frmLab.setBackground(Color.BLACK);
		frmLab.setResizable(false);
		frmLab.setTitle("Лаб. раб №6");
		frmLab.setBounds(100, 100, 1028, 600);
		frmLab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLab.getContentPane().setLayout(null);
		int x1=1010;
		int y1=510;
		PaintPanel panel = new PaintPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 994, 531);
		frmLab.getContentPane().add(panel);
		
		panel.GettingReady(x1-10,y1-10);
		
			
		
	}
}
