import java.io.*;

class BitInputStream extends InputStream {
    private FileInputStream input;
    private int currentByte;
    private int numBitsFilled;

    public BitInputStream(String inputFile) throws FileNotFoundException {
        input = new FileInputStream(inputFile);
        currentByte = 0;
        numBitsFilled = 0;
    }

    @Override
    public int read() throws IOException {
        return readBit();
    }

    public int readBit() throws IOException {
        if (currentByte == -1)
            return -1;

        if (numBitsFilled == 0) {
            currentByte = input.read();
            if (currentByte == -1)
                return -1;
            numBitsFilled = 8;
        }

        int bit = (currentByte >> (numBitsFilled - 1)) & 1;
        numBitsFilled--;

        return bit;
    }

    @Override
    public void close() throws IOException {
        input.close();
    }

    public int readBits(int numBits) throws IOException {
        int result = 0;
        for (int i = 0; i < numBits; i++) {
            int bit = readBit();
            result = (result << 1) | bit;
        }
        return result;
    }
}