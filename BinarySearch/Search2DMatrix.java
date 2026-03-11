package BinarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1;
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= matrix[mid][matrix[0].length - 1] && target >= matrix[mid][0]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                right--;
            } else {
                left++;
            }
        }

        if (row == -1)
            return false;
        left = 0;
        right = matrix[0].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
