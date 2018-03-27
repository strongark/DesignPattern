package CodeFight;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tranpham on 3/14/18.
 */
public class Tournament10Min {

    public boolean robotWalk(int[] a) {

        return true;
    }

    public int maxSubmatrixSum(int[][] matrix, int n, int m) {

        int result = 0;
        for (int i = 0; i + n <= matrix.length; i++) {
            for (int j = 0; j + n <= matrix[0].length; j++) {
                int sum = 0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        sum += matrix[i + x][j + y];
                    }
                }
                if (i == 0 && j == 0 || sum > result) {
                    result = sum;
                }
            }
        }

        return result;
    }

    public int[][] spiralNumbers(int n) {
        int[][] direction ={{0,1},{1,0},{0,-1},{-1,0}};
        int nextDirect=0;
        int curRow=0,curCol=0;
        int[][] res= new int[n][n];
        for(int i=1;i<=n*n;i++){
            res[curRow][curCol]=i;
            if(curCol+direction[nextDirect][1]<0 || curCol+direction[nextDirect][1]>=n
                    || curRow+direction[nextDirect][0]<0 || curRow+direction[nextDirect][0]>=n
                    ||res[curRow+direction[nextDirect][0]][curCol+direction[nextDirect][1]]!=0){
                        nextDirect=(nextDirect+1)%4;

            }
            curRow+=direction[nextDirect][0];
            curCol+=direction[nextDirect][1];
        }
        return res;
    }

    public int electionsWinners(int[] votes, int k) {
        int res=0;
        int max= Arrays.stream(votes).max().getAsInt();
        for(int i=0;i<votes.length;i++){
            if(votes[i]+k>max)
                res++;
        }
        return res;
    }

    public ArrayList<Integer> cyclicQueue(String[] commands) {
        final int maxSize = 10;
        int[] myQueue = new int[maxSize];
        ArrayList<Integer> answer = new ArrayList<>();
        int head = 0;
        int tail = 0;
        int sum = 0;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("-")) {
                sum -= myQueue[head];
                head = (head + 1) % maxSize;
            }
            else {
                int value = 0;

                value = Integer.parseInt(commands[i].substring(1));
                sum += value;
                myQueue[tail] = value;
                tail = (tail + 1) % maxSize;
            }
            answer.add(sum);
        }

        return answer;
    }

    public int maximizeNumberRoundness(int n) {
        int tmp = n;
        int zeros = 0;
        while (tmp != 0) {
            if (tmp % 10 == 0) {
                zeros++;
            }
            tmp /= 10;
        }
        int result = zeros;
        while (n != 0) {
            if (n % 10 == 0) {
                result--;
            }
            n /= 10;
        }
        return result;
    }
/*
* A pattern can be represented as a string containing lowercase English letters and special characters: question marks and asterisks. Each question mark should be replaced by exactly one letter, and each asterisk should be replaced by zero or more letters (possibly different).

A string of letters matches a pattern if question marks and asterisks in the latter can be replaced by letters in such a way that pattern will become equal to a given string.

Does a given string match a given pattern?

Example

For input = "abacaba" and pattern = "?*b?", the output should be
patternMatching(input, pattern) = true;
For input = "abacaba" and pattern = "?*ca?", the output should be
patternMatching(input, pattern) = false.
Input/Output

[execution time limit] 3 seconds (java)

[input] string input

A string of lowercase Latin letters.

Guaranteed constraints:
1 ≤ input.length ≤ 10.

[input] string pattern

A string of lowercase Latin letters, question marks and asterisks.

Guaranteed constraints:
4 ≤ pattern.length ≤ 10.

[output] boolean

true if input string matches pattern, false otherwise.
* */
    public boolean patternMatching(String input, String pattern) {

        boolean[][] dp = new boolean[input.length() + 1][pattern.length() + 1];

        dp[0][0] = true;
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
      //...
                if (i < input.length()
                        && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                    dp[i + 1][j + 1] = true;
                }
                if (pattern.charAt(j) == '*') {
                    for (int k = 0; i + k <= input.length(); k++) {
                        dp[i + k][j + 1] = true;
                    }
                }
            }
        }

        return dp[input.length()][pattern.length()];
    }

    /*
    the first 5 digits are initially given;
for i > 4, a[i] = (a[i - 5] + a[i - 4] + a[i - 3] + a[i - 2] + a[i - 1]) % 10, i.e. each element starting with the fifth is the sum of the previous five elements modulo 10.
    *def sequenceElement(a, n):
    i = 0
    cur = tuple(a)
    seen = {}
    while cur not in seen:
        seen[cur] = i
        a.append(sum(a[-5:]) % 10)
        cur = tuple(a[-5:])

    if n < len(a):
        return a[n]

    a = a[seen[cur]:-5]
    return a[(n - seen[cur]) % len(a)]

    * */
}
