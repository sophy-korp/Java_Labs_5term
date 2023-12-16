import java.io.File;

public class Compressor {

    private Huffman huffman;

    public Compressor() {
        this.huffman = new Huffman();
    }

    public FileEncodedInfo compress(String filePath) {
        FileEncodedInfo fileEncodedInfo = new FileEncodedInfo();
        byte[] data = InputOutputManager.readFile(filePath);
        byte[] result = huffman.encode(data);
        File file = new File(filePath);
        String originalFileName = file.getName();
        String outputFilePath = originalFileName.substring(0, originalFileName.lastIndexOf('.')) + ".arc";
        InputOutputManager.writeArchive(result, huffman.codeMap, originalFileName, outputFilePath);
        fileEncodedInfo = InputOutputManager.readArchive(outputFilePath);
        return fileEncodedInfo;
    }
}
