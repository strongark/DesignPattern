package CodeFight;

/**
 * Created by tranpham on 4/13/18.
 */
public class Tree<T>{

    Tree(T x) {
        value = x;
    }
    T value;
    Tree<T> left;
    Tree<T> right;

    public Tree() {

    }

}
