package langtonsAnt;

public class AntWorldObject {
	
	int []	[] colorField;
	
	boolean [] colorArray;
	
	
	public AntWorldObject(){
		
	}
	
	public void setSize(int x, int y){
		colorField = new int [x] [y];
	}
	
	public void setStartWorld(){
		for(int i=0; i<colorField.length; i++){
			for(int j=0; j<colorField [0].length; j++){
				colorField[i][j]= 0;
			}
		}
	}

	public void setColors(boolean [] a){
		colorArray = new boolean [a.length];
		for(int i=0; i < a.length; i++){
			colorArray[i] = a[i];
		}
	}

	public int [] [] getIntField(){
		return colorField;
	}

	public boolean [] getBolArray(){
		return colorArray;
	}

	public void nextColor(int x, int y){
		colorField[x][y] = (colorField[x][y]+1)%(colorArray.length);
	}

	 private static int absMod(int a, int mod){
			if(a >= 0){
				return a;
			}else{
				return mod + a;
			}
		}

}
