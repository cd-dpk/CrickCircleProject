/**
 *	It is the very first class of this project
 *	It was written at Shahidullah Hall, University of Dhaka
 *	One of my friends named Atik's room		
 * 	May be dated March 10, 2014 just 2 days before of mid-term presentation of SPL-I
 * 	Another friend named Saif was with me
 * 
 * 	We have done  so many changes on many classes
 * 	But we rarely have  done any changes here
 * 	Actually, We have changed this class only 3 times
 *  
 *  This class is the base of this project
 */
package cricket.entities;

import java.awt.Color;
import java.io.Serializable;
import cricket.constant.Value;

public class Sector implements Serializable{

	private String sectorName;
	private double  range;
	private Value nature;
	private int x,y;
	private int r;
	private double start;
	private double end;
	private int point;
	private double statValue;
	private int sectorId;
	private Color color;
	private String image;
	
	public Sector(String name){
		setSectorName(name);
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getSectorName() {
		return sectorName;
	}
	
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	
	public Value getNature() {
		return nature;
	}

	public void setNature(Value nature) {
		this.nature = nature;
	}
 

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public String toString(){
		
		return sectorName;
	}
	
	
	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	
	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public double getStatValue() {
		return statValue;
	}

	public void setStatValue(double statValue) {
		this.statValue = statValue;
	}

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
}