# Huffman Coding in Java

This project implements Huffman coding compression algorithm in Java.
Huffman coding is a lossless data compression algorithm that works by assigning variable-length codes to input characters
with shorter codes assigned to more frequent characters.

## Code Structure

The project consists of several Java classes:

- **BitInputStream**: A class extending `InputStream` to read bits from a file.
- **BitOutputStream**: A class extending `OutputStream` to write bits to a file.
- **HuffmanCoder**: The main class implementing Huffman coding. It includes methods for encoding, decoding and providing
information about the compression ratio.
- **HuffmanTree**: A utility class for building Huffman trees, generating Huffman codes and saving/reading information
about a file.
- **Node**: A class representing a node in the Huffman tree.
- **TreePriorityQueue**: A priority queue implementation for nodes used for building the Huffman tree.
- **Main**: The main class for user interaction, allowing users to choose between encoding, decoding or obtaining information
about a file.

## How to use

To use the Huffman coding functionality run the `Main` class. You'll be prompted to enter the input and output file names,
as well as choose between encoding, decoding or information mode.

### Example Usage

- Compile the Java files using ```javac *. java```

- Run the program using ```java Main```

- Enter the input and output file names as prompted

- Choose the operation mode (1 for encoding, 2 for decoding, 3 for information)

The program will perform the selected operation and provide relevant information accordingly.