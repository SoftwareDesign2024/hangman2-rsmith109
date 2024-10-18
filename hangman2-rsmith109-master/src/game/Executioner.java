package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {

	// word that is being guessed
    protected String mySecretWord;
    
 // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret (char guess, DisplayWord myDisplayWord) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
    
 // Returns a secret word.
    public void makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        mySecretWord = dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
    public DisplayWord getSecretWordAsDisplayWord() {
    	return new DisplayWord(mySecretWord);
    }
    
    public void printSecretWord() {
    	System.out.println(mySecretWord);
    }
    
    public boolean isEqualToDisplayWord(DisplayWord myDisplayWord) {
    	return myDisplayWord.equals(mySecretWord);
    }
    
 // framework method
    public void cheat(char guess, DisplayWord myDisplayWord) {

    }
	
}
