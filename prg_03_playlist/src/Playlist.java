/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - PlayList class
 * Name(s): ADAM WOJDYLA (No Partner)
 */

import java.io.*;
import java.util.*;

public class Playlist {

    public static final String FILE_NAME = "playlist.csv";
    public static final int OPTION_PRINT = 1;
    public static final int OPTION_ADD = 2;
    public static final int OPTION_KEY = 3;
    public static final int OPTION_GET_KEY_VALUE = 4;
    public static final int OPTION_SEARCH = 5;
    public static final int OPTION_QUIT = 6;

    public static Scanner sc = new Scanner(System.in);

    private BinaryTree<Song> binTree;
    private int key;

    public Playlist() throws FileNotFoundException {
        binTree = new BinaryTree<>();
        key = Song.TITLE_KEY;
        loadSongs();
    }

    // TODOd: implement the loadSongs method
    public void loadSongs() throws FileNotFoundException {
        Scanner playListFile = new Scanner(new File(FILE_NAME));

        while (playListFile.hasNext()) {
            String songs = playListFile.nextLine();
            String[] songInfo = songs.split(",");
            Song newSong = new Song(songInfo[0], songInfo[1], Integer.parseInt(songInfo[2]));
            addSong(newSong);
        }
        playListFile.close();
    }

    // TODOd: implement the saveSongs method
    public void saveSongs() throws IOException { // FileNotFoundException
        FileWriter playlistWriter = new FileWriter(FILE_NAME);
        Iterator<Song> songIterator = binTree.iterator();

        while (songIterator.hasNext()) {
            Song song = songIterator.next();
            String songInfo =
                    String.format("%s,%s,%d\n", song.getTitle(), song.getArtist(), song.getRank());
            playlistWriter.write(songInfo);
        }
        playlistWriter.close();

    }

    // TODOd: implement the addSong method
    public void addSong(Song song) {
        binTree.add(song);

    }


    // TODOd: implement the setKey method
    public void setKey(int key) {
        // validate key
        if (key < 1 || key > 3)
            return;

        // set old binTree to a temporary variable
        BinaryTree<Song> oldTree = binTree;
        // create a new binTree object
        binTree = new BinaryTree<>();
        //traverse through old binTree using iterator method
        Iterator<Song> oldIterator = oldTree.iterator();
        // gathering title, artist, and rank.
        while (oldIterator.hasNext()) {
            Song song = oldIterator.next();
            // copy information into new binTree and set the key
            song.setKey(key);
            binTree.add(song);
        }
        //update key value for option 4
        this.key = key;
        // clear old binTree
        oldTree.clear();

    }

    //TODOd: EXTRA CREDIT implement get current key value method
    public String getKeyValue() {
        switch (key) {
            case Song.ARTIST_KEY:
                return "Artist";
            case Song.RANK_KEY:
                return "Rank";
            case Song.TITLE_KEY:
            default:
                return "Title";
        }
    }

    // TODOd: implement the toString method
    @Override
    public String toString() {
        return binTree.toString();
    }

    public static int getOption() {
        while (true) {
            System.out.println(
                    "Choose an Option: [1]-Print Playlist [2]-Add Song [3]-Set Key [4]-Display " +
                            "Key [5]-Search Playlist [6]-Quit");
            System.out.print("Enter Here: ");
            String line = sc.nextLine();
            System.out.println();
            try {
                int option = Integer.parseInt(line);
                if (option == OPTION_PRINT || option == OPTION_ADD || option == OPTION_KEY ||
                        option == OPTION_GET_KEY_VALUE || option == OPTION_SEARCH ||
                        option == OPTION_QUIT)
                    return option;
            } catch (NumberFormatException ex) {
            }
            System.out.println("Error!");
        }
    }

    public static Song getSong() {
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Artist: ");
        String artist = sc.nextLine();
        System.out.print("Enter Rank: [" + Song.MIN_RANK + "-" + Song.MAX_RANK + "] ");

        int rank = Song.MIN_RANK;
        try {
            rank = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
        }
        System.out.println();
        return new Song(title, artist, rank);
    }

    public static int getKey() {
        System.out.println(
                "Choose sort method: [" + Song.TITLE_KEY + "]:by title  [" + Song.ARTIST_KEY +
                        "]:by artist  [" +
                        Song.RANK_KEY + "]:by rank");
        System.out.print("Enter here: ");
        int key = Song.TITLE_KEY;
        try {
            key = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
        }
        System.out.println();
        return key;

    }

    //TODOD: EXTRA CREDIT- implement the search method for title and artist
    private String searchKey() {
        System.out.println(
                "Search by: [" + Song.TITLE_KEY + "]-Title  [" + Song.ARTIST_KEY + "]-Artist");
        System.out.print("Enter here: ");
        int keyToSearch = Song.TITLE_KEY;
        try {
            keyToSearch = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Search Entry!!");
            System.exit(0);
            System.out.println();
        }

        if (keyToSearch == Song.TITLE_KEY || keyToSearch == Song.ARTIST_KEY) {
            System.out.println(
                    "Print the " + (keyToSearch == Song.TITLE_KEY ? "Title..." : "Artist..."));
            System.out.print("Enter here: ");
            String userInput = sc.nextLine();
            String searchResults = "";
            Iterator<Song> songItr = binTree.iterator();
            while (songItr.hasNext()) {
                Song song = songItr.next();
                String songInfo =
                        keyToSearch == Song.TITLE_KEY ? song.getTitle() : song.getArtist();
                if (songInfo.toUpperCase().contains(userInput.toUpperCase()))

                    searchResults += "--" + song.toString();
            }
            if (searchResults.equals(""))
                return "No Results Found!\n";
            else {
                return "\nResults found:\n" + searchResults + "\n";
            }
        } else {
            return "Invalid Key Entered!";
        }
    }


    public static void main(String[] args) throws IOException { //Originally FileNotFoundException
        System.out.println("Welcome to my playlist!");
        Playlist playList = new Playlist();
        boolean quit = false;
        while (!quit) {
            int option = getOption();
            switch (option) {
                case OPTION_PRINT:
                    System.out.println(playList);
                    break;
                case OPTION_ADD:
                    Song song = getSong();
                    playList.addSong(song);
                    break;
                case OPTION_KEY:
                    int key = getKey();
                    playList.setKey(key);
                    break;
                case OPTION_GET_KEY_VALUE:
                    System.out.println("Currently sorted by: " + playList.getKeyValue() + "\n");
                    break;
                case OPTION_SEARCH:
                    System.out.print(playList.searchKey());
                    break;
                case OPTION_QUIT:
                    System.out.println("Saving playlist changes...");
                    playList.saveSongs();
                    System.out.println("Done!");
                    quit = true;

            }
        }
        System.out.println("Bye!");
    }
}
