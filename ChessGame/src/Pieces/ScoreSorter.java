package Pieces;

import java.util.Comparator;

/**
 * Comparator object to sort entries for the leaderboard functionality.
 * 
 * @author Justin Hanna
 */
public class ScoreSorter implements Comparator<Entry> {

    /**
     * Method to compare two Entries by score.
     * 
     * @param o1 First object
     * @param o2 Second object
     * @return Int pointing to the object with the higher score
     */
    @Override
    public int compare(Entry o1, Entry o2) {
        return Integer.compare(o2.getScore(), o1.getScore());
    }
}