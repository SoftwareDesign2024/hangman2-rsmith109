package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import util.DisplayWord;
import util.HangmanDictionary;

public class CheatingExecutioner extends Executioner {
	
	// executioner state
    private List<String> myRemainingWords;
    
    public CheatingExecutioner(HangmanDictionary dictionary, int wordLength) {
    	super();
    	myRemainingWords = dictionary.getWords(wordLength);
    }
    
    public void cheat(char guess, DisplayWord myDisplayWord) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(myDisplayWord);
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
        }

        // update secret word to match template of guesses
        myRemainingWords = templatedWords.get(maxKey);
        Collections.shuffle(myRemainingWords);
        mySecretWord = myRemainingWords.get(0);
        myDisplayWord = maxKey;
    }
}
