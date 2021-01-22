package Stages;

import java.util.LinkedList;

import Formate.Instruction_In_Queue;
import Formate.LoadBuffer;
import Formate.Memory;
import Formate.Register;
import Formate.ReservationStation;
import Queues.MyQueue;

public class WriteBack {
	static LinkedList<Instruction_In_Queue> waitingInstruction = new LinkedList<>();
	static LinkedList<Integer> DoneWithCycles = new LinkedList<>();

	public WriteBack(int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory) {
		this.wb(cycle, InstructionBuffer, AdditionRS, MulRS, RegFile, StoreBuffer, LoadBuffer, memory);
	}

	void wb(int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue Memory) {

		if (!waitingInstruction.isEmpty()) {
			Instruction_In_Queue Target = waitingInstruction.getFirst();
			boolean flag = false;
			for (int i = 0; i < InstructionBuffer.size(); i++) {
				Instruction_In_Queue I = (Instruction_In_Queue) InstructionBuffer.get(i);
				int start = I.startEx;
				int end = start + I.cycles;

				if (!flag) {
					if (I.Tag.equals(Target.Tag)) {
						waitingInstruction.remove(Target);
						flag = true;
						helper(i, cycle, InstructionBuffer, AdditionRS, MulRS, RegFile, StoreBuffer, LoadBuffer,
								Memory);

					}
				}

				if (cycle == end) {
					DoneWithCycles.add(cycle);
					waitingInstruction.add(I);
				}

			}

		} else

		{

			for (int i = 0; i < InstructionBuffer.size(); i++) {
				Instruction_In_Queue I = (Instruction_In_Queue) InstructionBuffer.get(i);
				int start = I.startEx;
				int wb = I.wb;

				if (start != -1 && wb == -1) {
					int end = start + I.cycles;

					if (cycle == end) {
						if (DoneWithCycles.contains(cycle))

							waitingInstruction.add(I);
						else {

							DoneWithCycles.add(cycle);
							helper(i, cycle, InstructionBuffer, AdditionRS, MulRS, RegFile, StoreBuffer, LoadBuffer,
									Memory);

						}

					}
				}
			}
		}
	}

