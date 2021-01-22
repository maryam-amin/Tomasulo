package Formate;

import java.util.LinkedList;

public class Memory {
	public int address;
	public double data;
	static int c = 0;
	public LinkedList<String> Waitinglist;

	public Memory() {
		this.address = c;
		c++;
		this.data = Math.random();
		Waitinglist = new LinkedList<String>();
	}
}
