import Stages.FillTables;
import Stages.Issue;

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

public class FrontEnd {

	public FrontEnd(int cycle, JFrame frame, MyQueue instructionBuffer, MyQueue registerFile, MyQueue additionRS,
			MyQueue mulRS, MyQueue storeBuffer, MyQueue loadBuffer, MyQueue memory) {

		Simple(cycle, frame, memory, memory, memory, memory, memory, memory, memory);
	}

	private void Simple(int cycle, JFrame frame, MyQueue instructionBuffer, MyQueue registerFile, MyQueue additionRS,
			MyQueue mulRS, MyQueue storeBuffer, MyQueue loadBuffer, MyQueue memory) {
		JButton b = new JButton("next cycle");
		b.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(b, BorderLayout.LINE_END);
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(bottomPanel, BorderLayout.PAGE_END);

		frame.add(mainPanel);
		SwingUtilities.updateComponentTreeUI(frame);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}

	public static void main(String[] args) {
		
		
		
		
	}
}
