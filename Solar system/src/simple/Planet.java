package simple;

import java.awt.Color;

public class Planet {

	private double r, d, v, fi;
	private Planet host;
	private boolean revolveCenter = false;
	private Color c;
	
	
	public Planet(double r, double d, double v, double fi, Planet host, Color color){
		this.r =r;
		this.d = d;
		this.v = v;
		this.fi = fi;
		this.c = color;
		
		// set this.host = host;
		this.host = host;
		
		
		
	}
	
	private double width =0;
	private double height =0;

	public Planet(double r, double d, double v, double fi, double width, double height, Color color){
		revolveCenter = true;
		this.r =r;
		this.d = d;
		this.v = v;
		this.fi = fi;
		this.c = color;
		
		this.width = width;
		this.height = height;
		
		
	}

	
	public void move(){
		this.fi += v;
	}

	public double getR() {
		return r;
	}


	public void setR(double r) {
		this.r = r;
	}


	public double getD() {
		return d;
	}


	public void setD(double d) {
		this.d = d;
	}


	public double getV() {
		return v;
	}


	public void setV(double v) {
		this.v = v;
	}


	public double getFi() {
		return fi;
	}


	public void setFi(double fi) {
		this.fi = fi;
	}
	
	public void add(Planet p){
	
	}
	
	
	public double getSpaceX(){
		if(revolveCenter){
			return this.width/2+this.d * Math.cos(this.fi);
		} else{
			return this.host.getSpaceX() + this.d * Math.cos(this.fi);
		}
	}
	
	public double getSpaceY(){
		if(revolveCenter){
			return this.height/2+this.d * Math.sin(this.fi);
		} else{
			return this.host.getSpaceY() + this.d * Math.sin(this.fi);
		}
	}

	public double getFrameX(){
		return this.getSpaceX() - this.r;
}
	
	public double getFrameY(){
			return this.getSpaceY() - this.r;
	}
	
	public Color getColor(){
		return this.c;
	}

	
}
