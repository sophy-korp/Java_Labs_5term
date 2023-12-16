import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    Huffman h = new Huffman();

    String[] nargs = new String[args.length];
    System.arraycopy(args, 0, nargs, 0, args.length);

    String[] commands = new String[] { "compress", "decompress", "inform" };

    if (args.length == 0 || !(Arrays.asList(commands).contains(args[0]))) {
      nargs = new String[args.length + 1];
      System.arraycopy(args, 0, nargs, 1, args.length);
      nargs[0] = "compress";
    }

    switch (nargs[0]) {
      case "decompress" -> {
        if (nargs.length <= 1) {
          throw new IllegalArgumentException("Provide path to archive file");
        }

        Decompressor decompressor = new Decompressor();
        decompressor.decompress(args[1]);
      }
      case "compress" -> {
        if (nargs.length <= 1) {
          throw new IllegalArgumentException("Provide path to a file");
        }

        Compressor compressor = new Compressor();
        FileEncodedInfo fileEncodedInfo = compressor.compress(nargs[1]);

      }
      case "inform" -> {
        if (nargs.length <= 1) {
          throw new IllegalArgumentException("Provide path to archive file");
        }

        FileEncodedInfo fileEncodedInfo = InputOutputManager.readArchive(args[1]);
        byte[] result = h.decode(fileEncodedInfo.compressedData, fileEncodedInfo.recoveryMap);

        InputOutputManager.test(fileEncodedInfo, result);
      }
      default -> throw new IllegalArgumentException("Wrong string");
    }
  }
}
