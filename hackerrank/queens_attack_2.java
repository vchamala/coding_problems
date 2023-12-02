import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        
        // Collect all the overall blocked locations due to blocked points..
        Set<List<Integer>> bl = new HasSet<>();
        for (int i=1; i<=obstacles.size(); i++) {
            if (obstacles.get(i).get(0)) == r_q) {
                if (obstacles.get(i).get(1)) > c_q) {
                    for (int i=obstacles.get(i).get(1); i<=n; i++) {
                        bl.add(r_q, i);
                    }
                } else {
                    for (int i=1; i<=obstacles.get(i).get(1); i++) {
                        bl.add(r_q, i);
                    }
                }
            } 
            
            if (obstacles.get(i).get(1) == c_q) {
                if (obstacles.get(i).get(0)) > r_q) {
                    for (int i=obstacles.get(i).get(0); i<=n; i++) {
                        bl.add(i, c_q);
                    }
                } else {
                    for (int i=1; i<=obstacles.get(i).get(0); i++) {
                        bl.add(i, c_q);
                    }
                }
            }
            
            if (obstacles.get(i).get(0) < r_q &&
             obstacles.get(i).get(1) < c_q) {
                 // add all diagnol elements..
                 int row=obstacles.get(i).get(0);
                 int col = obstacles.get(i).get(1);
                 while (row>=1 && col>=1) {
                     bl.add(row, col);
                     row--;
                     col--;
                 }
            }
            
            if (obstacles.get(i).get(0) > r_q &&
             obstacles.get(i).get(1) < c_q) {
                 // add all diagnol elements..
                 int row=obstacles.get(i).get(0);
                 int col = obstacles.get(i).get(1);
                 while (row<=n && col>=1) {
                     bl.add(row, col);
                     row++;
                     col--;
                 }
            }
            
            if (obstacles.get(i).get(0) > r_q &&
             obstacles.get(i).get(1) > c_q) {
                 // add all diagnol elements..
                 int row=obstacles.get(i).get(0);
                 int col = obstacles.get(i).get(1);
                 while (row<=n && col<=n) {
                     bl.add(row, col);
                     row++;
                     col++;
                 }
            }
            
            if (obstacles.get(i).get(0) < r_q &&
             obstacles.get(i).get(1) > c_q) {
                 // add all diagnol elements..
                 int row=obstacles.get(i).get(0);
                 int col = obstacles.get(i).get(1);
                 while (row>=1 && col<=n) {
                     bl.add(row, col);
                     row--;
                     col++;
                 }
            }
        }
        // here bl is the set of positions that are blocked..
        // so total positions on board - blocked positions is the number of positions that queen can attack
        return n*n - bl.size();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
