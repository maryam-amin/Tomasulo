package Stages;

import java.util.LinkedList;

import Formate.Instruction_In_Queue;
import Formate.LoadBuffer;
import Formate.Memory;
import Formate.ReservationStation;
import Queues.MyQueue;

public class Execute {
	static LinkedList<Integer> StoresadressInExecution = new LinkedList<Integer>();
	static LinkedList<Integer> LoadsadressInExecution = new LinkedList<Integer>();

	public Execute(int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory) {
		this.ex(cycle, InstructionBuffer, AdditionRS, MulRS, RegFile, StoreBuffer, LoadBuffer, memory);
	}

	void ex(int cycle, MyQueue InstructionBuffer, MyQueue AdditionRS, MyQueue MulRS, MyQueue RegFile,
			MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory) {

		for (int i = 0; i < InstructionBuffer.size(); i++) {
			Instruction_In_Queue I = (Instruction_In_Queue) InstructionBuffer.get(i);
			int issued = I.issue;
			int start = I.startEx;
			String instructionType = I.instructionType;

			if (issued != -1 && start == -1) {
				if (cycle > issued) {
					if (instructionType.equals("MUL") || instructionType.equals("DIV")) {
						for (int c = 0; c < MulRS.size(); c++) {
							if (((ReservationStation) MulRS.get(c)).tag.equals(I.Tag)) {
								if (((ReservationStation) MulRS.get(c)).Qj.equals("")
										&& ((ReservationStation) MulRS.get(c)).Qk.equals("")) {

									((Instruction_In_Queue) InstructionBuffer.get(i)).startEx = cycle;

								}

							}
						}

					}
					if (instructionType.equals("ADD") || instructionType.equals("SUB")) {
						for (int c = 0; c < AdditionRS.size(); c++) {
							if (((ReservationStation) AdditionRS.get(c)).tag.equals(I.Tag)) {
								if (((ReservationStation) AdditionRS.get(c)).Qj.equals("")
										&& ((ReservationStation) AdditionRS.get(c)).Qk.equals("")) {

									((Instruction_In_Queue) InstructionBuffer.get(i)).startEx = cycle;

								}

							}
						}

					}
					if (instructionType.equals("S")) {
						for (int c = 0; c < StoreBuffer.size(); c++) {
							if (((LoadBuffer) StoreBuffer.get(c)).Tag.equals(I.Tag)
									&& ((LoadBuffer) StoreBuffer.get(c)).TAGFORSTORE.equals("")) {

								int address = ((LoadBuffer) StoreBuffer.get(c)).Address;

								for (int m = 0; m < memory.size(); m++) {
									if (((Memory) memory.get(m)).address == address) {

										if (((Memory) memory.get(m)).Waitinglist.getFirst()
												.equals(((LoadBuffer) StoreBuffer.get(c)).Tag)) {
											((Instruction_In_Queue) InstructionBuffer.get(i)).startEx = cycle;

										}
									}
								}

							}
						}
					}
					if (instructionType.equals("L")) {
						for (int c = 0; c < LoadBuffer.size(); c++) {
							if (((LoadBuffer) LoadBuffer.get(c)).Tag.equals(I.Tag)) {
								int address = ((LoadBuffer) LoadBuffer.get(c)).Address;
								for (int m = 0; m < memory.size(); m++) {
									if (((Memory) memory.get(m)).address == address) {

										if (((Memory) memory.get(m)).Waitinglist.getFirst()
												.equals(((LoadBuffer) LoadBuffer.get(c)).Tag)) {
											((Instruction_In_Queue) InstructionBuffer.get(i)).startEx = cycle;

										}
									}
								}

							}
						}
					}

				}
			}
		}
	}

}
