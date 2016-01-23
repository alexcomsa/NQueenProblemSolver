package ro.alex.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ro.alex.controller.GameController;

public class DataCollectorWindow extends JFrame{

	/*
	 * @author Alexandru Comsa
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JPanel itemContainer;
	private JTextField boardSizeCollector;
	private JButton generateSolutionButton;
	private DataCollectorWindow window;
	
	public DataCollectorWindow(){
		super("N Queen Problem Solver");
		itemContainer = new JPanel();
		boardSizeCollector = new JTextField(10);
		generateSolutionButton = new JButton("Compute solution");
		generateSolutionButton.addActionListener(new ButtonListener());
		itemContainer.add(boardSizeCollector);
		itemContainer.add(generateSolutionButton);
		
		this.add(itemContainer);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		pack();
		setVisible(true);
		window = this;
	}

	public JButton getGenerateSolutionButton() {
		return generateSolutionButton;
	}

	public void setGenerateSolutionButton(JButton generateSolutionButton) {
		this.generateSolutionButton = generateSolutionButton;
	}
	
	
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		
			String boardSizeValue = boardSizeCollector.getText();
			@SuppressWarnings("unused")
			GameController gc = new GameController(boardSizeValue, window);
			
			
			
			
			
		}

		
		
	}
	

}
