import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Polygon;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	private int arr[][];
	private int arr2[][];
	private int w, h, x2, y2;
	private int Task = 0;
	public PaintPanel() {
		
		try {
			Scanner sc = new Scanner(new File("C:\\lab6\\input.txt"));
			w = sc.nextInt();
			h = sc.nextInt();
			x2 = w;
			y2 = h;
			arr = new int [w][h];
			arr2 = new int [w][h];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[j][i] = sc.nextInt();
					arr2[j][i] = arr[j][i];
				}
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void RepeatPanel() {
		
		w = x2;
		h = y2;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				arr[j][i] = arr2[j][i];
			}
		}
	
	}
	
	public void setTypeTask(int TT) {
		Task =TT;
		repaint();
	}
	
	private void drawTask1(Graphics g) {
		int size = 70;
		
		for (int i = 0; i < h; i++) {
			
			for (int j = 0; j < w; j++) {
				
				switch (arr[j][i]) {
				case 0:
					g.setColor(new Color(0,255, 0));
					break;
				case 1: g.setColor(new Color(200,200,0));
				break;
				case 2: g.setColor(new Color(0,0,255));
				break;
				case 3: g.setColor(new Color(255,0,0));
				break;
				case 4: g.setColor(new Color(200,0,200));
				break;
				case 5: g.setColor(new Color(0,200,0));
				break;
				case 6: g.setColor(new Color(0,220,120));
				break;
				case 7: g.setColor(new Color(120,120,120));
				break;
				case 8: g.setColor(new Color(0,0,0));
				break;
				case 9: g.setColor(new Color(255,255,255));
				break;
				default: 
					g.setColor(new Color(200,200,60));
				break;
				}
				g.fillRect(100 + size*j, 100 + size*i, 70, 70);
				g.setColor(new Color(255,255,0));
				g.drawRect(100 + size*j, 100 + size*i, 70, 70);
			}
		}
		
	}
	
	private void Variant_A() {
	
			int max = arr[0][0];
			int max_i = 0;
			int min = arr[0][0];
			int min_i = 0;
			//ПЕРЕМЕЩЕНИЕ
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[j][i] > max) {
						max_i = i; max = arr[j][i]; 
					}
					if (arr[j][i] < min) {
						min_i = i; min = arr[j][i]; 
					}
				}
			}
			
			for (int i = 0; i < h; i++) {
				if ((i == max_i) || (i == min_i)) {
					if (i == max_i) {
						max_i = min_i;
					}
					int temp = 0;
					for (int j = 0; j < w; j++) {
						temp = arr[j][i]; arr[j][i] = arr[j][max_i]; arr[j][max_i] = temp;
					}
					break;
				}
			}
	}
	

	 
	 public void paint(Graphics g) {
			super.paint(g);
			switch(Task) {
			case 0: 
				drawTask1(g);
				break;
			case 1: 
				RepeatPanel();
				drawTask1(g);
				break;
			case 2: 
				Variant_A();
				drawTask1(g);
				break;
			
			}
			
			
		}
	 
}
