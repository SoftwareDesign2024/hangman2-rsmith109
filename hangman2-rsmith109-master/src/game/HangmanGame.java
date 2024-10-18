package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;

/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 */
public class HangmanGame {
    

    
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // what is shown to the user
    private DisplayWord myDisplayWord;
    
    private Executioner myExecutioner;
    
    private Guessor myGuessor;

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame (HangmanDictionary dictionary, int wordLength, int numGuesses, Executioner e, Guessor g) {
        myExecutioner = e;
        myGuessor = g;
        myNumGuessesLeft = numGuesses;
        myExecutioner.makeSecretWord(dictionary, wordLength);
        myDisplayWord = myExecutioner.getSecretWordAsDisplayWord();
    }

    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();
            String guess = myGuessor.getGuess();
            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
                if (myGuessor.makeGuess(guess.toLowerCase().charAt(0), myDisplayWord)) {
                	myNumGuessesLeft--;
                }
                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                }
                else if (isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            }
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        myExecutioner.printSecretWord();
    }

    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon () {
        return myExecutioner.isEqualToDisplayWord(myDisplayWord);
    }

    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return myNumGuessesLeft == 0;
    }

    // Print game stats
    private void printStatus () {
        System.out.println(myDisplayWord);
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.print("letters not yet guessed = ");
        myGuessor.printLettersLeftToGuess();
        // NOT PUBLIC, but makes it easier to test
        System.out.print("*** ");
        myExecutioner.printSecretWord();
        System.out.println();
    }
}
