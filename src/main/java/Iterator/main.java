package Iterator;

/**
 * Created by tranpham on 8/7/17.
 */
public class main {

    public static void main(String[] args){
        MysteriousCollection<String> collection = new MysteriousCollection<String>();
        collection.add("First item");
        collection.add("Second item");
        collection.add("Third item");
        collection.add("Fourth item");
        collection.add("Fifth item");
        collection.add("Sixth item");
        collection.add("Seventh item");
        collection.add("Eighth item");
        collection.add("ninth item");
        IMysteriousIterator<String> iterator= collection.createIterator();
        while (iterator.hasNext()){
            String item= iterator.next();
            System.out.println(item.toString());
        }
    }
}
