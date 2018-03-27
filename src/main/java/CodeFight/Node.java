package CodeFight;

/**
 * Created by tranpham on 2/22/18.
 */
public class Node {
    Integer data;
    CodeFight.Node nextNode;
    public Node(Integer t){
        data = t;
    }


    public boolean isEqual(Node node){
        Node thisNode = this;
        Node thatNode = node;
        while (thisNode!=null && thatNode !=null){
            if(thisNode.data != thatNode.data)
                return false;
            thisNode=thisNode.nextNode;
            thatNode=thatNode.nextNode;
        }
        if (thisNode == null && thatNode == null)
            return true;

        return false;
    }

}
