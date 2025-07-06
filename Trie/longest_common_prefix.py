# Problem: https://leetcode.com/problems/longest-common-prefix/?envType=problem-list-v2&envId=trie
# TC: O(N), SC: O(1)

class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]

        curr.end = True

    def lcp(self, curr, prefix):
        if len(curr.children) == 1 and not curr.end:
            child = list(curr.children.keys())[0]
            return self.lcp(curr.children[child], prefix + child)

        return prefix

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        trie = Trie()

        for word in strs:
            trie.insert(word)
            
        return trie.lcp(trie.root, "")
        