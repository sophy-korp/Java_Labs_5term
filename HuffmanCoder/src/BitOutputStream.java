import java.io.*;
class BitOutputStream {
    private FileOutputStream output;
    private int currentByte;
    private int numBitsFilled;

    public BitOutputStream(String outputFile) throws FileNotFoundException {
        output = new FileOutputStream(outputFile);
        currentByte = 0;
        numBitsFilled = 0;
    }

    public void writeBit(int bit) throws IOException {
        if (!(bit == 0 || bit == 1))
            throw new IllegalArgumentException("Аргументы должны быть 0 или 1");

        currentByte = (currentByte << 1) | bit;
        numBitsFilled++;

        if (numBitsFilled == 8) {
            output.write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
    }

    public void close() throws IOException {
        while (numBitsFilled != 0) {
            writeBit(0);
        }
        output.close();
    }

    public void writeBits(int bits, int numBits) throws IOException {
        for (int i = numBits - 1; i >= 0; i--) {
            int bit = (bits >> i) & 1;
            writeBit(bit);
        }
    }
}