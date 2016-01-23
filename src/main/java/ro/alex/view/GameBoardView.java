package ro.alex.view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * @author Alexandru Comsa
 */

public class GameBoardView extends JDialog{

	
	
	
	private static final long serialVersionUID = 1L;
	private static final String PATH_TO_IMAGE = "/ro/alex/view/chess_queen_icon.jpg";
	private static final String PATH_TO_EMPTY_IMAGE = "/ro/alex/view/empty_icon.jpg";
	private Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
	private static  int  labelSize = 100;
	
	
	private  GameBoardView(JFrame parent, int solution[][]){
		super(parent, "Solution", true);
	  
		if (parent != null) {
	      Dimension parentSize = parent.getSize(); 
	      Point p = parent.getLocation(); 
	      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
	    }
		

	     
	  
	    int windowDim = labelSize * solution.length;
	    ImageIcon icon = new ImageIcon(getClass().getResource(PATH_TO_IMAGE));
	    ImageIcon empty_icon = new ImageIcon(getClass().getResource(PATH_TO_EMPTY_IMAGE));
	    setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	     
	    for(int i = 0 ; i< solution[0].length;i++){
	    	
	    	for(int j = 0; j< solution[1].length;j++){
	    		
	    		gbc.fill = GridBagConstraints.HORIZONTAL;
	    		gbc.gridx = j;
	    		gbc.gridy = i;
	    		
	    		JLabel jLabel = new JLabel();
	    		
	    		jLabel.setSize(labelSize,labelSize);
	    		jLabel.setBorder(border);
	    		if(solution[i][j]==999){
	    			jLabel.setIcon(icon);
	    		}
	    		else jLabel.setIcon(empty_icon);;
	    		this.add(jLabel,gbc);
	    	}
	    	
	    }
	   

	    JPanel buttonPane = new JPanel();
	    JButton button = new JButton("Close Solution View"); 
	    button.addActionListener(new ButtonListener());
	    buttonPane.add(button); 
	    this.add(buttonPane);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	   
	    this.setSize(windowDim, windowDim);
	    pack(); 
	    setVisible(true);
	  }
         
         
	
	public static GameBoardView displaySolution(int[][] solution, JFrame parent) {
		return new GameBoardView(parent,solution);
		
	}
	
	
	
	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose();
			
		}
		
	}

}