	void helper(int i, int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue Memory) {
		Instruction_In_Queue I = (Instruction_In_Queue) InstructionBuffer.get(i);

		String instructionType = I.instructionType;
		String TAG = I.Tag;

		double WB = -1;
		if (instructionType.equals("MUL") || instructionType.equals("DIV")) {
			for (int x = 0; x < MulRS.size(); x++) {
				if (((ReservationStation) MulRS.get(x)).tag.equals(TAG)) {
					double Vj = ((ReservationStation) MulRS.get(x)).Vj;
					double Vk = ((ReservationStation) MulRS.get(x)).Vk;

					((ReservationStation) MulRS.get(x)).busy = false;
					((ReservationStation) MulRS.get(x)).op = "";
					((ReservationStation) MulRS.get(x)).Vj = -1;
					((ReservationStation) MulRS.get(x)).Vk = -1;
					((ReservationStation) MulRS.get(x)).Qk = "";
					((ReservationStation) MulRS.get(x)).Qj = "";

					if (instructionType.equals("MUL"))
						WB = Vj * Vk;
					else
						WB = Vj / Vk;

					break;

				}

			}
		}
		if (instructionType.equals("ADD") || instructionType.equals("SUB")) {
			for (int x = 0; x < AdditionRS.size(); x++) {
				if (((ReservationStation) AdditionRS.get(x)).tag.equals(TAG)) {
					double Vj = ((ReservationStation) AdditionRS.get(x)).Vj;
					double Vk = ((ReservationStation) AdditionRS.get(x)).Vk;

					((ReservationStation) AdditionRS.get(x)).busy = false;
					((ReservationStation) AdditionRS.get(x)).op = "";
					((ReservationStation) AdditionRS.get(x)).Vj = -1;
					((ReservationStation) AdditionRS.get(x)).Vk = -1;
					((ReservationStation) AdditionRS.get(x)).Qk = "";
					((ReservationStation) AdditionRS.get(x)).Qj = "";

					if (instructionType.equals("ADD"))
						WB = Vj + Vk;
					else
						WB = Vj - Vk;

					break;

				}

			}
		}
		if (instructionType.equals("L")) {
			for (int x = 0; x < LoadBuffer.size(); x++) {
				if (((LoadBuffer) LoadBuffer.get(x)).Tag.equals(TAG)) {
					int address = ((LoadBuffer) LoadBuffer.get(x)).Address;

					((LoadBuffer) LoadBuffer.get(x)).busy = false;

					((LoadBuffer) LoadBuffer.get(x)).Address = -1;
					for (int l = 0; l < Memory.size(); l++) {
						if (address == ((Memory) Memory.get(l)).address) {
							WB = ((Memory) Memory.get(l)).data;
							((Memory) Memory.get(l)).Waitinglist.remove(TAG);
							break;
						}
					}

				}

			}
		}
		if (instructionType.equals("S")) {
			for (int x = 0; x < StoreBuffer.size(); x++) {
				if (((LoadBuffer) StoreBuffer.get(x)).Tag.equals(TAG)) {
					int address = ((LoadBuffer) StoreBuffer.get(x)).Address;
					double data = ((LoadBuffer) StoreBuffer.get(x)).DataToStore;
					((LoadBuffer) StoreBuffer.get(x)).busy = false;
					((LoadBuffer) StoreBuffer.get(x)).DataToStore = 0;
					((LoadBuffer) StoreBuffer.get(x)).Address = -1;
					((LoadBuffer) StoreBuffer.get(x)).TAGFORSTORE = "";
					for (int l = 0; l < Memory.size(); l++) {
						if (address == ((Memory) Memory.get(l)).address) {
							((Memory) Memory.get(l)).data = data;
							((Memory) Memory.get(l)).Waitinglist.remove(TAG);
							break;
						}
					}

				}

			}
		}

		((Instruction_In_Queue) InstructionBuffer.get(i)).wb = cycle;

		for (int c = 0; c < RegFile.size(); c++) {
			if (((Register) RegFile.get(c)).tag.equals(TAG)) {
				((Register) RegFile.get(c)).tag = "";
				((Register) RegFile.get(c)).data = WB;
			}

		}

		for (int c = 0; c < AdditionRS.size(); c++) {
			if (((ReservationStation) AdditionRS.get(c)).Qj.equals(TAG)) {
				((ReservationStation) AdditionRS.get(c)).Qj = "";
				((ReservationStation) AdditionRS.get(c)).Vj = WB;

			}
			if (((ReservationStation) AdditionRS.get(c)).Qk.equals(TAG)) {
				((ReservationStation) AdditionRS.get(c)).Qk = "";
				((ReservationStation) AdditionRS.get(c)).Vk = WB;

			}

		}
		for (int c = 0; c < MulRS.size(); c++) {
			if (((ReservationStation) MulRS.get(c)).Qj.equals(TAG)) {
				((ReservationStation) MulRS.get(c)).Qj = "";
				((ReservationStation) MulRS.get(c)).Vj = WB;

			}
			if (((ReservationStation) MulRS.get(c)).Qk.equals(TAG)) {
				((ReservationStation) MulRS.get(c)).Qk = "";
				((ReservationStation) MulRS.get(c)).Vk = WB;

			}

		}
		for (int c = 0; c < StoreBuffer.size(); c++) {
			if (((LoadBuffer) StoreBuffer.get(c)).TAGFORSTORE.equals(TAG)) {
				((LoadBuffer) StoreBuffer.get(c)).DataToStore = WB;
				((LoadBuffer) StoreBuffer.get(c)).TAGFORSTORE = "";

			}
		}

	}

}
