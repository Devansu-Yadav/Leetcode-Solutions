# Problem: https://leetcode.com/problems/design-add-and-search-words-data-structure/
# T.C: , S.C: 

class TreeNode:
    def __init__(self):
        self.children = {}
        self.end = False

class WordDictionary(object):

    def __init__(self):
        self.root = TreeNode()

    def addWord(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr = self.root

        for c in word:
            if c not in curr.children:
                curr.children[c] = TreeNode()
            curr = curr.children[c]
        curr.end = True

    def searchTrie(self, node, word):
        curr = node

        for i in range(len(word)):
            c = word[i]
            if c == ".":
                for child in curr.children:
                    # traverse through all children on that level
                    if self.searchTrie(curr.children[child], word[i+1:]):
                        return True
                return False
            elif c not in curr.children:
                return False
            # travserse through curr child matching c
            return self.searchTrie(curr.children[c], word[i+1:])
        return curr.end

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        return self.searchTrie(self.root, word)
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)