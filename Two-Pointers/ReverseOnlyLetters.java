class ReverseOnlyLetters {
    // T.C: O(N), Space Complexity: O(N)
    public String reverseOnlyLetters(String s) {
        String output = "";
        int i = 0;
        int j = s.length() - 1;

        while(i < s.length()) {
            // insert letter at j in string only if i is also a letter. 
            if(j >= 0 && Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j))) {
                output += s.charAt(j);
                i++;
                j--;
            } else if(!Character.isLetter(s.charAt(i))) {
                // insert char at i as it is not a letter.
                output += s.charAt(i);
                i++;
            } else {
                // skip j if char at j is not a letter.
                j--;
            }
        }
        return output;
    }

    // T.C: O(N), Space Complexity: O(N)
    public String reverseOnlyLettersBetterSol(String s) {
        char[] charArr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            // swap letter at j in string only if i is also a letter. 
            if(Character.isLetter(charArr[i]) && Character.isLetter(charArr[j])) {
                swap(charArr, i, j);
                i++;
                j--;
            } else if(!Character.isLetter(charArr[i])) {
                // skip char at i as it is not a letter.
                i++;
            } else {
                // skip j if char at j is not a letter.
                j--;
            }
        }
        return String.valueOf(charArr);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
