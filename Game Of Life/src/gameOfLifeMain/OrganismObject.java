package gameOfLifeMain;

public class OrganismObject {
	/*
	 * This class contains some possible "organisms" that can be created in Conway's Game of Life.
	 * This is used with GameOfLife.java
	 */
	
	public OrganismObject(){	
	}
	
	/*
	 * Organisms
	 */
	
	public int [] [] lightSpaceShip(int [] pos, String direction){
		int [] [] a={{0,1},{0,2},{1,0},{1,1},{1,2},{1,3},{2,0},{2,1},{2,3},{2,4},{3,2},{3,3}};
		int rot=0;
		switch(direction){
		case "toE" :
			rot = 0;
			break;
		case "toS" :
			rot = 1;
			break;
		case "toW" :
			rot = 2;
			break;
		case "toN" :
			rot = 3;
			break;
		}
		
		for(int i=0; i < rot; i++){
		a =rotate90CW(a);
		}
		move(a, pos);
		
		return a;
	}
	
	public int [] [] mediumSpaceShip(int [] pos, String direction){
		int [] [] a={{0,1},{0,2}, {0,3}, {1,0},{1,1},{1,2},{1,3},{1,4}, {2,0},{2,1},{2,2},{2,4},{2,5}, {3,3},{3,4}};
		int rot =0;
		switch(direction){
		case "toE" :
			rot = 0;
			break;
		case "toS" :
			rot = 1;
			break;
		case "toW" :
			rot = 2;
			break;
		case "toN" :
			rot = 3;
			break;
		}
		for(int i=0; i< rot;i++){
		move(a, pos);
		}
		return a;
	}
	
	public int [] [] glider(int [] pos, String direction){
		int [] [] a={{0, 0}, {1, 1},{1, 2}, {2, 0}, {2,1}};
		int rot=0;
		switch(direction){
		case "toSE" :
			rot = 0;
			break;
		case "toSW" :
			rot = 1;
			break;
		case "toNW" :
			rot = 2;
			break;
		case "toNE" :
			rot = 3;
			break;
		}
		
		for(int i=0; i < rot; i++){
			a =rotate90CW(a);
		}
		
		move(a, pos);
		return a;
	}
	
	public int [] [] ship(int [] pos, String direction){
		int [] [] a ={{0,0},{0,1}, {1,0}, {1,2}, {2,1},{2,2}};
		int rot = 0;
			switch(direction){
			case "toSE" :
				rot = 0;
				break;
			case "toSW" :
				rot = 1;
				break;
			}	
				for(int i=0; i < rot; i++){
					a =rotate90CW(a);
					}
				
				move(a, pos);
				return a;

	}
	
	public int [] [] gosperGliderGun(int [] pos, String direction, String orientation){
		int [] [] a= new int [35] [2];
		int [] [] temp;
		int length=0;
		
		int [] inerPos = {0,2}; // x,y coordinates
		temp = box(inerPos);
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[length+i][0];
			a[length+i][1] = temp[length+i][1];
		}
		
		length=length+temp.length;
		inerPos[0]= 34;
		inerPos[1] = 0;
		temp = box(inerPos);
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[i][0];
			a[length+i][1] = temp[i][1];
		}
		
		
		length=length+temp.length;
		inerPos[0]= 8;
		inerPos[1] = 2;
		temp = ship(inerPos, "toSW");
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[i][0];
			a[length+i][1] = temp[i][1];
		}
		
		length=length+temp.length;
		inerPos[0]= 22;
		inerPos[1] = 0;
		temp = ship(inerPos, "toSW");
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[i][0];
			a[length+i][1] = temp[i][1];
		}
		
		length=length+temp.length;
		inerPos[0]= 15;
		inerPos[1] = 4;
		temp = glider(inerPos, "toNW");
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[i][0];
			a[length+i][1] = temp[i][1];
		}
		
		length=length+temp.length;
		inerPos[0]= 34;
		inerPos[1] = 7;
		temp = glider(inerPos, "toNW");
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[i][0];
			a[length+i][1] = temp[i][1];
		}
		
		length=length+temp.length;
		inerPos[0]= 24;
		inerPos[1] = 11;
		temp = glider(inerPos, "toNW");
		for(int i=0; i<temp.length; i++){
			a[length+i][0] = temp[i][0];
			a[length+i][1] = temp[i][1];
		}
		
		// corection for diferent time in glidng
		a[a.length-2][0]=13;
		a[a.length-2][1]=24;
		
		// length a = 2*4 + 2*6 +5*3 = 
		
		int rot=0;
		switch(direction){
		case "toSE" :
			rot = 0;
			break;
		case "toSW" :
			rot = 1;
			break;
		case "toNW" :
			rot = 2;
			break;
		case "toNE" :
			rot = 3;
			break;
		}
		
		if(orientation== "horizontal"){
			rot=(4-rot) %4;
		}
		
		for(int i=0; i < rot; i++){
			a =rotate90CW(a);
			}
		
		if(orientation!= "horizontal"){
			rot=rot+1;
		}
		
		if(rot%2 ==1){
			a=transpose(a);
		}
	
		
		
		move(a, pos);
		return a;
	}
	
	public int [] [] acorn(int [] pos){
		int [] [] a= {{0,1},{1,3},{2,0},{2,1},{2,4},{2,5},{2,6}};
		move(a, pos);
		return a;
	}
	
	public int [] [] randomArea(int [] pos, int width , int hight){
		int counter=0;
		int [] [] temp = new int [width*hight][2];
		
		for(int i =0; i < width*hight; i++){
			if(getRandomBoolean()){
				temp[counter][0]= (i-(i %width))/width;
				temp[counter][1]= i %width;
				counter=counter +1;
			}
		}
		int [] [] a= new int [counter][2];
		
		for(int i=0; i< counter; i++){
			a[i][0]=temp[i][0];
			a[i][1]=temp[i][1];
		}
		move(a,pos);
		return a;
	}

	public int [] [] box(int [] pos){
		int [] [] a={{0, 0},{0, 1},{1, 0},{1,1}};
		move(a, pos);
		return a;
	}

	public int [] [] greatLine(int [] pos, int length, String orientation){
		int [] [] a = new int [length][2];
		
		for(int i=0; i<length; i++){
			a[i][0]= 0;
			a[i][1]= i;
		}
		if(orientation == "vertical"){
			a=transpose(a);
		}
		
		move(a,pos);
		return a;
	}
	
	
	
	/*
	 * Functions used
	 */
	public void move(int [] [] org, int [] pos){
		
		for(int i =0; i < org.length; i++){
			org[i][1]= org[i][1]+pos[0];
			org[i][0]= org[i][0]+pos[1];
				// They change her because of row/column vs x/y
			}
		}

	public int [] [] rotate90CW(int [] [] org){
			
		int newWidth=0;
		
		for(int i=0; i < org.length; i++){
			if(org[i][0] > newWidth){
				newWidth=org[i][0];
			}
		}

		int [] [] next = new int [org.length] [2];

			for(int i=0; i < org.length; i ++){
				next[i][0] = org[i][1]; // 1
				next[i][1] = newWidth -org[i][0]; // 3 - 0 = 3
			}

			return next;
	}
	
	 public static boolean getRandomBoolean() {
	       return Math.random() < 0.5;
	  
	   }
	 
	public int [] []transpose(int [] [] a){
		int [] [] temp = new int [a.length] [2];
		for(int i=0; i<temp.length; i++){
			temp[i] [0] = a[i] [1];
			temp[i] [1] = a[i] [0];
		}
	return temp;

	}
	
}