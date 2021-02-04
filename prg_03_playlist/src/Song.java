/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Song class
 * Name(s): ADAM WOJDYLA (No Partner)
 */

public class Song implements Comparable<Song> {

    public static final int MIN_RANK = 1;
    public static final int MAX_RANK = 5;
    public static final int TITLE_KEY = 1;
    public static final int ARTIST_KEY = 2;
    public static final int RANK_KEY = 3;
    private String title;
    private String artist;
    private int rank;
    private int key;


    // TODOd: implement the constructor and validate all parameters
    public Song(String title, String artist, int rank) {


        this.title = title != null ? title : "";
        this.artist = artist != null ? artist : "";
        this.rank = rank >= 1 && rank <= 5 ? rank : 0;
        this.key = key >= 1 && key <= 3 ? key : TITLE_KEY;
    }

    // TODOd: implement all getter methods
    // TODOd: implement the setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        switch (key) {
            case TITLE_KEY:
            case ARTIST_KEY:
            case RANK_KEY:
                this.key = key;
            default:
        }
    }

    // TODOd: implement the compareTo override based on the current key value (note that rank
    //  should be from higher to lower rank)
    @Override
    public int compareTo(Song other) {
        Integer rank = this.rank;
        switch (getKey()) {
            case TITLE_KEY:
                return this.title.compareTo(other.title);
            case ARTIST_KEY:
                return this.artist.compareTo(other.artist);
            case RANK_KEY:
                return -rank.compareTo(other.rank);
        }
        return 0;
    }

    // TODOd: implement the toString override
    @Override
    public String toString() {
        return title + "," + artist + "," + rank + "\n";
    }
}
