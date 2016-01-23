package ro.alex.controller;

import javax.swing.JFrame;
import ro.alex.model.GameBoard;
import ro.alex.view.GameBoardView;

/*
 * @author Alexandru Comsa
 */


public class GameController {
	
	
	public GameController(GameBoard model, GameBoardView view) {
		this.setModel(model);
		this.setView(view);
	}

	public GameController(String size, JFrame parent){
		int sizeA= -9;
		try{
			 sizeA = Integer.parseInt(size);
			 this.setModel(new GameBoard(sizeA));
				int[][] solution = model.solve(sizeA);
				this.view = GameBoardView.displaySolution(solution,parent);
		}
		catch(NumberFormatException ex){
			System.out.println(ex.toString());
			
		}
		
		
		
	}
	

	private GameBoard model;
	private GameBoardView view;

	public GameBoardView getView() {
		return view;
	}

	public void setView(GameBoardView view) {
		this.view = view;
	}
	
	public GameBoard getModel() {
		return model;
	}
	public void setModel(GameBoard model) {
		this.model = model;
	}
	
	
}
