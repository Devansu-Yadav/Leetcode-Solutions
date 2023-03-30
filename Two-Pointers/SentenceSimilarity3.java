// T.C: O(n1) i.e no of words in smallest sentence, Space Complexity: O(n1 + n2)

class SentenceSimilarity3 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");
        return s1.length <= s2.length ? checkSimilarity(s1, s2) : checkSimilarity(s2, s1);
    }

    public static boolean checkSimilarity(String[] smallStr, String[] largeStr) {
        int i = 0;
        int n1 = smallStr.length, n2 = largeStr.length;
        // Comparing prefixes of both strings
        while(i < n1 && smallStr[i].equals(largeStr[i])) {
            i++;
        }

        // Comparing tail end of both strings
        while(i < n1 && smallStr[i].equals(largeStr[n2 - (n1 - i)])) {
            i++;
        }
        return i == n1;
    }
}
