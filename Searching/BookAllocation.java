// Problem:- https://www.geeksforgeeks.org/allocate-minimum-number-pages/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("No of Books? ");
        int n = Integer.parseInt(sc.readLine());

        int pages[] = new int[n];
        int i = 0;
        for(String s: sc.readLine().split(" ")) {
            pages[i] = Integer.parseInt(s);
            i++;
        }
        
        System.out.println("No of Students? ");
        int m = Integer.parseInt(sc.readLine());

        System.out.println("Max No of Pages - " + solution(n, m, pages));
    }

    public static int solution(int n, int m, int pages[]) {
        int start = pages[0];
        int end = Arrays.stream(pages).sum();

        while(start < end) {
            int mid = start + (end - start)/2;

            if(canAllocateBooks(n, m, pages, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static boolean canAllocateBooks(int n, int m, int[] pages, int maxPages) {
        int studentRequired = 1;
        int pagesCount = 0;

        for(int i = 0; i<pages.length; i++) {
            if(pages[i] > maxPages) {
                return false;
            } 

            if(pagesCount + pages[i] > maxPages) {
                studentRequired++;
                pagesCount = pages[i];
            } else {
                pagesCount += pages[i];
            }

            if(studentRequired > m) {
                return false;
            }
        }
        return true;
    }
}