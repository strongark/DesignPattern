package CodeFight;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tranpham on 3/15/18.
 */
public class Arcade {

    int calculationsWithCoins(int a, int b, int c) {

        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(a+b);
        set.add(a+c);
        set.add(b+c);
        set.add(a+b+c);

        return set.size();
    }

    public int differentSymbolsNaive(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(cnt[c-'a']==0)
                cnt[c-'a']++;
        }
        return Arrays.stream(cnt).sum();
    }

    public boolean stringsRearrangement(String[] inputArray) {
        int n = inputArray.length;
        boolean[][] related = new boolean[n][n];
        int start1=-1;
        int start2=-1;
        for(int i=0;i<n;i++) {
            for (int j = i + 1; j < n; j++) {
                if (isRelated(inputArray[i], inputArray[j])) {
                    related[i][j] = true;
                    related[j][i] = true;
                    if (start1 == -1) {
                        start1 = i;
                        start2 = j;
                    }
                }
            }
        }
        if(start1==-1)
            return false;
        List<int[]> result = new ArrayList<>();
        for (int i=0;i<inputArray.length;i++){
            btPath(related,new int[]{i},result);
        }
        return result.size()>0;
    }

    //bactracking path finding
    public void btPath(boolean[][] matrix, int[] path, List<int[]> result) {
        if(isAccepted(matrix,path)){
            result.add(path);
        }

        int[] moves= getProspectiveMoves(matrix,path);

        for(int i:moves){
            int[] newPath = new int[path.length+1];
            System.arraycopy(path,0,newPath,0,path.length);
            newPath[newPath.length-1]=i;
            btPath(matrix,newPath, result);
        }
    }

    private boolean isAccepted(boolean[][] matrix, int[] path) {
        if (path.length<matrix.length)
            return false;

        int sum=Arrays.stream(path).sum();
        //it should be equal to n*(n-1)/2
        return sum == path.length*(path.length-1)/2;
    }

    private int[] getProspectiveMoves(boolean[][] matrix, int[] path) {
        //check if path[0] and path[length-1] can connect to new node not in the path
        boolean[] isExist = new boolean[matrix.length];
        for(int i:path){
            isExist[i]=true;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            if(!isExist[i])
                if(matrix[i][path[path.length-1]])
                    lst.add(i);
        }

        int[] ret = new int[lst.size()];
        for(int i=0;i<lst.size();i++)
            ret[i]=lst.get(i);
        return ret;
    }

    private boolean isRelated(String a, String b){
        int l1=a.length();
        int l2=b.length();
        int diff=0;
        if(Math.abs(l1-l2)>1){
            return false;
        } else if(Math.abs(l1-l2)==1){
            diff++;
        }

        for(int i=0;i<Math.min(l1,l2);i++){
            if(a.charAt(i)!=b.charAt(i))
                diff++;
        }
        return diff==1;
    }

    public int absoluteValuesSumMinimization(int[] a) {
        float avg = Arrays.stream(a).sum()/(float)a.length;
        float min=avg;
        int idx=a.length/2;
        for(int i=0;i<a.length;i++){
            float d=0;
            for(int j=0;j<a.length;j++){
                d = Math.abs(a[i] - avg);
            }

            if(d<min){
                min = d;
                idx = i;
            }
        }
        return a[idx];
    }

    public int zigzag(int[] a) {
        //i-increase
        //d-decrease
        int[] zig = new int[a.length];
        if(a.length==1)
            return 1;

        for(int j=0;j<a.length;j++){
            zig[j]++;
            for(int i=j+1;i<a.length;i++){
                if(i+1<a.length)
                {
                    int l=a[i]-a[i-1];
                    int r=a[i]-a[i+1];
                    if(l*r<=0)
                        break;
                }
                zig[j]++;
            }
        }
        return Arrays.stream(zig).max().getAsInt();
    }

    public int[][] minesweeper(boolean[][] matrix) {
        int[][] map = new int[matrix.length][matrix[0].length];
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                map[row][col]=countMinesAround(matrix,row,col);
            }
        }
        return map;
    }

    private int countMinesAround(boolean[][] matrix,int r,int c){
        int res=0;
        for(int row=Math.max(0,r-1);row<=Math.min(r+1,matrix.length-1);row++)
            for(int col=Math.max(0,c-1);col<=Math.min(c+1,matrix[row].length-1);col++){
                if(row!=r || col!=c)
                    if(matrix[row][col])
                        res++;
            }
        return res;
    }

    public boolean isIPv4Address(String inputString) {
        String[] numbers = inputString.split("\\.");
        if(!Pattern.compile("\\d\\.\\d\\.\\d\\.\\d").matcher(inputString).find())
            return false;
        for(String num:numbers){
            try{
                int n=Integer.parseInt(num);
                if(n<0||n>255)
                    throw new NumberFormatException("number not in range");
            } catch (NumberFormatException ex){
                return false;
            }
        }
        int[] arr= new int[5];
        Arrays.stream(arr).max().getAsInt();
        return true;
    }

    public boolean palindromeRearranging(String inputString) {
        int[] c = new int[26];
        char[] chars = inputString.toCharArray();
        for(int i=0;i<chars.length;i++){
            c[chars[i]-'a']++;
        }

        return true;
    }

    public String reverseParentheses(String s) {
        int[] pStack = new int[s.length()/2];
        int sIdx = -1;

        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            switch(chars[i]){
                case ')':
                    int start = pStack[sIdx--];
                    reverse(chars, start,i);
                    break;
                case '(':
                    pStack[++sIdx]=i;
                    break;
                default:
                    break;
            }
        }
        return (new String(chars)).replaceAll("\\(|\\)","");
    }

    private void reverse(char[] chars,int start, int end){
        for(int i=start;i<(end+start+1)/2;i++){
            //swap
            char temp = chars[i];
            chars[i]=chars[end+start-i];
            chars[end+start-i]=temp;
        }
    }
}
