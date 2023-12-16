import java.lang.UnsupportedOperationException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class InputOutputManager {
    static String NAME = "KORPUSOVA";

    static private void readArchiveHeader(String filePath, FileEncodedInfo fileEncodedInfo) {
        HashMap<String, Byte> recoveryMap = new HashMap<>();

        StringBuilder headerData = new StringBuilder();
        String originalFileName = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            headerData.append(header).append('\n');

            if (!header.equals(NAME)) {
                throw new UnsupportedOperationException("Wrong file format");
            }

            originalFileName = br.readLine();
            headerData.append(originalFileName).append('\n');

            if (originalFileName.isEmpty()) {
                throw new Exception("Missing original file name");
            }

            String recoveryMapSizeString = br.readLine();
            headerData.append(recoveryMapSizeString).append('\n');

            int recoveryMapSize = Integer.parseInt(recoveryMapSizeString);
            if (recoveryMapSize == 0) {
                throw new Exception("Missing encoding table");
            }

            for (int index = 0; index < recoveryMapSize; index += 1) {
                char symbol;
                String code;
                String rec = br.readLine();

                if (rec.isEmpty()) {
                    symbol = '\n';
                    code = br.readLine();

                    headerData.append(symbol).append(code).append('\n');
                } else {
                    symbol = rec.charAt(0);
                    code = rec.substring(1);
                    headerData.append(rec).append('\n');
                }

                recoveryMap.put(code, (byte) symbol);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        fileEncodedInfo.dataOffset = headerData.toString().getBytes().length;
        fileEncodedInfo.recoveryMap = recoveryMap;
        fileEncodedInfo.originalFileName = originalFileName;
    }

    static private int getAdditionalZerosNumber(String compressed) {
        String delta = compressed.substring(0, 8);
        return Integer.parseInt(delta, 2);
    }

    static private void readArchiveData(String filePath, FileEncodedInfo fileEncodedInfo) {
        File compressedFile = new File(filePath);
        StringBuilder compressed = new StringBuilder();
        int originalLength = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream(compressedFile);

            fileInputStream.skip(fileEncodedInfo.dataOffset);

            while (true) {
                int cur = fileInputStream.read();
                if (cur == -1) {
                    break;
                }
                originalLength += 1;

                compressed.append(String.format("%8s", Integer.toBinaryString(((byte) cur) & 0xff)).replace(" ", "0"));
            }

            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        int additionalZerosNumber = getAdditionalZerosNumber(compressed.toString());

        fileEncodedInfo.originalLength = originalLength;
        fileEncodedInfo.compressedData = compressed.substring(8, compressed.length() - additionalZerosNumber);
    }

    static public FileEncodedInfo readArchive(String filePath) {
        FileEncodedInfo fileEncodedInfo = new FileEncodedInfo();

        readArchiveHeader(filePath, fileEncodedInfo);
        readArchiveData(filePath, fileEncodedInfo);

        return fileEncodedInfo;
    }

    static public byte[] readFile(String filePath) {
        File srcFile = new File(filePath);

        byte[] data = new byte[(int) srcFile.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(srcFile);

            fileInputStream.read(data);

            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;
    }

    static public void writeArchive(byte[] result, HashMap<Byte, String> codeMap, String originalFileName, String outputFilePath) {
        StringBuilder archiveHeader = new StringBuilder(NAME + "\n");
        archiveHeader.append(originalFileName).append("\n");
        archiveHeader.append(codeMap.size()).append('\n');

        for (Map.Entry<Byte, String> entry : codeMap.entrySet()) {
            Byte symbol = entry.getKey();
            String code = entry.getValue();

            archiveHeader.append((char) (symbol & 0xFF)).append(code).append('\n');
        }

        try (PrintWriter pw = new PrintWriter(outputFilePath)) {
            pw.write(archiveHeader.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Wrong file, or the file does not exist");
        }

        try {
            FileOutputStream fos = new FileOutputStream(outputFilePath, true);

            fos.write(result);
            fos.close();

            System.out.println("File was compressed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static public void writeFile(byte[] result, String outputFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(outputFilePath, false);

            fos.write(result, 0, result.length);
            fos.flush();
            fos.close();

            System.out.println("File was decompressed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static public void test(FileEncodedInfo fileEncodedInfo, byte[] result) {

        if (result.length > 0) {
            System.out.println("Compress ratio: " + (100 * fileEncodedInfo.originalLength / result.length) + "%");
        }

        System.out.println("Code map:");

        for (Map.Entry<String, Byte> entry : fileEncodedInfo.recoveryMap.entrySet()) {
            String code = entry.getKey();
            byte symbol = entry.getValue();
            char c = (char) symbol;
            System.out.println(c + "=" + code);
        }
    }
}
