# Huffman Coding

Huffman Coding is a Java implementation of the Huffman coding algorithm. 
This program allows you to encode and decode text files using Huffman coding, providing information about compression ratios.

## Overview

- `Compressor.java`: compresses a given file using Huffman encoding.
- `Decompressor.java`: decompresses a file previously compressed using Huffman encoding.
- `FileEncodedInfo`: holds information about a compressed file, including compressed data, original file name, recovery map, original length and data offset.
- `Huffman.java`: implements the Huffman encoding and decoding algorithms.
- `InputOutputManager.java`: manages input and output operations, including reading and writing compressed files.

## Usage

To use the Huffman compression algorithm, you can run the Main class with the following commands:

1. **To encode a file**: ```java Main compress <file_path>```
2. **To decode an archive**: ```java Main decompress <archive_path>```
3. **To get information about an archive**: ```java Main inform <archive_path>```

## Results

The Huffman compression algorithm has been implemented successfully, providing compression and decompression of data. 

- **Compression Ratio**: The compression ratio is calculated as the percentage of the original file length to the compressed file length. The ratio is printed during the testing phase.

- **Code Map**: The code map represents the mapping of symbols to their Huffman codes. This information is displayed during the testing phase.

- **Archive Information**: The inform command provides detailed information about the compressed archive, including original file name, length, and code mappings.

