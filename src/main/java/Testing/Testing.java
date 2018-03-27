package Testing;
import java.util.*;
import java.util.Arrays;
import java.util.regex.Pattern;


/**
 * Created by tranpham on 9/26/17.
 */
public class Testing {
    static int stringCount=0;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            String str =  scanner.nextLine();
            if(str.equals("hackerrank")){
                System.out.println(0);
            } else if (Pattern.compile("^hackerrank").matcher(str).find()){
                System.out.println(1);
            } else if (Pattern.compile("hackerrank$").matcher(str).find()){
                System.out.println(2);
            }
        }
        scanner.close();

//        printShortestPath(7,6,6,0,1);
//        int[] arr = new int[10];
        //test case for dict
        Dict dict = new Dict("{a:orange,b:apple}");
        System.out.println(dict.toString());
        Dict dict2 = new Dict("{a:orange,b:{c:apple,d:grape}}");
        System.out.println(dict2.toString());
    }

    /*
[[0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0],
[0, 2, 0, 2, 0, 2, 0],
[0, 0, 0, 0, 0, 0, 0],
[4, 0, 4, 0, 4, 0, 4]]



[[0, 0, 0, 1, 0, 3, 0],
[0, 0, 0, 0, 0, 0, 0],
[1, 0, 1, 0, 3, 0, 5],
[0, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 2, 0, 4, 0],
[0, 0, 0, 0, 0, 0, 0],
[1, 0, 1, 0, 3, 0, 5]]



[[null,null, null, L,    null, L,    null],
[null, null, null, null, null, null, null],
[UR,   null, UL,   null, UL,   null, UL],
[null, null, null, null, null, null, null],
[null, UL,   null, UL,   null, UL,   null],
[null, null, null, null, null, null, null],
[UR,   null, UL,   null, UL,   null, UL]]

UL UR null
    *
    *
    *
[[0, 2, 0, 2, 0, 2, 0],
[0, 0, 0, 0, 0, 0, 0],
[4, 0, 4, 0, 4, 0, 4],
[0, 0, 0, 0, 0, 0, 0],
[0, 4, 0, 0, 0, 4, 0],
[0, 0, 0, 0, 0, 0, 0],
[4, 0, 4, 0, 4, 0, 4]]

[[0, 2, 0, 2, 0, 4, 0],
[0, 0, 0, 0, 0, 0, 0],
[1, 0, 3, 0, 3, 0, 5],
[0, 0, 0, 0, 0, 0, 0],
[0, 3, 0, 0, 0, 3, 0],
[0, 0, 0, 0, 0, 0, 0],
[1, 0, 3, 0, 3, 0, 5]]

[[null,LR,   null, LL,   null, LL,   null],
[null, null, null, null, null, null, null],
[LR,   null, LR,   null, LL,   null, LL],
[null, null, null, null, null, null, null],
[null, R,    null, null, null, L,    null],
[null, null, null, null, null, null, null],
[UR,   null, UR,   null, UL,   null, UL]]
LR null
    * */
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
        int[][] chess = new int[n][n];
        chess[i_end][j_end]=1;
        int[][] r_path = new int[n][n];
        int[][] c_path = new int[n][n];
        String[][] path = new String[n][n];

        Queue<int[]> step = new LinkedList<>();
        step.add(new int[]{i_end,j_end});
        while(!step.isEmpty()){
            int[] move = step.poll();
            int r_end = move[0];
            int c_end = move[1];
            int distance = chess[r_end][c_end]+1;
            //6 moves
            if(c_end-2 >=0){//L
                if(chess[r_end][c_end-2]==0||chess[r_end][c_end-2]>distance){
                    chess[r_end][c_end-2]=distance;
                    step.add(new int[]{r_end,c_end-2});
                    r_path[r_end][c_end-2]=r_end;
                    c_path[r_end][c_end-2]=c_end;
                    path[r_end][c_end-2]="R";
                }
            }
            if(c_end+2<n){//R
                if(chess[r_end][c_end+2]==0||chess[r_end][c_end+2]>distance){
                    chess[r_end][c_end+2]=distance;
                    step.add(new int[]{r_end,c_end+2});
                    r_path[r_end][c_end+2]=r_end;
                    c_path[r_end][c_end+2]=c_end;
                    path[r_end][c_end+2]="L";
                }
            }
            if(r_end-2>=0){//U
                if( c_end-1>=0 ){//UL
                    if(chess[r_end-2][c_end-1]==0||chess[r_end-2][c_end-1]>distance){
                        chess[r_end-2][c_end-1]=distance;
                        step.add(new int[]{r_end-2,c_end-1});
                        r_path[r_end-2][c_end-1]=r_end;
                        c_path[r_end-2][c_end-1]=c_end;
                        path[r_end-2][c_end-1]="LR";
                    }
                }
                if( c_end+1<n){//UR
                    if(chess[r_end-2][c_end+1]==0||chess[r_end-2][c_end+1]>distance){
                        chess[r_end-2][c_end+1]=distance;
                        step.add(new int[]{r_end-2,c_end+1});
                        r_path[r_end-2][c_end+1]=r_end;
                        c_path[r_end-2][c_end+1]=c_end;
                        path[r_end-2][c_end+1]="LL";
                    }
                }
            }
            if(r_end+2<n){//L
                if(c_end-1>=0){//LL
                    if(chess[r_end+2][c_end-1]==0||chess[r_end+2][c_end-1]>distance){
                        chess[r_end+2][c_end-1]=distance;
                        step.add(new int[]{r_end+2,c_end-1});
                        r_path[r_end+2][c_end-1]=r_end;
                        c_path[r_end+2][c_end-1]=c_end;
                        path[r_end+2][c_end-1]="UR";
                    }
                }
                if(c_end+1<n){//LR
                    if(chess[r_end+2][c_end+1]==0||chess[r_end+2][c_end+1]>distance){
                        chess[r_end+2][c_end+1]=distance;
                        step.add(new int[]{r_end+2,c_end+1});
                        r_path[r_end+2][c_end+1]=r_end;
                        c_path[r_end+2][c_end+1]=c_end;
                        path[r_end+2][c_end+1]="UL";
                    }
                }

            }
        }
        if(chess[i_start][j_start]>0){
            System.out.println(chess[i_start][j_start]-1);
            System.out.println(Arrays.deepToString(r_path));
            System.out.println(Arrays.deepToString(c_path));
            System.out.println(Arrays.deepToString(path));
            int r_next=i_start;
            int c_next=j_start;
            while ((r_path[r_next][c_next]!=i_end) || (c_path[r_next][c_next]!=j_end)){
                System.out.print(path[r_next][c_next]+" ");
                int tmp_r = r_next;
                int tmp_c = c_next;
                r_next=r_path[tmp_r][tmp_c];
                c_next=c_path[tmp_r][tmp_c];

            }
            System.out.print(path[r_next][c_next]+" ");
            //print the step back
        } else {
            System.out.print("Impossible");
        }
    }

    static void printDotString(int n, StringBuffer string, char[] dot){
        stringCount++;
        StringBuffer finalOutput=new StringBuffer();
        for(int i=0;i<string.length();i++){
            finalOutput.append(string.charAt(i));
            if(dot[i]=='.')
                finalOutput.append('.');
        }
        System.out.println(finalOutput.toString());

        for(int i=0;i<n;i++){
            char[] newDot= new char[dot.length];
            System.arraycopy(dot,0,newDot,0,dot.length);
            newDot[i]='.';
            printDotString(i,string,newDot);
        }
    }
}
