# Problem: https://leetcode.com/problems/lexicographical-numbers/description/

class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False
        self.data = ''

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insertInTrie(self, num):
        curr = self.root

        for c in num:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        
        curr.end = True
        curr.data = num
    
    def fetchNumbersFromTrie(self, curr, res):
        if curr.end:
            res.append(int(curr.data))
        
        for n in range(10):
            if str(n) in curr.children:
                self.fetchNumbersFromTrie(curr.children[str(n)], res)

class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        result = []
        trie = Trie()

        for num in range(1, n+1):
            trie.insertInTrie(str(num))

        trie.fetchNumbersFromTrie(trie.root, result)
        return result