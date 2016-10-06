package simple;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Go {

	private Planet sun, earth, murkurie, moon;
	private ArrayList<Planet> system;
	
	private JFrame space;
	private double width = 600;
	private double height = 600;
	
	public static void main(String[] args) {
		Go system = new Go();
		
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			system.run();
			system.space.repaint();
		}
		
	}
	
	public Go(){
		
		space = new JFrame("System");
		space.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		space.setSize((int) width,(int)height);

		system = new ArrayList<>();
		
		sun = new Planet(20, 2, 0.5, Math.PI, width, height, Color.YELLOW);
		earth = new Planet(15, 200, 0.02, Math.PI, sun, Color.BLUE);
		murkurie = new Planet(5.1, 120.2, -0.2, Math.PI, sun, Color.GRAY);
		moon = new Planet (5.1, 50, 0.04, Math.PI, earth, Color.DARK_GRAY);
		
		system.add(sun);
		system.add(earth);
		system.add(murkurie);
		system.add(moon);
		system.add(new Planet(4, 100, 3, 0, system.get(3), Color.CYAN));
		
		space.add(new Draw());
		
		
		
		
		space.setVisible(true);
	}
	
	public void run(){
		
		for (Planet p : system) {
			p.move();
		}
	}
	
	
	public class Draw extends JComponent{
		public void paint(Graphics g){
			
			// Paint Draw
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, (int) width, (int) height); 
			
			
			
			for (Planet p : system) {
				g.setColor(p.getColor());
				g.drawOval(  (int)p.getFrameX(),  (int) p.getFrameY(), (int) (2*p.getR()), (int) (2*p.getR())); 
			}
	
			
		}
	}
	
	

}
