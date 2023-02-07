// Problem - https://leetcode.com/problems/search-a-2d-matrix

public class SearchInSorted2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMat(matrix, target);
    }
    
    public static boolean searchMat(int[][] matrix, int target) {
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        int midCol = (colStart + colEnd)/2;
        
        if(rStart == rEnd) {
            return binarySearch(matrix, rStart, colStart, colEnd, target);
        }
        
        while(rStart < rEnd && rEnd - rStart != 1) {
            int midRow = rStart + (rEnd - rStart)/2;
            
            if(matrix[midRow][midCol] == target) {
                return true;
            } else if(matrix[midRow][midCol] < target) {
                rStart = midRow;
            } else {
                rEnd = midRow;
            }
        }
        
        
        if(matrix[rStart][midCol] == target || matrix[rStart + 1][midCol] == target) {
            return true;
        } else if(colStart == colEnd) {
            return false;
        }
        
        if(target < matrix[rStart][midCol]) {
            return binarySearch(matrix, rStart, colStart, midCol - 1, target);
        } else if(target > matrix[rStart][midCol] && target <= matrix[rStart][colEnd]) {
            return binarySearch(matrix, rStart, midCol + 1, colEnd, target);
        } else if(target > matrix[rStart][colEnd] && target < matrix[rStart + 1][midCol]) {
            return binarySearch(matrix, rStart+1, colStart, midCol - 1, target);
        } else {
            return binarySearch(matrix, rStart+1, midCol+1, colEnd, target);
        }
        
    }
    
    public static boolean binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while(cStart <= cEnd) {
            int cMid = cStart + (cEnd - cStart)/2;
            
            if(matrix[row][cMid] == target) {
                return true;
            } else if(matrix[row][cMid] < target) {
                cStart = cMid + 1;
            } else {
                cEnd = cMid - 1;
            }
        }
        return false;
    }
}
