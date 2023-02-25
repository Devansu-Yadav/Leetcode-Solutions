// T.C: O(N), Space Complexity: O(N)
class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] charsOfStr = s.toCharArray();

        int i = 0;
        int j = charsOfStr.length - 1;

        while(i <= j) {
            if(isVowel(charsOfStr[i])) {
                while(!isVowel(charsOfStr[j])) {
                    j--;
                }
                swapChars(charsOfStr, i, j);
            } else if(isVowel(charsOfStr[j])) {
                while(!isVowel(charsOfStr[i])) {
                    i++;
                }
                swapChars(charsOfStr, i, j);
            }
            i++;
            j--;
        }
        return String.valueOf(charsOfStr);
    }

    public static boolean isVowel(char c) {
        if(Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'e' || Character.toLowerCase(c) == 'i' || Character.toLowerCase(c) == 'o' || Character.toLowerCase(c) == 'u') {
            return true;
        }
        return false;
    }

    public void swapChars(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
