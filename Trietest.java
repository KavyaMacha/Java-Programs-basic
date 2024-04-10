import java.util.*;

class Trietest {

    static final int NUM_CHARS = 26;
    static boolean isDeleted = false;

    static class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
        }
    };

    static TrieNode root;

    static void insert(String key) {
        TrieNode currentNode = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode();
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode currentNode = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (currentNode.children[index] == null)
                return false;
            currentNode = currentNode.children[index];
        }
        return currentNode != null && currentNode.isEndOfWord;
    }

    static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < NUM_CHARS; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    static TrieNode delete(TrieNode root, String key, int depth) {
        if (root == null)
            return null;

        if (depth == key.length()) {
            if (root.isEndOfWord)
                root.isEndOfWord = false;
            if (isEmpty(root))
                return null;
            return root;
        }

        int index = key.charAt(depth) - 'a';
        root.children[index] = delete(root.children[index], key, depth + 1);

        if (isEmpty(root) && !root.isEndOfWord) {
            return null;
        }
        return root;
    }

    static boolean isLeafNode(TrieNode root) {
        return root != null && root.isEndOfWord;
    }

    static void print(TrieNode root, char[] str, int level) {
        if (root == null)
            return;

        if (isLeafNode(root)) {
            for (int k = level; k < str.length; k++)
                str[k] = 0;
            System.out.println(new String(str));
        }

        for (int i = 0; i < NUM_CHARS; i++) {
            if (root.children[i] != null) {
                str[level] = (char) (i + 'a');
                print(root.children[i], str, level + 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String keys[] = sc.nextLine().split(" ");
        root = new TrieNode();

        for (int i = 0; i < keys.length; i++)
            insert(keys[i]);

        char[] str = new char[50];

        while (true) {
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    String s = sc.nextLine();
                    insert(s);
                    System.out.println("Content of Trie: ");
                    print(root, str, 0);
                    break;
                case 2:
                    String word = sc.next();
                    if (search(word))
                        System.out.println(word + " is present ");
                    else
                        System.out.println(word + " is not present");
                    break;
                case 3:
                    String wordToDelete = sc.next();
                    if (delete(root, wordToDelete, 0) != null)
                        System.out.println(wordToDelete + " is deleted ");
                    else
                        System.out.println(wordToDelete + " is not present in Trie to be deleted");
                    System.out.println("Content of Trie after deletion: ");
                    print(root, str, 0);
                    break;
                case 4:
                    System.out.println("Content of Trie: ");
                    print(root, str, 0);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
