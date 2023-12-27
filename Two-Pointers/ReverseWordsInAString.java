public class ReverseWordsInAString {
    // T.C: O(N), Space Complexity: O(N)
    // Better Solution: https://leetcode.com/problems/reverse-words-in-a-string/solutions/47797/in-place-java-solution-with-comments-just-for-fun/
    public String reverseWords(String s) {
        return reverse(s);
    }

    public static String reverse(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length - 1; i >= 0; i--) {
            if(!arr[i].equals("")) {
                sb.append(arr[i] + " ");
            }
        }
        String outStr = sb.toString();
        return outStr.substring(0, outStr.length() - 1);
    }
}
