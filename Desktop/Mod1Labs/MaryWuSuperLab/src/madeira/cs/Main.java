package madeira.cs;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Superlab {
    public static void main(String[] args) {
        try {
            File artistFile = new File("/Users/Mary/Desktop/Mod1Labs/MaryWuSuperLab/resources/artistList.txt");
            //  this line will read in an integer which represents the number of lines & size of my arrays
            Scanner myReader = new Scanner (artistFile);
            int numArtists = myReader.nextInt();
            String temp = myReader.nextLine();
            String[] filelines = new String[numArtists];
            int i=0;
            while (myReader.hasNextLine()) {
                filelines[i] = myReader.nextLine();
                i++;
            }
            myReader.close();
            Artist [] artists = new Artist [numArtists];
            i=0;
            for(String line: filelines){
                artists[i] = new Artist();
                artists[i].setArtistName(line.split(",")[0]);
                artists[i].setAlbum(line.split(",")[1]);
                artists[i].setTwitterHandle(line.split(",")[2]);
                i++;
            }
            Scanner rate = new Scanner(System.in);
            i = 0;
            for(Artist line: artists){
                System.out.println("Rate "+ line.getArtistName() +" out of ten.");
                int rating = rate.nextInt();
                artists[i].setRating(rating);
                i++;
            } // end of artist rating for loop
            i = 0;
            for(Artist line: artists){
                System.out.println("Artist "+line.getArtistName()+
                        " has an album called"+line.getAlbum()+
                        " on his/her twitterHandle"+line.getTwitterHandle()+
                        " with a rate of "+artists[i].getRating());
                i++;
            } // end of printing for loop
        } // end of try statement
        catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        } // end of catch statement
    } // end of main method
} // end of superlab class
class Artist{
    // member variables below
    String name;
    String album;
    String twitterHandle;
    int rating;
    public Artist () {
        name = "N/A";
        album = "N/A";
        twitterHandle = "N/A";
        rating = 0;
    } // end of constructor
    public void setArtistName (String newName) { name = newName;}
    public String getArtistName () {return name;}
    public void setAlbum (String newAlbum) { album = newAlbum;}
    public String getAlbum () {return album; }
    public void setTwitterHandle (String newTwitterHandle) { twitterHandle = newTwitterHandle;}
    public String getTwitterHandle () {return twitterHandle;}
    public void setRating (int newRating) { rating = newRating;}
    public int getRating () {return rating; }
}