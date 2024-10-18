package game;

import util.ConsoleReader;
import util.DisplayWord;

public class Guessor {
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
    // tracks letters guessed
    protected StringBuilder myLettersLeftToGuess;
    
    protected Executioner myExecutioner;
    
    public Guessor(Executioner e) {
    	myExecutioner = e;
    	myLettersLeftToGuess = new StringBuilder(ALPHABET);
    }
    
 // Process a guess by updating the necessary internal state.
 // return true if the guess was already used previously 
    public boolean makeGuess (char guess, DisplayWord myDisplayWord) {
    	myExecutioner.cheat(guess, myDisplayWord);
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (! myExecutioner.checkGuessInSecret(guess, myDisplayWord)) {
                return true;
            }
        }
        return false;
    }
    
    public String getGuess() {
    	return ConsoleReader.promptString("Make a guess: ");
    }
    
 // Record that a specific letter was guessed
    protected void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    public void printLettersLeftToGuess() {
    	System.out.println(myLettersLeftToGuess);
    }
    
    
    
    
    
    
    
}
