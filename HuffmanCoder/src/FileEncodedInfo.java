import java.util.HashMap;

public class FileEncodedInfo {
    String compressedData;
    String originalFileName;
    HashMap<String, Byte> recoveryMap;
    int originalLength;
    int dataOffset;
}
