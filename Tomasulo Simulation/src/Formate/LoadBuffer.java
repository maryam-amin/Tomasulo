package Formate;

public class LoadBuffer {
	public String Tag;
	public Boolean busy;
	public int Address;
	static int countL = 0;
	static int countS = 0;
	public String op;
	public String TAGFORSTORE;
	public double DataToStore;

	public LoadBuffer(String op) {
		this.busy = false;
		this.Address = -1;
		this.op = op;
		this.TAGFORSTORE = "";
		this.DataToStore = 0;
		this.Tag = GenerateTag();
	}

	public LoadBuffer() {

	}

	private String GenerateTag() {

		if (op.equals("L")) {
			countL++;
			return "L" + countL;
		}
		countS++;
		return "S" + countS;
	}

	public void print() {
		if (op.equals("L")) {
			if (Address != -1)
				System.out.println("tag:" + Tag + " | " + "Address:" + Address + " | " + "busy:" + busy);
			else {
				System.out.println("tag:" + Tag + " | " + "Address:" + "" + " | " + "busy:" + busy);
			}
		} else {
			if (Address != -1) {

				System.out.println("tag:" + Tag + " | " + "Address:" + Address + " | " + "waitForTag:" + TAGFORSTORE
						+ " | " + "dataTobeStores:" + DataToStore + " | " + "busy:" + busy);

			} else {
				System.out.println("tag:" + Tag + " | " + "Address:" + "" + " | " + "waitForTag:" + "" + " | "
						+ "dataTobeStores:" + "" + " | " + "busy:" + busy);
			}
		}

	}
	
	public String print2() {

		return Tag;

	}
	
	public String print7() {

		return op;

	}
	public int print3() {

		return Address;

	}
	
	public String print4() {

		return TAGFORSTORE;

	}
	
	public double print5() {

		return DataToStore;

	}
	
	public boolean print6() {

		return busy;

	}
}
