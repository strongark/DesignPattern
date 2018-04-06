package Interview;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by tranpham on 3/26/18.
 */
public class InterviewGeneral {

    public int chessKnight(String cell) {
        int[][] d={{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        int move=0;
        for(int[] dr:d){
            String newCell = ""+(char)(cell.charAt(0)+dr[0])+(char)(cell.charAt(1)+dr[1]);
            System.out.println(newCell);
            if(isValid(newCell))
                move++;
        }
        return move;

    }

    boolean isValid(String cell){
        if(cell.charAt(0)<'a'||cell.charAt(0)>'h'
                ||cell.charAt(1)<'1'||cell.charAt(1)>'8')
            return false;
        return true;
    }

    public int[] treeBottom(String tree) {
        Node n = new Node(tree);
        int m = n.maxHeight();
        int[] res = n.getNodeSameHeight(m);
        return res;
    }

    class Node {
        int val;
        Node left;
        Node right;
        private int maxHeight;

        public int maxHeight(){
            maxHeight = 0;
            updateMaxHeightHelper(this,1);
            return maxHeight;
        }

        public int[] getNodeSameHeight(int height){
             ArrayList<Integer> arrayList = new ArrayList<>();
             getNodeSameHeightHelper(height,this,arrayList,1);
             int[] res = new int[arrayList.size()];
             int i=0;
             for(Integer integer:arrayList)
                 res[i++]=integer;
             return res;
        }

        void getNodeSameHeightHelper(int height, Node n, ArrayList<Integer> arr, int soFar) {
            if(soFar==height) {
                arr.add(n.val);
                return;
            }

            if(n.left!=null)
                getNodeSameHeightHelper(height,n.left,arr ,soFar+1);
            if(n.right!=null)
                getNodeSameHeightHelper(height,n.right,arr ,soFar+1);
        }


        private void updateMaxHeightHelper(Node n, int sofar){
            if (maxHeight<sofar)
                maxHeight = sofar;
            if(n.left!=null)
                updateMaxHeightHelper(n.left,sofar+1);
            if(n.right!=null)
                updateMaxHeightHelper(n.right,sofar+1);

        }

        public Node(String tree){
            int[] stk = new int[tree.length()];
            int idx=-1;
            StringBuilder bld = new StringBuilder();
            int sIdx = tree.indexOf(' ',1);
            if(sIdx==-1)
                sIdx=tree.indexOf(')',1);
            val= Integer.parseInt(tree.substring(1,sIdx));
            int i=sIdx+1;
            for(;i<tree.length();i++){
                if(tree.charAt(i)=='(') {
                    stk[++idx] = i;
                } else if(tree.charAt(i)==')') {
                    if (idx == 0) {
                        String leftTree = tree.substring(stk[idx], i + 1);
                        if (leftTree.length() > 2)
                            left = new Node(leftTree);
                        break;
                    }
                    idx--;
                }
            }
            idx--;
            i++;
            for(;i<tree.length();i++){
                if(tree.charAt(i)=='(') {
                    stk[++idx] = i;
                } else if(tree.charAt(i)==')') {
                    if (idx == 0) {
                        String rightTree = tree.substring(stk[idx], i + 1);
                        if (rightTree.length() > 2)
                            right = new Node(rightTree);
                        break;
                    }
                    idx--;
                }
            }
        }
    }

    public int[] bankRequests(int[] accounts, String[] requests) {
        for(int i = 0 ; i < requests.length ; i++){
            String[] cmd = requests[i].split(" ");
            int acc = Integer.parseInt(cmd[1]);
            int sum = 0;
            switch(cmd[0]){
                case "withdraw":
                    sum = Integer.parseInt(cmd[2]);
                    if(accounts[acc-1]<sum)
                        return new int[]{i+1};
                    else
                        accounts[acc-1]-=sum;
                    break;
                case "deposit":
                    sum = Integer.parseInt(cmd[2]);
                    accounts[acc-1]+=sum;
                    break;
                case "transfer":
                    int dstAcc = Integer.parseInt(cmd[2]);
                    sum = Integer.parseInt(cmd[3]);
                    if(accounts[acc-1]<sum)
                        return new int[]{i+1};
                    else{
                        accounts[acc-1]-=sum;
                        accounts[dstAcc-1]+=sum;
                    }
                    break;
            }
        }
        return accounts;
    }

    public String[][] groupingDishes(String[][] dishes) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String[] dish:dishes){
            for(int i=1;i<dish.length;i++){
                if(!hm.containsKey(dish[i]))
                    hm.put(dish[i],new ArrayList<String>());
                List<String> lst = hm.get(dish[i]);
                lst.add(dish[0]);

            }
        }

        List<Map.Entry<String,List<String>>> lstEntry= hm.entrySet().stream().sorted((e1, e2)->{
            return  e1.getKey().compareTo(e2.getKey());
        }).filter(en->en.getValue().size()>1).collect(Collectors.toList());
//        lstEntry=lstEntry.stream().filter(en->en.getValue().size()>1).collect(Collectors.toList());
        String[][] res = new String[lstEntry.size()][];
        int i=0;
        for(Map.Entry<String,List<String>> entry:lstEntry){
            List<String> dishList = entry.getValue();
            res[i]=new String[dishList.size()+1];
            res[i][0] = entry.getKey();
            dishList.sort((d1,d2)->{
                return d1.compareTo(d2);
            });

            for(int j=0; j<dishList.size();j++){
                res[i][j+1]=dishList.get(j);
            }
            i++;
        }
        return res;
    }


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
