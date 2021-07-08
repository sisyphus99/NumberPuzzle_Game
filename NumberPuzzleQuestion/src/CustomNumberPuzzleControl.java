import java.awt.*;
import java.awt.List;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
	    if(emptyCellId+4<16 && buttons[emptyCellId+4]==buttonClicked) {
	    	swapButton(buttons[emptyCellId],buttonClicked);
	        emptyCellId=emptyCellId+4;
	    }
	    else if(emptyCellId-4>=0 && buttons[emptyCellId-4]==buttonClicked) {
	    	swapButton(buttons[emptyCellId],buttonClicked);
	        emptyCellId=emptyCellId-4;
	    }
	    else if(emptyCellId+1<16 && buttons[emptyCellId+1]==buttonClicked) {
	    	swapButton(buttons[emptyCellId],buttonClicked);
	        emptyCellId=emptyCellId+1;
	    }
	    else if(emptyCellId-1>=0 && buttons[emptyCellId-1]==buttonClicked) {
	    	swapButton(buttons[emptyCellId],buttonClicked);
	        emptyCellId=emptyCellId-1;
	    }
	    return emptyCellId;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		HashSet<Integer> hs=new  HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
		int a = getRandomNumber();
			while(hs.contains(a))
				a=getRandomNumber();
			hs.add(a);
			arr[i]=a;
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] buttonIds=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<=14;i++) {
			if(buttonIds[i]!=i+1) {
				winner=false;
				return winner;
			}
		}

		return winner;
	}
}