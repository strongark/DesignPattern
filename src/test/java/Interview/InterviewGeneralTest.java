package Interview;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/26/18.
 */
public class InterviewGeneralTest {
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