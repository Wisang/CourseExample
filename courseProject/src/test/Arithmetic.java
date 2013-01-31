package test;

public class Arithmetic {
	private double first;
	private double second;
	
	public void setFirst(double value) {
		this.first = value;
	}
	
	public void setSecond(double value) {
		this.second = value;
	}
	
	public double sum() {
		return first + second;
	}
	
	public double subtract() {
		return first - second;
	}
	
	public double multiply() {
		return first * second;
	}
	
	public Double divide() {
		return first / second;
	}
}
