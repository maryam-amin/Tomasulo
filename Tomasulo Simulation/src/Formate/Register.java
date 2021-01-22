package Formate;

public class Register {
	public double data;
	public int r;
	public String tag;

	public Register(int r, int data) {
		this.r = r;
		this.data = data;
		this.tag = "";

	}

	public void print() {

		System.out.println("Register: " + r + " | " + "Tag:" + tag + " | " + "data:" + data);

	}
	
	public int print2() {

		return r;

	}

	public String print3() {

		return tag;

	}
	
	public double print4() {

		return data;

	}
}