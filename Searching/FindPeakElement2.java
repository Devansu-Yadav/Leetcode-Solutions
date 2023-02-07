// Problem:- https://leetcode.com/problems/find-a-peak-element-ii/

public class FindPeakElement2 {
    public int[] findPeakGrid(int[][] mat) {
        return maxElementGrid(mat);
    }
    
    public static int[] maxElementGrid(int[][]mat) {
        int colStart = 0;
        int colEnd = mat[0].length - 1;
        int rowStart = 0;
        int rowEnd = mat.length - 1;
        
        while(colStart < colEnd) {
            int midCol = colStart + (colEnd - colStart)/2;
            // System.out.println("Mid Col - " + midCol);
            int midPeakInd = peakElementCol(midCol, rowStart, rowEnd, mat);
            // System.out.println("Peak in Mid Col - " + midPeakInd);
            
            int rightPeakInd = peakElementCol(midCol + 1, rowStart, rowEnd, mat);
            // System.out.println("Peak in Right Col - " + rightPeakInd);
            
            if(midCol + 1 <= colEnd && mat[midPeakInd][midCol] < mat[rightPeakInd][midCol + 1]) {
                colStart = midCol + 1;
            } else {
                colEnd = midCol;
            }
        }
        
        int peakRow = peakElementCol(colStart, rowStart, rowEnd, mat);
        return new int[]{peakRow, colStart};
    }
    
    public static int peakElementCol(int midCol, int rowStart, int rowEnd, int[][] mat) {   
        int maxElementInd = 0;
        for(int i = rowStart; i<=rowEnd; i++) {
            if(mat[maxElementInd][midCol] <= mat[i][midCol]) {
                maxElementInd = i;
            }
        }
        return maxElementInd;
    }
}