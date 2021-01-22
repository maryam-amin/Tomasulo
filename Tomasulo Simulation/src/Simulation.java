import Stages.FillTables;
import Stages.Issue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Formate.Instruction_In_Queue;
import Formate.LoadBuffer;
import Formate.Memory;
import Formate.Register;
import Formate.ReservationStation;
import Queues.MyQueue;
import Stages.Execute;
import Stages.WriteBack;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Simulation {
	boolean instructionTable = true;
	boolean addTable = false;
	boolean mulTable = false;
	boolean lBuffer = false;
	boolean sBuffer = false;
	boolean registerTable = false;
	public Simulation(JFrame frame,String[] InstructionsInput, MyQueue InstructionBuffer, MyQueue RegisterFile, MyQueue AdditionRS,
			MyQueue MulRS, MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory, int cycles,
			LinkedList rEGISTERDESTINATION) {
		simulate(frame, InstructionsInput, InstructionBuffer, RegisterFile, AdditionRS, MulRS, StoreBuffer, LoadBuffer, memory,
				cycles, rEGISTERDESTINATION);
	}

	void simulate(JFrame frame, String[] InstructionsInput, MyQueue InstructionBuffer, MyQueue RegisterFile, MyQueue AdditionRS,
			MyQueue MulRS, MyQueue StoreBuffer, MyQueue LoadBuffer, MyQueue memory, int cycles,
			LinkedList rEGISTERDESTINATION) {
		
	
		
		;
		

		Object[][] data = new String[2000][8];
		String[] instructionType1 = new String[2000];
		int[] destination1  = new int[2000];
		int[] j1  = new int[2000];
		int[] k1  = new int[2000];
		int[] issue1  = new int[2000];
		int[] ex1  = new int[2000];
		int[] wb1  = new int[2000];
		int temp = 0;
		int temp1 = 0;
		
		Object[][] data2 = new String[2000][8];
		String[] tag1 = new String[2000];
		String[] op1  = new String[2000];
		double[] vj1  = new double[2000];
		double[] vk1  = new double[2000];
		String[] qj1  = new String[2000];
		String[] qk1  = new String[2000];
		boolean[] busy1  = new boolean[2000];
		int temp2 = 0;
		int temp2_ = 0;
		
		Object[][] data3 = new String[2000][8];
		String[] tag3 = new String[2000];
		String[] op3  = new String[2000];
		double[] vj3  = new double[2000];
		double[] vk3  = new double[2000];
		String[] qj3  = new String[2000];
		String[] qk3  = new String[2000];
		boolean[] busy3  = new boolean[2000];
		int temp3 = 0;
		int temp3_ = 0;
		
		Object[][] data4 = new String[2000][6];
		String[] tag4 = new String[2000];
		int[] address4  = new int[2000];
		String[] tagforstore4 = new String[2000];
		double[] dataforstore4 = new double[2000];
		String[] op4 = new String[2000];
		boolean[] busy4  = new boolean[2000];
		int temp4 = 0;
		int temp4_ = 0;
		
		Object[][] data5 = new String[2000][6];
		String[] tag5 = new String[2000];
		int[] address5  = new int[2000];
		String[] tagforstore5 = new String[2000];
		double[] dataforstore5 = new double[2000];
		String[] op5 = new String[2000];
		boolean[] busy5  = new boolean[2000];
		int temp5 = 0;
		int temp5_ = 0;
		
//		ArrayList[][] data6 = new ArrayList[2000][4];
		Object[][] data6 = new String[2000][4];
		String[] tag6 = new String[2000];
		double[] data_6 = new double[2000];
		int[] register6 = new int[2000];
		int temp6 = 0;
		int temp6_ = 0;
		
		FillTables fill = new FillTables(InstructionsInput, InstructionBuffer, RegisterFile, AdditionRS, MulRS,
				StoreBuffer, LoadBuffer, memory);
		
		for (int i = 1; i <= cycles; i++) {

			Issue issue = new Issue(i, InstructionBuffer, AdditionRS, MulRS, RegisterFile, StoreBuffer, LoadBuffer,
					memory);

			Execute exec = new Execute(i, InstructionBuffer, AdditionRS, MulRS, RegisterFile, StoreBuffer, LoadBuffer,
					memory);

			WriteBack wb = new WriteBack(i, InstructionBuffer, AdditionRS, MulRS, RegisterFile, StoreBuffer, LoadBuffer,
					memory);

			System.out.println(("************************************************CYCLE =>") + i
					+ "**********************************************");
			System.out.println(("_______________________________________________________________________________"));
			System.out.println(("                                 Instruction Table "));
			for (int c = 0; c <= InstructionBuffer.size(); c++) {
				System.out.print(("               "));
			 	if(c == InstructionBuffer.size() ) {
			 		
			 		
			 	}
			 	else {
			 		
			 	
				((Instruction_In_Queue) InstructionBuffer.get(c)).Print();
				 instructionType1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print2());
				 destination1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print3());
				 j1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print4());
				 k1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print5());
				 issue1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print6());
				 ex1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print7());
				 wb1[temp + c] = (((Instruction_In_Queue) InstructionBuffer.get(c)).Print8());

				 	data[temp + c][0] = instructionType1[temp + c];
					data[temp + c][1] = "" + destination1[temp + c];
					data[temp + c][2] = "" + j1[temp + c];
					data[temp + c][3] = "" + k1[temp + c];
					if(issue1[temp + c] != -1)
					data[temp + c][4] = "" + issue1[temp + c];
					if(ex1[temp + c] != -1)
					data[temp + c][5] = "" + ex1[temp + c];
					if(wb1[temp + c] != -1)
					data[temp + c][6] = "" + wb1[temp + c];
					data[temp + c][7] = "" + (i);
			 	}
					temp1 = c;
					
					
			}
			temp = temp + temp1 + 1;
			System.out.println(("_______________________________________________________________________________"));
			System.out.println(("                                 Add/Sub Rs"));
			for (int c = 0; c <= AdditionRS.size(); c++) {
				System.out.print(("               "));

				
				if(c == AdditionRS.size() ) {
			 		
			 		
			 	}
			 	else {
			 		
			 	
			 	((ReservationStation) AdditionRS.get(c)).print();
				 tag1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print2());
				 op1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print3());
				 vj1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print4());
				 vk1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print5());
				 qj1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print6());
				 qk1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print7());
				 busy1[temp2 + c] = (((ReservationStation) AdditionRS.get(c)).print8());

				 	data2[temp2 + c][0] = tag1[temp2 + c];
				 	if(busy1[temp2 + c]) {
					data2[temp2 + c][1] = "" + op1[temp2 + c];
					if(vj1[temp2 + c] != -1)
					data2[temp2 + c][2] = "" + vj1[temp2 + c];
					if(vk1[temp2 + c] != -1)
					data2[temp2 + c][3] = "" + vk1[temp2 + c];
					
					data2[temp2 + c][4] = "" + qj1[temp2 + c];
					
					data2[temp2 + c][5] = "" + qk1[temp2 + c];
				 	}
					data2[temp2 + c][6] = "" + busy1[temp2 + c];
					data2[temp2 + c][7] = "" + (i);
			 	}
					temp2_ = c;
			}
			temp2 = temp2 + temp2_ + 1;
			System.out.println(("_______________________________________________________________________________"));
			System.out.println(("                                  Mul/Div Rs"));
			for (int c = 0; c <= MulRS.size(); c++) {
				System.out.print(("               "));

				
				if(c == MulRS.size() ) {
			 		
			 		
			 	}
			 	else {
			 		
			 	
			 	((ReservationStation) MulRS.get(c)).print();
				 tag3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print2());
				 op3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print3());
				 vj3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print4());
				 vk3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print5());
				 qj3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print6());
				 qk3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print7());
				 busy3[temp3 + c] = (((ReservationStation) MulRS.get(c)).print8());

				 	data3[temp3 + c][0] = tag3[temp3 + c];
				 	if(busy3[temp3 + c]) {
					data3[temp3 + c][1] = "" + op3[temp3 + c];
					if(vj3[temp3 + c] != -1)
					data3[temp3 + c][2] = "" + vj3[temp3 + c];
					if(vk3[temp3 + c] != -1)
					data3[temp3 + c][3] = "" + vk3[temp3 + c];
					
					data3[temp3 + c][4] = "" + qj3[temp3 + c];
					
					data3[temp3 + c][5] = "" + qk3[temp3 + c];
				 	}
					data3[temp3 + c][6] = "" + busy3[temp3 + c];
					data3[temp3 + c][7] = "" + (i);
			 	}
					temp3_ = c;
			}
			temp3 = temp3 + temp3_ + 1;
			System.out.println(("_______________________________________________________________________________"));
			System.out.println(("                                  L Buffer"));
			for (int c = 0; c <= LoadBuffer.size(); c++) {
				System.out.print(("               "));

				
				if(c == LoadBuffer.size() ) {
			 		
			 		
			 	}
			 	else {
			 		
			 	
			 	((LoadBuffer) LoadBuffer.get(c)).print();
				 tag4[temp4 + c] = (((LoadBuffer) LoadBuffer.get(c)).print2());
				 op4[temp4 + c] = (((LoadBuffer) LoadBuffer.get(c)).print7());
				 address4[temp4 + c] = (((LoadBuffer) LoadBuffer.get(c)).print3());
				 tagforstore4[temp4 + c] = (((LoadBuffer) LoadBuffer.get(c)).print4());
				 dataforstore4[temp4 + c] = (((LoadBuffer) LoadBuffer.get(c)).print5());
				 busy4[temp4 + c] = (((LoadBuffer) LoadBuffer.get(c)).print6());
				 	
				
				 	data4[temp4 + c][0] = tag4[temp4 + c];
				 	if(address4[temp4 + c] != -1)
					data4[temp4 + c][1] = "" + address4[temp4 + c];
					if(!op4[temp4 + c].equals("L") && address4[temp4 + c] != -1) {
					data4[temp4 + c][2] = "" + tagforstore4[temp4 + c];
					data4[temp4 + c][3] = "" + dataforstore4[temp4 + c];
					}
					
					
					data4[temp4 + c][4] = "" + busy4[temp4 + c];
					data4[temp4 + c][5] = "" + (i);
			 	}
					temp4_ = c;
			}
			temp4 = temp4 + temp4_ + 1;
			System.out.println(("_______________________________________________________________________________"));
			System.out.println(("                                  S Buffer"));
			for (int c = 0; c <= StoreBuffer.size(); c++) {
				System.out.print(("               "));

				
				if(c == StoreBuffer.size() ) {
			 		
			 		
			 	}
			 	else {
			 		
			 	
			 	((LoadBuffer) StoreBuffer.get(c)).print();
				 tag5[temp5 + c] = (((LoadBuffer) StoreBuffer.get(c)).print2());
				 op5[temp5 + c] = (((LoadBuffer) StoreBuffer.get(c)).print7());
				 address5[temp5 + c] = (((LoadBuffer) StoreBuffer.get(c)).print3());
				 tagforstore5[temp5 + c] = (((LoadBuffer) StoreBuffer.get(c)).print4());
				 dataforstore5[temp5 + c] = (((LoadBuffer) StoreBuffer.get(c)).print5());
				 busy5[temp5 + c] = (((LoadBuffer) StoreBuffer.get(c)).print6());
				 	
				
				 	data5[temp5 + c][0] = tag5[temp5 + c];
				 	if(address5[temp5 + c] != -1)
					data5[temp5 + c][1] = "" + address5[temp5 + c];
					if(!op5[temp5 + c].equals("L") && address5[temp5 + c] != -1) {
					data5[temp5 + c][2] = "" + tagforstore5[temp5 + c];
					data5[temp5 + c][3] = "" + dataforstore5[temp5 + c];
					}
					
					
					data5[temp5 + c][4] = "" + busy5[temp5 + c];
					data5[temp5 + c][5] = "" + (i);
			 	}
					temp5_ = c;
			}
			temp5 = temp5 + temp5_ + 1;

			System.out.println(("_______________________________________________________________________________"));
			System.out.println(("                                 REGISTERS"));
			for (int c = 0; c <= RegisterFile.size(); c++) {
				if(c == RegisterFile.size()) {
			 		
			 		
			 	}
				else {
//				if (rEGISTERDESTINATION.contains(((Register) RegisterFile.get(c)).r)) {
					System.out.print(("                    "));


					
					
				 	
				 		
				 	
				 	((Register) RegisterFile.get(c)).print();
				 	register6[temp6 + c] = (((Register) RegisterFile.get(c)).print2());
					tag6[temp6 + c] = (((Register) RegisterFile.get(c)).print3());
					data_6[temp6 + c] = (((Register) RegisterFile.get(c)).print4());
					 
					 	
						data6[temp6 + c][0] = "" + register6[temp6 + c];
					 	data6[temp6 + c][1] = tag6[temp6 + c];
					 	data6[temp6 + c][2] = "" + data_6[temp6 + c];
					 	

						
						
						
						
						data6[temp6 + c][3] = "" + (i);
//				 	}
				

						temp6_ = c;
				}

			}
			
			temp6 = temp6 + temp6_ + 1;

		}
		
		


		
		
		JTable t1;
		String[] columnNames1 = { "Instruction Type", "Destination", "J" , "K", "Issue", "Ex", "WB", "Cycle Number"}; 
		t1 = new JTable(data, columnNames1); 
		t1.setBounds(30, 40, 200, 300); 
		t1.setBackground(Color.white);
		t1.setForeground(Color.black);
		t1.setSelectionBackground(Color.red);
		t1.setGridColor(Color.red);
		t1.setSelectionForeground(Color.white);
		t1.setFont(new Font("Tahoma", Font.PLAIN,17));
		t1.setRowHeight(30);
		
		JTable t2;
		String[] columnNames2 = { "Tag", "OP", "VJ" , "VK", "QJ", "QK", "Busy", "Cycle Number"}; 
		t2 = new JTable(data2, columnNames2); 
		t2.setBounds(30, 40, 200, 300); 
		t2.setBackground(Color.white);
		t2.setForeground(Color.black);
		t2.setSelectionBackground(Color.red);
		t2.setGridColor(Color.red);
		t2.setSelectionForeground(Color.white);
		t2.setFont(new Font("Tahoma", Font.PLAIN,17));
		t2.setRowHeight(30);
		
		JTable t3;
		String[] columnNames3 = { "Tag", "OP", "VJ" , "VK", "QJ", "QK", "Busy", "Cycle Number"}; 
		t3 = new JTable(data3, columnNames3); 
		t3.setBounds(30, 40, 200, 300); 
		t3.setBackground(Color.white);
		t3.setForeground(Color.black);
		t3.setSelectionBackground(Color.red);
		t3.setGridColor(Color.red);
		t3.setSelectionForeground(Color.white);
		t3.setFont(new Font("Tahoma", Font.PLAIN,17));
		t3.setRowHeight(30);
		
		JTable t4;
		String[] columnNames4 = { "Tag", "Address", "Wait For Tag", "Data To Be Stored", "Busy", "Cycle Number"}; 
		t4 = new JTable(data4, columnNames4); 
		t4.setBounds(30, 40, 200, 300); 
		t4.setBackground(Color.white);
		t4.setForeground(Color.black);
		t4.setSelectionBackground(Color.red);
		t4.setGridColor(Color.red);
		t4.setSelectionForeground(Color.white);
		t4.setFont(new Font("Tahoma", Font.PLAIN,17));
		t4.setRowHeight(30);
		
		JTable t5;
		String[] columnNames5 = { "Tag", "Address", "Wait For Tag", "Data To Be Stored", "Busy", "Cycle Number"}; 
		t5 = new JTable(data5, columnNames5); 
		t5.setBounds(30, 40, 200, 300); 
		t5.setBackground(Color.white);
		t5.setForeground(Color.black);
		t5.setSelectionBackground(Color.red);
		t5.setGridColor(Color.red);
		t5.setSelectionForeground(Color.white);
		t5.setFont(new Font("Tahoma", Font.PLAIN,17));
		t5.setRowHeight(30);
		
		JTable t6;
		String[] columnNames6 = { "Register", "Tag", "Data", "Cycle Number"}; 
		t6 = new JTable(data6, columnNames6); 
		t6.setBounds(30, 40, 200, 300); 
		t6.setBackground(Color.white);
		t6.setForeground(Color.black);
		t6.setSelectionBackground(Color.red);
		t6.setGridColor(Color.red);
		t6.setSelectionForeground(Color.white);
		t6.setFont(new Font("Tahoma", Font.PLAIN,17));
		t6.setRowHeight(30);

		
		
			JScrollPane sp = new JScrollPane(t1);
			sp.setForeground(Color.red);
			sp.setBackground(Color.white);
	        frame.add(sp); 
		


      

        JButton b1 = new JButton();
        frame.setSize(500,500);     
        b1.setSize(700,700);
        b1.setVisible(true);
        b1.setText("Next Table");
        JButton b2 = new JButton();     
        b2.setSize(700,700);
        b2.setVisible(true);
        b2.setText("Previous Table");
        b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){  
             
        	if(instructionTable) {
        	instructionTable = false;
        	addTable = true; 
        	 frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t2);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Add/Sub RS Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}
        	
        	else if(addTable) {
        	addTable = false;
        	mulTable = true; 
        	frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t3);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Mul/Div RS Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}
        	
        	else if(mulTable) {
            	mulTable = false;
            	lBuffer = true; 
            	frame.getContentPane().removeAll();
             	JScrollPane sp2 = new JScrollPane(t4);
     			sp2.setForeground(Color.red);
     			sp2.setBackground(Color.white);
            	 frame.add(sp2);
            	 frame.add(b2);
            	 frame.add(b1);
            	 JLabel label;
                 label = new JLabel("Currently In Load Buffer Table");
                 label.setBounds(50, 62, 54, 21);
                 frame.getContentPane().add(label);
            	 frame.validate();
            	}
        	
        	else if(lBuffer) {
            	lBuffer = false;
            	sBuffer = true; 
            	frame.getContentPane().removeAll();
             	JScrollPane sp2 = new JScrollPane(t5);
     			sp2.setForeground(Color.red);
     			sp2.setBackground(Color.white);
            	 frame.add(sp2);
            	 frame.add(b2);
            	 frame.add(b1);
            	 JLabel label;
                 label = new JLabel("Currently In Store Buffer Table");
                 label.setBounds(50, 62, 54, 21);
                 frame.getContentPane().add(label);
            	 frame.validate();
            	}
        	
        	else if(sBuffer) {
            	sBuffer = false;
            	registerTable = true; 
            	frame.getContentPane().removeAll();
             	JScrollPane sp2 = new JScrollPane(t6);
     			sp2.setForeground(Color.red);
     			sp2.setBackground(Color.white);
            	 frame.add(sp2);
            	 frame.add(b2);
            	 frame.add(b1);
            	 JLabel label;
                 label = new JLabel("Currently In Register Table");
                 label.setBounds(50, 62, 54, 21);
                 frame.getContentPane().add(label);
            	 frame.validate();
            	}

        } 	
    });
        
       
        b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){  
             
        	if(addTable) {
        	instructionTable = true;
        	addTable = false; 
        	 frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t1);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Instruction Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}
        	
        	else if(mulTable) {
        	mulTable = false;
        	addTable = true; 
        	 frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t2);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Add/Sub RS Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}
        	
        	else if(lBuffer) {
        	lBuffer = false;
        	mulTable = true; 
        	 frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t3);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Mul/Div RS Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}
        	
        	else if(sBuffer) {
        	sBuffer = false;
        	lBuffer = true; 
        	 frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t4);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Load Buffer Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}
        	
        	else if(registerTable) {
        	registerTable = false;
        	sBuffer = true; 
        	 frame.getContentPane().removeAll();
         	JScrollPane sp2 = new JScrollPane(t5);
 			sp2.setForeground(Color.red);
 			sp2.setBackground(Color.white);
        	 frame.add(sp2);
        	 frame.add(b2);
        	 frame.add(b1);
        	 JLabel label;
             label = new JLabel("Currently In Store Buffer Table");
             label.setBounds(50, 62, 54, 21);
             frame.getContentPane().add(label);
        	 frame.validate();
        	}

        } 	
    });
        frame.setLayout(new FlowLayout());
   	 	frame.add(b2);
   	 	frame.add(b1);
        JLabel label;
        label = new JLabel("Curently In Instruction Table");
        label.setBounds(50, 62, 54, 21);
        frame.getContentPane().add(label);

	}

	public static void main(String[] args) {
// --------------------------------------------------------------------------------------FRONTEND
		JFrame frame = new JFrame("Simple GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1000, 700);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		frame.setVisible(true);

		
		
		
		
		
		
		
		
		
		
		
//--------------------------------------------------------------------------------------BACKEND
		int NStructions = 0;
		int nRS_addition = 0;
		int nRS_MUL = 0;
		int nLb = 0;
		int nSB = 0;
		int cycles = 0;
		int memorysize = 1024;
		System.out.println(
				"                                                               WELCOME TO OUR SIMULATION !!!!!");
		System.out.println(
				"                                                               PLEASE ENTER THE REQUIRED INFO");
		System.out.println(
				("                                          ____________________________________________________________________"));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Instructions");
		NStructions = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of Instructions"));

		Scanner cc = new Scanner(System.in);
		System.out.println("Enter the number of ADD/SUB Reservation Slots");
		nRS_addition = Integer
				.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of ADD/SUB Reservation Slots"));

		Scanner cx = new Scanner(System.in);
		System.out.println("Enter the number of MUL/DIV Reservation Slots");
		nRS_MUL = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of MUL/DIV Reservation Slots"));

		Scanner x1 = new Scanner(System.in);
		System.out.println("Enter the number of LoadBuffer Slots");
		nLb = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of LoadBuffer Slots"));

		Scanner c = new Scanner(System.in);
		System.out.println("Enter the number of StoreBuffer Slots");
		nSB = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of StoreBuffer Slots"));

		Scanner cy = new Scanner(System.in);
		System.out.println("Enter the number of Cycles To be Simulated");
		cycles = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of Cycles To be Simulated"));

		String[] InstructionsInput = new String[NStructions * 5];
		int xx = 0;

		LinkedList<Integer> REGISTERDESTINATION = new LinkedList<Integer>();
		JOptionPane.showMessageDialog(frame, "INSTRUCTION  will be inserted as 5 iputs as follows");
		for (int i = 0; i < NStructions; i++) {
			JOptionPane.showMessageDialog(frame, "Insert the required data for INSTRUCTION number :" + (i + 1));
			System.out.println("Insert the required data for operation number :" + (i + 1));
			Scanner Op = new Scanner(System.in);
			System.out.println("Enter op");

			InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter op (MUST BE AN UPPER CASE) ");
			String temp = InstructionsInput[xx];
			if (temp.equals("L") || temp.equals("S")) {
				xx++;
				Scanner rt = new Scanner(System.in);
				System.out.println("Enter rt");
				InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter rt");

				if (!REGISTERDESTINATION.contains(Integer.parseInt(InstructionsInput[xx])))
					REGISTERDESTINATION.add(Integer.parseInt(InstructionsInput[xx]));
				xx++;

				Scanner rs = new Scanner(System.in);
				System.out.println("Enter rs");
				InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter rs");
				xx++;

				Scanner number = new Scanner(System.in);
				System.out.println("Enter offset");
				InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter offset");

			} else {
				xx++;

				Scanner rd = new Scanner(System.in);
				System.out.println("Enter rd");
				InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter rd");

				if (!REGISTERDESTINATION.contains(Integer.parseInt(InstructionsInput[xx])))
					REGISTERDESTINATION.add(Integer.parseInt(InstructionsInput[xx]));
				xx++;

				Scanner rs = new Scanner(System.in);
				System.out.println("Enter rs");
				InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter rs");

				xx++;
				Scanner rt = new Scanner(System.in);
				System.out.println("Enter rt");
				InstructionsInput[xx] = JOptionPane.showInputDialog(frame, "Enter rt");
			}

			xx++;
			Scanner time = new Scanner(System.in);
			System.out.println("Enter time needed to execute this type of instruction in cycles");
			InstructionsInput[xx] = JOptionPane.showInputDialog(frame,
					"Enter time needed to execute this type of instruction in cycles");
			xx++;

		}

		MyQueue InstructionBuffer = new MyQueue(NStructions);
		MyQueue RegisterFile = new MyQueue(64);
		MyQueue memory = new MyQueue(memorysize);
		MyQueue AdditionRS = new MyQueue(nRS_addition);
		MyQueue MulRS = new MyQueue(nRS_MUL);
		MyQueue StoreBuffer = new MyQueue(nSB);
		MyQueue LoadBuffer = new MyQueue(nLb);

		Simulation S = new Simulation(frame, InstructionsInput, InstructionBuffer, RegisterFile, AdditionRS, MulRS,
				StoreBuffer, LoadBuffer, memory, cycles, REGISTERDESTINATION);

	}
}
