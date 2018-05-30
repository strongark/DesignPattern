package CodeFight;

public class Graph {
    /*
    * 0 0 0 0 0
    * 0 1 0 0 0
    * 0 1 0 0 0
    * 0 1 0 1 0
    * 0 0 0 1 0
    * 1 - blocker
    * */
    public int countPath(int[] start, int[] dest, int[][] matrix, String sofar){
        sofar+="->("+start[0]+";"+start[1]+")";
        if(isViolate(start,matrix)) { //blocked or hit boundary
            return 0;
        }
        if(start[0]==dest[0] && start[1]==dest[1]){//found path
            System.out.println(sofar);
            return 1;
        }
        int[] right = {start[0],start[1]+1};
        int[] down  = {start[0]+1, start[1]};
        return countPath(right,dest,matrix,sofar) + countPath(down,dest,matrix,sofar);
    }

    private boolean isViolate(int[] point, int[][] matrix){
        return point[0]>=matrix.length || point[1]>=matrix[0].length || matrix[point[0]][point[1]]==1 ;
    }
}
