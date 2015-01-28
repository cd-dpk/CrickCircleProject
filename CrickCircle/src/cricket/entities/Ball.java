package cricket.entities;
import java.io.Serializable;

public class Ball implements Serializable  {

	public  double intitialVelocity=0;
	public  long totalTimeofRotate=0;
	public long selectionTime=0;
	public long selectionTimeInSys=0;
	public long totalTimeofRotateInSys=0;
	public double tangentValue=0.0;
	public int relativeX=0;
	public int relativeY=0;
	public int actualX=0, actualY=0;
	public double instantTime= 0.0;
	public double instantVelocity = 0.0;
	public double prevArgc=0.0;
	public double newArgc=0.0;
	public double acceleration=0;
	
	public double getIntitialVelocity() {
		return intitialVelocity;
	}
	public void setIntitialVelocity(double intitialVelocity) {
		this.intitialVelocity = intitialVelocity;
	}
	public long getTotalTimeofRotate() {
		return totalTimeofRotate;
	}
	public void setTotalTimeofRotate(long totalTimeofRotate) {
		this.totalTimeofRotate = totalTimeofRotate;
	}
	public long getSelectionTime() {
		return selectionTime;
	}
	public void setSelectionTime(long selectionTime) {
		this.selectionTime = selectionTime;
	}
	public long getSelectionTimeInSys() {
		return selectionTimeInSys;
	}
	public void setSelectionTimeInSys(long selectionTimeInSys) {
		this.selectionTimeInSys = selectionTimeInSys;
	}
	public long getTotalTimeofRotateInSys() {
		return totalTimeofRotateInSys;
	}
	public void setTotalTimeofRotateInSys(long totalTimeofRotateInSys) {
		this.totalTimeofRotateInSys = totalTimeofRotateInSys;
	}
	public double getTangentValue() {
		return tangentValue;
	}
	public void setTangentValue(double tangentValue) {
		this.tangentValue = tangentValue;
	}
	public int getRelativeX() {
		return relativeX;
	}
	public void setRelativeX(int relativeX) {
		this.relativeX = relativeX;
	}
	public int getRelativeY() {
		return relativeY;
	}
	public void setRelativeY(int relativeY) {
		this.relativeY = relativeY;
	}
	public int getActualX() {
		return actualX;
	}
	public void setActualX(int actualX) {
		this.actualX = actualX;
	}
	public int getActualY() {
		return actualY;
	}
	public void setActualY(int actualY) {
		this.actualY = actualY;
	}
	public double getInstantTime() {
		return instantTime;
	}
	public void setInstantTime(double instantTime) {
		this.instantTime = instantTime;
	}
	public double getInstantVelocity() {
		return instantVelocity;
	}
	public void setInstantVelocity(double instantVelocity) {
		this.instantVelocity = instantVelocity;
	}
	public double getPrevArgc() {
		return prevArgc;
	}
	public void setPrevArgc(double prevArgc) {
		this.prevArgc = prevArgc;
	}
	public double getNewArgc() {
		return newArgc;
	}
	public void setNewArgc(double newArgc) {
		this.newArgc = newArgc;
	}
	public double getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
}
