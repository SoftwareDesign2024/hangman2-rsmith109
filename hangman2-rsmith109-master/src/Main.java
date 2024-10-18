import game.AutoGuessor;
import game.CheatingExecutioner;
import game.Executioner;
import game.Guessor;
import game.HangmanGame;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;


    public static void main (String[] args) {
    	
    	HangmanDictionary dictionary = new HangmanDictionary(DICTIONARY);
    	
    	Executioner myExecutioner = new Executioner();
    	//Executioner myExecutioner = new CheatingExecutioner(dictionary, NUM_LETTERS);
    	
    	Guessor myGuessor = new Guessor(myExecutioner);
    	//Guessor myGuessor = new AutoGuessor(myExecutioner);
    	
    	new HangmanGame(dictionary, NUM_LETTERS, NUM_MISSES, myExecutioner, myGuessor).play();
    }
}
