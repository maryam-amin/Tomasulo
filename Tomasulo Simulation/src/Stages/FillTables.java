package Stages;

import Formate.Instruction_In_Queue;
import Formate.LoadBuffer;
import Formate.Memory;
import Formate.ReservationStation;
import Formate.Register;
import Queues.MyQueue;

public class FillTables {

	public FillTables(String[] InstructionsInput, MyQueue InstructionBuffer, MyQueue RegisterFile, MyQueue AdditionRS,
			MyQueue MulRS, MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue Memory) {
		this.FillInstructionTable(InstructionsInput, InstructionBuffer, RegisterFile);
		this.FillAdditionRS(AdditionRS);
		this.FillMulRS(MulRS);
		this.FillStoreBuffer(StoreBuffer);
		this.FillLoadBuffer(LoadBuffer);
		this.FillRegister(RegisterFile);
		this.FillMemory(Memory);

	}

	void FillInstructionTable(String[] s, MyQueue InstructionBuffer, MyQueue RegisterFile) {
		for (int i = 0; i < s.length; i = i + 5) {

			String op = s[0 + i];


			int destination = Integer.parseInt(s[1 + i]);
			int cycles = Integer.parseInt(s[4 + i]);
			int j = -1;
			int k = -1;
			if (op.equals("S") || op.equals("L")) {
				j = Integer.parseInt(s[3 + i]);
				k = Integer.parseInt(s[2 + i]);
			} else {
				j = Integer.parseInt(s[2 + i]);
				k = Integer.parseInt(s[3 + i]);
			}

			Instruction_In_Queue I = new Instruction_In_Queue(destination, j, k, op, cycles);
			InstructionBuffer.add(I);

		}

	}

	void FillAdditionRS(MyQueue AdditionRS) {

		ReservationStation rs = new ReservationStation();
		for (int c = 0; c < AdditionRS.size(); c++) {
			rs = new ReservationStation("ADD");
			AdditionRS.add(rs);
		}
	}

	void FillMulRS(MyQueue MulRS) {

		ReservationStation rs = new ReservationStation();

		for (int c = 0; c < MulRS.size(); c++) {
			rs = new ReservationStation("MUL");
			MulRS.add(rs);
		}
	}

	void FillLoadBuffer(MyQueue LoadBuffer) {

		LoadBuffer LB = new LoadBuffer();

		for (int c = 0; c < LoadBuffer.size(); c++) {
			LB = new LoadBuffer("L");
			LoadBuffer.add(LB);
		}
	}

	void FillStoreBuffer(MyQueue StoreBuffer) {

		LoadBuffer SB = new LoadBuffer();

		for (int c = 0; c < StoreBuffer.size(); c++) {
			SB = new LoadBuffer("S");
			StoreBuffer.add(SB);
		}

	}

	void FillMemory(MyQueue memory) {

		Memory m = new Memory();
		for (int c = 0; c < memory.size(); c++) {
			m = new Memory();
			memory.add(m);
		}
	}

	void FillRegister(MyQueue RegisterFile) {
		for (int c = 0; c < RegisterFile.size(); c++) {
			Register r = new Register(c, c);
			RegisterFile.add(r);
		}
	}

}
