package Queues;

import java.util.LinkedList;

import Formate.LoadBuffer;
import Formate.ReservationStation;

public class MyQueue {

	int size;
	LinkedList<Object> Queue;
	public int occupied;

	public MyQueue(int size) {
		Queue = new LinkedList<Object>();
		this.size = size;
		this.occupied=0;
	}

	public void add(Object O) {
		if (Queue.size() < this.size) {
			Queue.add(O);
			occupied++;
		} else {
			System.out.println("Queue is Fulll You Can't do this");
		}

	}
	

	public int size() {
		return this.size;
	}
	public Object get(int i) {
		return Queue.get(i);
	}
	public int getAvialableForRS() {
		for (int i =0 ;i<Queue.size();i++) {
			ReservationStation rs =(ReservationStation) Queue.get(i);
			if(!rs.busy) {
				return i ;
			}
		}
		return -1;
	}
	
	public int getAvialableForLB() {
		for (int i =0 ;i<Queue.size();i++) {
			LoadBuffer rs =(LoadBuffer) Queue.get(i);
			if(!rs.busy) {
				return i ;
			}
		}
		return -1;
	}
	
	
	
}
