public class Decompressor {

    private Huffman huffman;

    public Decompressor() {
        this.huffman = new Huffman();
    }

    public void decompress(String filePath) {
        FileEncodedInfo fileEncodedInfo = InputOutputManager.readArchive(filePath);
        byte[] result = huffman.decode(fileEncodedInfo.compressedData, fileEncodedInfo.recoveryMap);
        InputOutputManager.writeFile(result, fileEncodedInfo.originalFileName);
    }
}