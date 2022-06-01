package lab6_home;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JPanel;
import java.util.Scanner;
public class PaintPanel extends JPanel {
	public PaintPanel() {
	}
	int w=0;
	int h=0;
	int[][]arr;
	
	int sizeX=0;
	int sizeY=0;
	public void GettingReady(int x1, int y1) {
		try {
			Scanner s= new Scanner(new File("C:\\lab6\\input.txt"));
			w=s.nextInt();
			h=s.nextInt();
			arr=new int[w][h];
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					arr[i][j]=s.nextInt();
				}
			}
			s.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		sizeX=x1/h;
		sizeY=y1/w;
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(arr[i][j] == 0) {
					g.setColor(new Color(0,255, 0));
				}
				else if(arr[i][j]==1) {
					g.setColor(new Color(255,0,0));
				}
				else if(arr[i][j]==2) {
					g.setColor(new Color(0,0,255));
				}
				else if(arr[i][j]==3) {
					g.setColor(new Color(200,200,0));
				}
				else if(arr[i][j]==4) {
					g.setColor(new Color(200,0,200));
				}
				else if(arr[i][j]==5) {
					g.setColor(new Color(0,220,120));
				}
				else if(arr[i][j]==6) {
					g.setColor(new Color(120,120,120));
				}
				else if(arr[i][j]==7) {
					g.setColor(new Color(0,0,0));
				}
				else if(arr[i][j]==8) {
					g.setColor(new Color(255,255,255));
				}
				else {
					g.setColor(new Color(200,200,60));
				}
					
				g.fillRect(10+j*sizeX, 10+i*sizeY, sizeX, sizeY);
		
			}
		}
		
	}

}
