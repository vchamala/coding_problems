class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> integerList = new ArrayList<>();

      // TODO: REVISIT

        int n = arr.length;
        int m = arr[0].length;

        int start_row = 0;
        int end_row = n - 1;
        int start_col = 0;
        int end_col = m - 1;

        while (start_row <= end_row && start_col <= end_col) {
            // printing top elements
            for (int j = start_col; j <= end_col; j++) {
                integerList.add(arr[start_row][j]);
            }

            // printing right elements
            for (int i = start_row + 1; i <= end_row; i++) {
                integerList.add(arr[i][end_col]);
            }

            // printing bottom elements
            if (start_row < end_row) {
                for (int j = end_col - 1; j >= start_col; j--) {
                    integerList.add(arr[end_row][j]);
                }
            }

            // printing left elements
            if (start_col < end_col) {
                for (int i = end_row - 1; i >= start_row + 1; i--) {
                    integerList.add(arr[i][start_col]);
                }
            }

            start_col++;
            start_row++;
            end_col--;
            end_row--;
        }

        return integerList;
    }
}
