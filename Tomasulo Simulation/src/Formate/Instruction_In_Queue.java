package Formate;

public class Instruction_In_Queue {
	public int destination;
	public int j;
	public int k;
	public String instructionType;
	public int issue;
	public int cycles;
	public int startEx;
	public int wb;
	public String Tag;

	public Instruction_In_Queue(int destination, int j, int k, String instructionType, int cycles) {
		this.destination = destination;
		this.j = j;
		this.k = k;
		this.instructionType = instructionType;
		this.issue = -1;
		this.cycles = cycles;
		this.wb = -1;
		this.startEx = -1;

	}

	public void Print() {
		System.out.print("instructionType: " + instructionType + " | " + "destination:" + destination + " | " + "j:" + j
				+ " | " + "k:" + k + " | ");
		if (issue != -1)
			System.out.print("issue:" + issue);
		else
			System.out.print("issue:" + "");

		if (startEx != -1)
			System.out.print(" | " + "Ex:" + startEx);
		else
			System.out.print(" | " + "Ex:" + "");

		if (wb != -1)
			System.out.print(" | " + "wb:" + wb);

		else
			System.out.print(" | " + "wb:" + "");

		System.out.println();
	}
	
//	public String Print2() {
//		
//		return instructionType;
//		
//		
//	}

	public String Print2() {
		// TODO Auto-generated method stub
		return instructionType;
	}
	
	public int Print3() {
		// TODO Auto-generated method stub
		return destination;
	}
	
	public int Print4() {
		// TODO Auto-generated method stub
		return j;
	}
	
	public int Print5() {
		// TODO Auto-generated method stub
		return k;
	}
	
	public int Print6() {
		// TODO Auto-generated method stub
		return issue;
	}
	
	public int Print7() {
		// TODO Auto-generated method stub
		return startEx;
	}
	
	public int Print8() {
		// TODO Auto-generated method stub
		return wb;
	}
}
