package rules;

public class WorldRules {
	public static final boolean RIGHT = true;
	public static final boolean LEFT = false;
	
	public WorldRules(){
		
	}
	
	public boolean[] basic(){
		boolean [] a = {RIGHT, LEFT};
		return a;
	}
	
	public boolean[] basicChaos(){
		boolean [] a = {RIGHT, LEFT, LEFT};
		return a;
	}
	
	public boolean[] basicHeighway(){
		boolean [] a = {RIGHT, RIGHT, LEFT};
		return a;
	}
	
	public boolean[] mediumHeighway(){
		boolean [] a = {RIGHT, LEFT, RIGHT, LEFT, RIGHT, LEFT, LEFT, RIGHT, LEFT, RIGHT};
		return a;
	}
	
	
	public boolean[] largeHeighway(){
		boolean [] a = {RIGHT, RIGHT, LEFT, RIGHT, LEFT, LEFT, RIGHT, LEFT, RIGHT, RIGHT};
		return a;
	}
	
	public boolean[] grassHopper(){
		boolean []a = {LEFT, LEFT, RIGHT, RIGHT, RIGHT, LEFT, RIGHT, LEFT, RIGHT, LEFT, LEFT, RIGHT};
		return a;
	}
	
	public boolean[] pyramid(){ // Måste ändra första färgen;
		boolean []a = {RIGHT, RIGHT, LEFT, LEFT, LEFT, RIGHT, RIGHT, RIGHT, RIGHT, RIGHT, LEFT, RIGHT};
		return a;
	}
	
	public boolean[] pythagoran(){
		boolean [] a= {RIGHT, RIGHT, LEFT, RIGHT, LEFT, LEFT, RIGHT, RIGHT, RIGHT, RIGHT, RIGHT, RIGHT};
		return a;
	}
	
	public boolean[] square(){
		boolean[] a = {RIGHT, RIGHT, LEFT, RIGHT, RIGHT};
		return a;
	}
	
	public boolean[] spiral(){
		boolean[]a ={LEFT, RIGHT, RIGHT, RIGHT, RIGHT,LEFT, LEFT, LEFT, RIGHT, RIGHT, RIGHT};
		return a;
	}
	
	public boolean[] heart(){
		boolean[] a = {LEFT, LEFT, RIGHT, RIGHT};
		return a;
	}
	
	public boolean[] fibbinacci(){
		boolean [] a = {RIGHT, LEFT, LEFT, LEFT, LEFT, RIGHT, RIGHT, RIGHT, LEFT, LEFT, LEFT, RIGHT};
		return a;
	}

}
