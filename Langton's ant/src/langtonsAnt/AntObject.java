package langtonsAnt;

public class AntObject {
	
	int x;
	int y;
	
	int directionCounter; // Makes handeling direction easier

	
	public AntObject(){
		
	}
	
	public void setPosition(int a, int b){
		x = a;
		y = b;
	}
	
	public void setDirection(String s){
		switch(s){
		case "N":
			directionCounter = 0;
			break;
		case "W":
			directionCounter = 1;
			break;
		case "S":
			directionCounter = 2;
			break;
		case "E":
			directionCounter = 3;
			break;
		}
	}

	public int getXPosition(){
		return x;
	}
	
	public int getYPosition(){
		return y;
	}

	public void move(){
		switch(directionCounter){
		case 0:
			y=y-1;
			break;
		case 2:
			y = y+1;
			break;
		case 1:
			x=x+1;
			break;
		case 3:
			x=x-1;
			break;
		}
		
	}
	
	public void changeDirection(boolean [] a, int [] [] field){
		
		if(a[field [x] [y]]){
			directionCounter=absMod(directionCounter +1, 4);
		}else{
			directionCounter=absMod(directionCounter -1, 4);
		}
	}

	public void getDirection(){
		switch(directionCounter){
		case 0:
			System.out.println("N");
			break;
		case 1:
			System.out.println("E");
			break;
		case 2:
			System.out.println("S");
			break;
		case 3:
			System.out.println("W");
			break;	
		}
	}
	
	public void putDirectionCounter(){
		System.out.println(directionCounter);
	}
	
	 private static int absMod(int a, int mod){
			if(a >= 0){
				return a%mod;
			}else{
				return mod + a%mod;
			}
		}
}
