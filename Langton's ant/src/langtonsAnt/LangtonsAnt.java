package langtonsAnt;

import javax.swing.*;

import rules.WorldRules;

import java.awt.*;

public class LangtonsAnt {
	
	JFrame frame;
	DrawPanel drawPanel;
	
	int width=900;
	int height=900;
	
	int antWidth=1;
	int antHeight=1;
	
	WorldRules worldRuler = new WorldRules();
	
	boolean [] colorArray = worldRuler.spiral(); 
		//{true, false, false, false, false, true, true, true, false, false, false};
		//{true, true, false, false};
	

	
	AntObject ant = new AntObject();
	//AntObject ant2 = new AntObject();
	AntWorldObject earth = new AntWorldObject();
	
	public static void main(String[] args) {
		new LangtonsAnt().go();
	}

	public void go(){
		frame = new JFrame("Langtons Ant");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setResizable(false);
	    frame.setSize(width*antWidth, height*antHeight);
	    frame.setLocation(20, 20);
	        
	        drawPanel = new DrawPanel();
	        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
	        
	        
	        /*
	         * "Main" Program
	         */
	        
	        ant.setPosition(width /2, height /2);
	        ant.setDirection("E");
	        
//	        ant2.setPosition(width /2+10, height /2-10);
//	        ant2.setDirection("N");
	        
	        
	        earth.setSize(width, height);
	        earth.setStartWorld();
	        earth.setColors(colorArray);

	        while(true){
	        	
	        	  try {
	    	          Thread.sleep(0);

	    	        } catch (InterruptedException ie) {
	    	          ie.printStackTrace();
	    	        }
	        earth.nextColor(ant.getXPosition(), ant.getYPosition());
	        ant.move();
	        ant.changeDirection(earth.getBolArray(), earth.getIntField());       
	        
//	        earth.nextColor(ant2.getXPosition(), ant2.getYPosition());
//	        ant2.move();
//	        ant2.changeDirection(earth.getBolArray(), earth.getIntField());
	        
	        frame.repaint();   
	        }
	        
	}

	   class DrawPanel extends JPanel {
	        public void paintComponent(Graphics g) {
	            
	            for(int x=0; x<earth.getIntField().length; x++){
	            	for(int y=0; y< earth.getIntField()[0].length; y++){
	            		switch(earth.getIntField()[x][y]){
	            		case 0:
	            			g.setColor(Color.GREEN);
	            			break;
	            		case 1:
	            			g.setColor(Color.RED);
	            			break;
	            		case 2:
	            			g.setColor(Color.BLUE);
	            			break;
	            		case 3:
	            			g.setColor(Color.YELLOW);
	            			break;
	            		case 4:
	            			g.setColor(Color.ORANGE);
	            			break;
	            		case 5:
	            			g.setColor(Color.CYAN);
	            			break;
	            		case 6:
	            			g.setColor(Color.DARK_GRAY);
	            			break;
	            		case 7:
	            			g.setColor(Color.MAGENTA);
	            			break;
	            		case 8:
	            			g.setColor(Color.PINK);
	            			break;
	            		case 9:
	            			g.setColor(Color.GRAY);
	            			break;
	            		case 10:
	            			g.setColor(Color.WHITE);
	            			break;
	            		}
	            		g.fillRect(antWidth*x, antHeight*y, antWidth, antHeight);
	            	}
	            } 
	            if(antWidth > 2 && antHeight > 2)
	            g.setColor(Color.BLACK);
	            g.fillRect(ant.getXPosition()*antWidth+1, ant.getYPosition()*antHeight+1, antWidth -2,antHeight-2);
	           // g.fillRect(ant2.getXPosition()*antWidth+1, ant2.getYPosition()*antHeight+1, antWidth -2,antHeight-2);
	        }
	    }
	
	   
}
