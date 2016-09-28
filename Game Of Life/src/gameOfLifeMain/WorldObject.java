package gameOfLifeMain;

public class WorldObject {
	
	boolean [] [] World = new boolean [600] [600];
	public WorldObject(){	
	}
	
	public WorldObject(int [] pos, boolean alive){
	World[pos[0]] [pos[1]] = alive;	
	}

	
}
