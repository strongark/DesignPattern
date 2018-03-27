package Interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tranpham on 3/26/18.
 */
public class InterviewGeneral {

    /*Generate all subset of a set
    * */
    public void swap(Integer n1, Integer n2){
        n1=n1+n2;
        n2=n1-n2;
        n1=n1-n2;
    }
    public void swap(int n1, int n2){
        n1=n1+n2;
        n2=n1-n2;
        n1=n1-n2;
    }

    public int[][] generateSubsets(int[] set){
        ArrayList<int[]> result = new ArrayList<>();
        boolean[] chosen = new boolean[set.length];
        generateSubsetsHelper(set, chosen,0,result);
        int[][] res= new int[result.size()][];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }

    private void indent(int n){
        for(int i=0;i<n;i++)
            System.out.print("...");
    }
    private void generateSubsetsHelper(int[] set, boolean[] chosen, int choiceSoFar, ArrayList<int[]> res){
        indent(choiceSoFar+1);
        System.out.println("Choice so far "+choiceSoFar +" "+Arrays.toString(chosen));
        if(choiceSoFar>=set.length){//don't need to choose anymore
            ArrayList<Integer> lst  = new ArrayList<>();
            for(int i=0;i<set.length;i++){
                if(chosen[i]){
                    lst.add(set[i]);
                }
            }
            int[] result = new int[lst.size()];
            for (int i=0;i<lst.size();i++)
                result[i]=lst.get(i);
            System.out.println(Arrays.toString(result));
            res.add(result);
        }

        for(int i=choiceSoFar;i<set.length;i++){
            //choose choice
            chosen[i]=false;
            //explore
            generateSubsetsHelper(set,chosen,choiceSoFar+1,res);
            //unchoose choice
            chosen[i]=true;
            generateSubsetsHelper(set,chosen,choiceSoFar+1,res);
        }
    }

}
