package gameOfLifeMain;

import javax.swing.*;
import java.awt.*;

final public class GameOfLife {
	
	JFrame frame;
    DrawPanel drawPanel;
	
    WorldObject earth = new WorldObject();
    // Pre-settings:
    int lifeWidth = 1;		// Set the width of each organism
    int lifeHight = 1;		// Set the hight of each organism
    	// To set number of organism go to "WorldObject"
   
	public static void main(String[] args){
		
		new GameOfLife().createWorld();
	}
	
	public void createWorld(){
		/*  Set the start set of the world. Methods:
		 * deadWorld(); // Sets all organism to dead
		 * randomWorld(); // Sets all organism to a random state
		 * giveBirth(); // Sets spesifc organims to life. See the class OrganismObject
		 */
		 
		deadWorld(earth);
		
		OrganismObject org1 = new OrganismObject();
	int [] x= {0, 300};
	int [] y ={100, 0};
	
	int [] z ={200, 0};
	int [] q ={300,0};
	
	int [] ba ={400, 0};
	int [] w ={0, 0};
	
	int [] e ={599, 0};
	int [] cb ={5, 15};
	int [] da ={15, 5};
	int [] db ={5, 15};
 	int [] c ={210, 170};
//           giveBirth(earth, org1.gosperGliderGun(aa, "toSE", "horizontal"));
//           giveBirth(earth, org1.gosperGliderGun(ab, "toSE", "vertical"));
           
           giveBirth(earth, org1.greatLine(x, 600, "horizontal"));
           giveBirth(earth, org1.greatLine(y, 600, "vertical"));
           giveBirth(earth, org1.greatLine(z, 600, "vertical"));
           giveBirth(earth, org1.greatLine(q, 600, "vertical"));
           giveBirth(earth, org1.greatLine(ba, 600, "vertical"));
           giveBirth(earth, org1.greatLine(w, 600, "vertical"));
           giveBirth(earth, org1.greatLine(e, 600, "vertical"));
//         

// 			giveBirth(earth, org1.greatLine(y,350, "vertical"));
// 			for(int i = 0; i <5; i++){
// 				int [] a ={70*i+10, 10};
// 			giveBirth(earth, org1.greatLine(a,350, "vertical"));
// 			
// 			}
         //giveBirth(earth, org1.gosperGliderGun(a, "toNW"));
//        giveBirth(earth, org1.lightSpaceShip(c, "toW"));
		//giveBirth(earth, org1.randomArea(c, 20, 20));
		
 			
 		frame = new JFrame("Game of life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drawPanel = new DrawPanel();
        
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(earth.World[0].length*lifeWidth+18, earth.World.length*lifeHight+41);
        frame.setLocation(100, 10);

            while(true){
      
   				 nextWorld(earth);

        	      try {
        	          Thread.sleep(30);

        	        } catch (InterruptedException ie) {
        	          ie.printStackTrace();
        	        }

        	      frame.repaint();
            }
	}
	
	
	 class DrawPanel extends JPanel {

			public void paintComponent(Graphics g) {
	            g.setColor(Color.BLACK);
	            g.fillRect(0, 0, this.getWidth(), this.getHeight());
	            g.setColor(Color.RED);
	            g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
	            g.setColor(Color.BLUE);
	            g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
	            
	            for(int row = 0; row < earth.World.length; row ++){
	       	           for( int column = 0; column< earth.World [0].length; column ++ )
	       	        	   	
	       	        	   if(earth.World[row] [column]){
	       	        	   g.setColor(Color.BLACK);
	       	           g.fillRect(column*lifeWidth+6, row*lifeHight+6,lifeWidth, lifeHight);
	       	        	   }
	            }
	        }
	    }
	 
	 
	 // Presetting options for the world
	 public  void setWorld(WorldObject world){
		 for(int row=0; row < world.World.length; row++){
			 for(int column=0; column < world.World[0].length; column ++){
				 if((row*column)% 3 ==0){
				 world.World [row] [column] = false;
				 }else{
					 world.World [row] [column] = true ; 
				 }
			 }
		 }
	 }

	 public  void deadWorld(WorldObject world){

		 for(int row=0; row < world.World.length; row++){
			 for(int column=0; column < world.World[0].length; column ++){
				
					 world.World [row] [column] = false; 
					 
			 }
		 }
	
	 }
	 
	 public  void randomWorld(WorldObject world){

		 for(int row=0; row < world.World.length; row++){
			 for(int column=0; column < world.World[0].length; column ++){
				
					 world.World [row] [column] = getRandomBoolean(); 
					 
			 }
		 }
	 }
	 
	 
	 
	 public void giveBirth(WorldObject world, int [] [] life){
		 	/*Different struktures
		 	 * Glider: a={{0, 0},{1, 1},{1, 2},{2, 0}, {2,1}};
		 	 * SpaceShip: a={{0,1},{0,2},{1,0},{1,1},{1,2},{1,3},{2,0},{2,1},{2,3},{2,4},{3,2},{3,3}};
		 	 */
		 for(int i=0; i < life.length; i++){
			world.World[life[i][0]][life[i][1]]=true;
		 }
	 }
	 
	 
	 // Methods and functions used in abowe
	 public static boolean getRandomBoolean() {
	       return Math.random() < 0.5;
	  
	   }
	 
	 public WorldObject nextWorld(WorldObject world){
		 Boolean [] [] next = new Boolean [world.World.length] [world.World[0].length];
		 nullWorld(next);
		 

		 int [] circle = {-1, -1, 0, 1, 1, 1, 0, -1};
		 
		 for(int row=0; row < world.World.length; row++){
			 for(int column=0; column < world.World[0].length; column++){

				 int count = 0;
		 for(int i = 0; i < 8; i++){
	
			 if (column + circle[i] < world.World[0].length &&
					 column + circle[i] >= 0 &&
					 row + circle[absMod((i-2)%8, 8)] < world.World.length &&
 					  row + circle[absMod((i-2)%8, 8)] >=0){
				 if(world.World[row + circle[absMod((i-2)%8, 8)]] [column + circle[i]] == true){
			
					 count = count +1;
			 }
		 }
			 
		}

			
		 if(world.World[row] [column] == true){
	
			 if(count < 2){
				 next[row][column] = false;
							 }else if(count >3){
				 next[row][column] = false;
			
			 }
		 }else if(world.World[row] [column] == false){
			 if(count == 3){
				 next[row][column] = true;
			
	
			 }
		 }
			 }
		 }

		 world.World=addNewOld(world.World, next);
		return world;
	 }
	 
	 public  void nullWorld(Boolean [] [] world){

		 for(int row=0; row < world.length; row++){
			 for(int column=0; column < world[0].length; column ++){
				
					 world[row] [column] = null; 
					 
			 }
		 }
	 }
	 
	public boolean [] [] addNewOld(boolean [] [] old, Boolean [] [] next){
		boolean [] [] temp = new boolean [old.length] [old[0].length];
		
		for(int row=0; row< old.length; row++){
			for(int column=0; column< old[0].length; column++){
				if(next[row][column] == null){
					temp[row][column] = old[row][column];
				}else if(next[row][column] == true){
					temp[row][column] = true;
				}else{
					temp[row][column] = false;
				}
			}
		}
		return temp;
		
	}
	 
	 private static int absMod(int a, int mod){
			if(a >= 0){
				return a;
			}else{
				return mod + a;
			}
		}

}