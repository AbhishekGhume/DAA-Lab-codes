// 2. Huffman Coding Compression Algorithm
// Huffman coding (also known as Huffman Encoding) is an algorithm for doing data compression, and it forms the basic idea behind file compression. Implement the variable length encoding, uniquely decodable codes, prefix rules, and Huffman Tree construction.

import java.util.PriorityQueue;

public class HuffmanCoding {
    // A Huffman tree node
    static class Node implements Comparable<Node> {
        char data;
        int frequency;
        Node left, right;
        
        public Node(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = right = null;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }
    
    // Print Huffman codes from the root of the Huffman Tree
    public static void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }
        
        // If this is a leaf node, print the character and its code
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
            System.out.println(root.data + ": " + code);
            return;
        }
        
        // Traverse left
        printCodes(root.left, code + "0");
        
        // Traverse right
        printCodes(root.right, code + "1");
    }
    
    // Build Huffman Tree
    public static void buildHuffmanTree(char[] charArray, int[] freqArray) {
        int n = charArray.length;
        
        // Create a priority queue to store nodes of the Huffman tree
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        // Create leaf nodes and add them to the priority queue
        for (int i = 0; i < n; i++) {
            queue.add(new Node(charArray[i], freqArray[i]));
        }
        
        // Create the Huffman tree
        Node root = null;
        
        while (queue.size() > 1) {
            // Extract the two minimum frequency nodes
            Node left = queue.poll();
            Node right = queue.poll();
            
            // Create a new internal node with these two nodes as children
            // and with a frequency equal to the sum of the two nodes' frequencies
            Node newNode = new Node('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            
            root = newNode;
            
            // Add this node to the priority queue
            queue.add(newNode);
        }
        
        // Print Huffman codes
        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
    
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqArray = {5, 9, 12, 13, 16, 45};
        
        buildHuffmanTree(charArray, freqArray);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}