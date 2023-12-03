import java.io.*;
import java.util.*;
public class HuffmanCoder {
    public void toEncode(String inputFile, String outputFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            Map<Character, Integer> frequencyMap = new HashMap<>();

            int data;
            while ((data = fileInputStream.read()) != -1) {
                char character = (char) data;
                frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
            }
            fileInputStream.close();

            Node root = HuffmanTree.buildHuffmanTree(frequencyMap);
            Map<Character, String> huffmanCodes = HuffmanTree.buildHuffmanCodes(root);

            BitOutputStream bitOutputStream = new BitOutputStream(outputFile);

            HuffmanTree.saveTree(root, bitOutputStream);

            fileInputStream = new FileInputStream(inputFile);
            while ((data = fileInputStream.read()) != -1) {
                char character = (char) data;
                String code = huffmanCodes.get(character);
                for (char bit : code.toCharArray()) {
                    bitOutputStream.writeBit(bit - '0');
                }
            }
            fileInputStream.close();
            bitOutputStream.close();

            System.out.println("Файл успешно закодирован!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toDecode(String inputFile, String outputFile) {
        try {
            BitInputStream bitInputStream = new BitInputStream(inputFile);

            Node root = HuffmanTree.readTree(bitInputStream);

            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            Node current = root;
            int bit;
            while ((bit = bitInputStream.readBit()) != -1) {
                if (bit == 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }

                if (current.left == null && current.right == null) {
                    fileOutputStream.write(current.character);
                    current = root;
                }
            }
            bitInputStream.close();
            fileOutputStream.close();

            System.out.println("Файл успешно декодирован!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toInform(String inputFile, String outputFile) {
        try {
            int decodedFileSize = decodeFile(inputFile, outputFile);
            int encodedFileSize = getFileSize(inputFile);

            System.out.println("Начальный размер: " + decodedFileSize);
            System.out.println("Размер закодированного файла: " + encodedFileSize);

            if (decodedFileSize != -1 && encodedFileSize != -1 && encodedFileSize != 0) {
                double compressionRatio = (double) encodedFileSize / decodedFileSize;
                System.out.println("Степень сжатия: " + compressionRatio);
            }

            BitInputStream bitInputStream = new BitInputStream(inputFile);
            Node root = HuffmanTree.readTree(bitInputStream);

            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Дерево Хаффмана:");
            printHuffmanTree(root, "", bufferedWriter);

            bufferedWriter.newLine();

            bufferedWriter.close();

            bitInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printHuffmanTree(Node node, String code, BufferedWriter bufferedWriter) throws IOException {
        if (node != null) {
            if (node.character == HuffmanTree.INTERNAL_NODE_MARKER) {
                printHuffmanTree(node.left, code + "0", bufferedWriter);
                printHuffmanTree(node.right, code + "1", bufferedWriter);
            } else {
                String output = "Символ: " + node.character + ", Код: " + code;
                System.out.println(output);
                bufferedWriter.write(output);
                bufferedWriter.newLine();
            }
        }
    }

    public int decodeFile(String inputFile, String outputFile) {
        try {
            BitInputStream bitInputStream = new BitInputStream(inputFile);
            Node root = HuffmanTree.readTree(bitInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

            Node current = root;
            int bit;
            int decodedSize = 0;

            while ((bit = bitInputStream.readBit()) != -1) {
                decodedSize++;
                if (bit == 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }

                if (current.left == null && current.right == null) {
                    fileOutputStream.write(current.character);
                    current = root;
                }
            }

            bitInputStream.close();
            fileOutputStream.close();

            return decodedSize / 8; // размер в байтах

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getFileSize(String filePath) {
        try {
            File file = new File(filePath);
            return (int) file.length();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}