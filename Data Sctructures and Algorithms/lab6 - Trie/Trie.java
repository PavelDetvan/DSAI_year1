import java.util.ArrayList;
import java.util.List;

/**
 * A class to store a Trie node
 */
public class Trie {

    public Node root;

    /**
     * constructor of class Trie
     */
    public Trie() {
        root = new Node();
    }

    /**
     * method to insert a word into a Trie
     * @param word to be inserted
     * @param value line in which the word appeared
     */
    public void insert(String word, int value) {
        // TODO Implement this
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index  = ch - 'a';      //this is because we want to map only english characters into the list (a has index 0, b 1; ths is because 'a'-'a'=0, 'b'-'a'=1)
            if(currentNode.children[index]==null){
                currentNode.children[index] = new Node();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEnd = true;
        currentNode.addValue(value);;
    }

    /**
     * method to search for a word
     * @param word to be searched for
     * @return list with numbers of lines where the word was found (Return an empty integer array if the word is not present in the trie)
     */
    public int[] search(String word) {
        // TODO Implement this
        // Return an empty integer array if the word is not present in the trie
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';       //this is because we want to map only english characters into the list (a has index 0, b 1; ths is because 'a'-'a'=0, 'b'-'a'=1)

            if(currentNode.children[index]==null){
                return new int[0];
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.getValues();
    }

    /**
     * class node
     */
    public class Node {
        public Node[] children; // The node's children
        private boolean isEnd; // Is the node the end of a word?
        private List<Integer> values; // This stores the line numbers

        /**
         * constructor of Node
         */
        public Node() {
            children = new Node[26]; // 26 letters in the alphabet
            values = new ArrayList<>();
        }

        /**
         * method to get a node of associated with the given char
         * @param ch char stored in the node
         * @return Node
         */
        public Node getNode(char ch) {
            // TODO Implement this
            //find the index
            int index = ch - 'a';       //this is because we want to map only english characters into the list (a has index 0, b 1; ths is because 'a'-'a'=0, 'b'-'a'=1)
            return children[index];
        }

        /**
         * method to set Node
         * @param ch char we want to store inside
         * @param node Node
         */
        public void setNode(char ch, Node node) {
            // TODO Implement this
            int index = ch - 'a';
            children[index] = node;
        }

        /**
         * check if the node with the given character exists
         * @param ch character
         * @return true if such a node exists, false if the node is null
         */
        public boolean containsKey(char ch) {
            // TODO Implement this
            int index = ch - 'a';
            return children[index]!=null;
        }

        /**
         * set the end of the word
         */
        public void setEnd() {
            isEnd = true;
        }

        /**
         * checks if its the end of the word
         * @return true if it is the end
         */
        public boolean isEnd() {
            return isEnd;
        }

        /**
         * add the line to the array
         * @param value line number
         */
        public void addValue(int value) {
            // TODO Implement this
            values.add(value);
        }

        /**
         * method to get the array with the line numbers
         * @return array with the line numbers
         */
        public int[] getValues() {
            // Magically turns Lists into arrays
            return values.stream().mapToInt(i -> i).toArray();
        }
    }
}