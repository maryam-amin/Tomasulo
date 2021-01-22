package Formate;

public class ReservationStation {
	public String tag;
	public boolean busy;
	public String op;
	public double Vj;
	public double Vk;
	public String Qj;
	public String Qk;
	public String A;
	static int countM = 0;
	static int countA = 0;

	public ReservationStation(String op) {
		this.busy = false;
		this.op = op;
		this.Vj = -1;
		this.Vk = -1;
		this.Qk = "";
		this.Qj = "";
		this.tag = generateTag();
	}

	public ReservationStation() {

	}

	private String generateTag() {

		if (this.op.equals("MUL")) {
			countM++;
			return "M" + countM;
		} else {
			countA++;
			return "A" + countA;
		}
	}

	public void print() {
		if (busy == false)
			System.out.println("tag:" + tag + " | " + "op:" + "" + " | " + "Vj:" + "" + " | " + "Vk:" + "" + " | "
					+ "Qj:" + "" + " | " + "Qk: " + "" + " | " + "busy:" + busy);
		else {
			System.out.print("tag:" + tag + " | " + "op:" + op);
			if (Vj != -1)
				System.out.print(" | " + "Vj:" + Vj);
			else
				System.out.print(" | " + "Vj:" + "");

			if (Vk != -1)
				System.out.print(" | " + "Vk:" + Vk);
			else
				System.out.print(" | " + "Vk:" + "");

			System.out.println(" | " + "Qj:" + Qj + " | " + "Qk:" + Qk + " | " + busy);
			

		}
	}
	
	public String print2() {
		
		return tag;
			

	}
	
	public String print3() {
		
		return op;
			

	}
	
	public double print4() {
		
		return Vj;
			

	}
	
	public double print5() {
		
		return Vk;
			

	}
	
	public String print6() {
		
		return Qj;
			

	}
	
	public String print7() {
		
		return Qk;
			

	}
	
	public boolean print8() {
		
		return busy;
			

	}
	

}
