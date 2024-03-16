package Pieces;

/**
 * Entry object to process leaderboard values.
 * 
 * @author Justin Hanna
 */
public class Entry {

    // Declare object variables
    public String name;
    public int score;

    /**
     * Constrcutor for this Entry object.
     * 
     * @param name  Name of player
     * @param score The number of times the player won
     */
    public Entry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Method to return score
     * 
     * @return Int containing this entry's score
     */
    public int getScore() {
        return this.score;
    }
}