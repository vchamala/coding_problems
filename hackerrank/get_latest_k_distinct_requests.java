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
     * Complete the 'getLatestKRequests' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY requests
     *  2. INTEGER K
     */

    public static List<String> getLatestKRequests(List<String> requests, int K) {
    // Write your code here

        int reqSize = requests.size();
        
        // Insert elements in map and make sure that only higher order ones remain.
        Map<Integer, String> map = new HashMap<>();
        for (int i=reqSize-1; i>=0; i--) {
            if (map.values().contains(requests.get(i))) {
                continue;
            }
            map.put(i, requests.get(i));
        }
        Set<Integer> vals = map.keySet();
        List<Integer> valsList = new ArrayList<>(vals);
        Collections.sort(valsList);
        List<String> result = new ArrayList<>();
        
        // if vals size is less than K - then return all elements.
        if (vals.size() < K) {
            K = vals.size();
        }
        
        // return all values from last to until K most recent..
        for (int i=vals.size()-1; i>=vals.size()-K; i--) {
            result.add(map.get(valsList.get(i)));
        }
        return result;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int requestsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> requests = IntStream.range(0, requestsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int K = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.getLatestKRequests(requests, K);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

