package Interview;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/26/18.
 */
public class InterviewGeneralTest {
    @Test
    public void chessKnight() throws Exception {
        Assert.assertEquals(2,interviewBot.chessKnight("a8"));
//        Assert.assertEquals(2,interviewBot.chessKnight("h8"));
    }

    @Test
    public void treeBottom() throws Exception {
        String input = "(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))";
        int[] expected = {5,11,4};
        int[] actual= interviewBot.treeBottom(input);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void bankRequests() throws Exception {

    }

    @Test
    public void groupingDishes() throws Exception {
        String[][]  dishes= {{"Salad","Tomato","Cucumber","Salad","Sauce"},
                             {"Pizza","Tomato","Sausage","Sauce","Dough"},
                             {"Quesadilla","Chicken","Cheese","Sauce"},
                             {"Sandwich","Salad","Bread","Tomato","Cheese"}};
        String[][] expected = {{"Cheese","Quesadilla","Sandwich"},
                            {"Salad","Salad","Sandwich"},
                            {"Sauce","Pizza","Quesadilla","Salad"},
                            {"Tomato","Pizza","Salad","Sandwich"}};

        String[][] actual= interviewBot.groupingDishes(dishes);

        Assert.assertArrayEquals(expected,actual);
    }

    InterviewGeneral interviewBot = new InterviewGeneral();

    @Test
    public void swap() throws Exception {
        Integer n1=6,n2=9;
        interviewBot.swap(n1,n2);
    }

    @Test
    public void swap1() throws Exception {
        int n1=6,n2=9;
        interviewBot.swap(n1,n2);

    }

    @Test
    public void generateSubsets() throws Exception {
        int[] inputSet = {1,2};
        int[][] expected = {{},{1},{2},{1,2}};
        int[][] actual  = interviewBot.generateSubsets(inputSet);
        Assert.assertArrayEquals(expected,actual);
    }

}