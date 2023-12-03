import java.io.*;
import java.util.*;
class HuffmanTree {
    public static final char INTERNAL_NODE_MARKER = '\0';

    public static Node buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        TreePriorityQueue priorityQueue = new TreePriorityQueue();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.addNode(new Node(entry.getValue(), entry.getKey(), null, null));
        }

        while (priorityQueue.priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            Node internalNode = new Node(left.frequency + right.frequency, INTERNAL_NODE_MARKER, left, right);
            priorityQueue.addNode(internalNode);
        }

        return priorityQueue.poll();
    }

    public static Map<Character, String> buildHuffmanCodes(Node root) {
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void buildCodes(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node != null) {
            if (node.character != INTERNAL_NODE_MARKER) {
                huffmanCodes.put(node.character, code);
            }

            buildCodes(node.left, code + "0", huffmanCodes);
            buildCodes(node.right, code + "1", huffmanCodes);
        }
    }

    public static void saveTree(Node root, BitOutputStream bitOutputStream) throws IOException {
        if (root != null) {
            if (root.character == INTERNAL_NODE_MARKER) {
                bitOutputStream.writeBit(0);
                saveTree(root.left, bitOutputStream);
                saveTree(root.right, bitOutputStream);
            } else {
                bitOutputStream.writeBit(1);
                bitOutputStream.writeBits(root.character, 8);
            }
        }
    }

    public static Node readTree(BitInputStream bitInputStream) throws IOException {
        int bit = bitInputStream.readBit();
        if (bit == 1) {
            char character = (char) bitInputStream.readBits(8);
            return new Node(0, character, null, null);
        } else {
            Node left = readTree(bitInputStream);
            Node right = readTree(bitInputStream);
            return new Node(0, INTERNAL_NODE_MARKER, left, right);
        }
    }
}