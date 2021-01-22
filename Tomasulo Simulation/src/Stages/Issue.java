package Stages;

import Formate.Instruction_In_Queue;
import Formate.LoadBuffer;
import Formate.Memory;
import Formate.ReservationStation;
import Formate.Register;
import Queues.MyQueue;

public class Issue {
	public Issue(int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory) {
		this.Issuee(cycle, InstructionBuffer, AdditionRS, MulRS, RegFile, StoreBuffer, LoadBuffer, memory);

	}

	void Issuee(int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory) {
		for (int i = 0; i < InstructionBuffer.size(); i++) {
			Instruction_In_Queue I = (Instruction_In_Queue) InstructionBuffer.get(i);
			if (I.issue == -1) {
				String tag = "";
				boolean flag = false;
				String instructionType = I.instructionType;
				int j = I.j;
				int k = I.k;
				int rs = I.destination;
				if (instructionType.equals("MUL") || instructionType.equals("DIV")) {
					int AvailableSlot = MulRS.getAvialableForRS();
					if (AvailableSlot != -1) {
						flag = true;
						((ReservationStation) MulRS.get(AvailableSlot)).busy = true;
						((ReservationStation) MulRS.get(AvailableSlot)).op = instructionType;
						tag = ((ReservationStation) MulRS.get(AvailableSlot)).tag;
						for (int c = 0; c < RegFile.size(); c++) {
							Register rr = ((Register) RegFile.get(c));
							if (j == rr.r) {
								if (rr.tag.equals(""))
									((ReservationStation) MulRS.get(AvailableSlot)).Vj = rr.data;
								else
									((ReservationStation) MulRS.get(AvailableSlot)).Qj = rr.tag;
							}
							if (k == rr.r) {
								if (rr.tag.equals(""))
									((ReservationStation) MulRS.get(AvailableSlot)).Vk = rr.data;
								else
									((ReservationStation) MulRS.get(AvailableSlot)).Qk = rr.tag;
							}
						}

						for (int x = 0; x < RegFile.size(); x++) {
							if (rs == ((Register) RegFile.get(x)).r) {
								((Register) RegFile.get(x)).tag = ((ReservationStation) MulRS.get(AvailableSlot)).tag;
								break;

							}
						}
					}
				} else {
					if (instructionType.equals("ADD") || instructionType.equals("SUB")) {
						int AvailableSlot = AdditionRS.getAvialableForRS();
						if (AvailableSlot != -1) {
							flag = true;

							((ReservationStation) AdditionRS.get(AvailableSlot)).busy = true;
							((ReservationStation) AdditionRS.get(AvailableSlot)).op = instructionType;
							tag = ((ReservationStation) AdditionRS.get(AvailableSlot)).tag;

							for (int c = 0; c < RegFile.size(); c++) {
								Register rr = ((Register) RegFile.get(c));
								if (j == rr.r) {
									if (rr.tag.equals(""))
										((ReservationStation) AdditionRS.get(AvailableSlot)).Vj = rr.data;
									else
										((ReservationStation) AdditionRS.get(AvailableSlot)).Qj = rr.tag;
								}
								if (k == rr.r) {
									if (rr.tag.equals(""))
										((ReservationStation) AdditionRS.get(AvailableSlot)).Vk = rr.data;
									else
										((ReservationStation) AdditionRS.get(AvailableSlot)).Qk = rr.tag;

								}
							}

							for (int x = 0; x < RegFile.size(); x++) {
								if (rs == ((Register) RegFile.get(x)).r) {
									((Register) RegFile.get(x)).tag = ((ReservationStation) AdditionRS
											.get(AvailableSlot)).tag;
									break;

								}
							}

						}
					} else {
						if (instructionType.equals("S")) {
							int AvailableSlot = StoreBuffer.getAvialableForLB();
							if (AvailableSlot != -1) {
								flag = true;
								tag = ((LoadBuffer) StoreBuffer.get(AvailableSlot)).Tag;
								((LoadBuffer) StoreBuffer.get(AvailableSlot)).busy = true;

								for (int c = 0; c < RegFile.size(); c++) {
									Register rr = ((Register) RegFile.get(c));
									if (j == ((Register) RegFile.get(c)).r) {
										j = (int) ((Register) RegFile.get(c)).data;

									}
									if (rr.r == rs) {
										if (!rr.tag.equals("")) {
											((LoadBuffer) StoreBuffer.get(AvailableSlot)).TAGFORSTORE = rr.tag;
										} else {
											((LoadBuffer) StoreBuffer.get(AvailableSlot)).DataToStore = rr.data;
										}

									}
								}
								((LoadBuffer) StoreBuffer.get(AvailableSlot)).Address = j + k;
								for (int c = 0; c < memory.size(); c++) {
									if (((Memory) memory.get(c)).address == j + k) {
										((Memory) memory.get(c)).Waitinglist.add(tag);
									}
								}
							}
						} else {
							int AvailableSlot = LoadBuffer.getAvialableForLB();
							if (AvailableSlot != -1) {
								flag = true;
								tag = ((LoadBuffer) LoadBuffer.get(AvailableSlot)).Tag;
								((LoadBuffer) LoadBuffer.get(AvailableSlot)).busy = true;
								for (int x = 0; x < RegFile.size(); x++) {
									if (rs == ((Register) RegFile.get(x)).r) {
										((Register) RegFile.get(x)).tag = tag;

									}
									if (j == ((Register) RegFile.get(x)).r) {
										j = (int) ((Register) RegFile.get(x)).data;

									}
								}

								((LoadBuffer) LoadBuffer.get(AvailableSlot)).Address = j + k;

								for (int c = 0; c < memory.size(); c++) {
									if (((Memory) memory.get(c)).address == j + k) {
										((Memory) memory.get(c)).Waitinglist.add(tag);
									}
								}

							}

						}
					}
				}
				if (flag) {
					((Instruction_In_Queue) InstructionBuffer.get(i)).issue = cycle;
					((Instruction_In_Queue) InstructionBuffer.get(i)).Tag = tag;
					return;
				}
			}
		}

	}

}
