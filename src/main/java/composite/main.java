package composite;

/**
 * Created by tranpham on 8/7/17.
 * File structure problem:
 *  - Directory
 *  - File
 */
public class main {

    public static void   main(String[] agrs){
        File file1 = new File("music1.mp3");
        File file2= new File("music2.mp3");
        Directory Pop= new Directory("Pop");
        Directory Classical = new Directory("Classical");
        Directory Music = new Directory("Music");

        Music.add(new File("MadWorld.mp3"));
        Music.add(Pop);
        Music.add(Classical);
        Classical.add(file1);
        Classical.add(file2);
        Pop.add(new File("BabyOneMoreTime.mp3"));
        Music.path("  ");

        Box bigBox = new Box("Big Box");
        Item candy1= new Item("Kittle");
        Item candy2= new Item("Chocolate");
        Box smallBox = new Box("Smaller Box");
        Item sock = new Item("Pair of sock");
        bigBox.add(sock);
        bigBox.add(smallBox);
        smallBox.add(candy1);
        smallBox.add(candy2);
        bigBox.showContent("-");
    }
}
