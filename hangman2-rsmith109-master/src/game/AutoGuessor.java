package game;

import util.DisplayWord;

public class AutoGuessor extends Guessor {
	
	private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
	
	private String myLetters;
	private int myIndex;
	
	public AutoGuessor(Executioner e) {
		super(e);
		myLetters = LETTERS_ORDERED_BY_FREQUENCY;
		myIndex = 0;
	}
    
    public String getGuess() {
    	return "" + myLetters.charAt(myIndex++);
    }
	
	

}
