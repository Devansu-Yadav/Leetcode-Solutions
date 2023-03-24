// T.C: O(N), Space Complexity: O(N)

class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        int j = 0;

        while(j < word.length() && word.charAt(j) != ch) {
            j++;
        }

        // if char ch doesn't exist in word
        if(j == word.length()) {
            return word;
        }
        return reverseSubstr(word, i, j);
    }

    public static String reverseSubstr(String str, int start, int end) {
        char[] arr = str.toCharArray();
        char temp;

        while(start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
}
