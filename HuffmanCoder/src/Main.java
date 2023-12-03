import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HuffmanCoder coder = new HuffmanCoder();

        System.out.println("Это приложение работает в трёх режимах.");
        System.out.println("Выберете нужный, введя соответствующую цифру:");
        System.out.println("1 - кодирование");
        System.out.println("2 - декодирование");
        System.out.println("3 - информирование");
        System.out.println("Для выхода из приложения введите -1.");

        int choice = 0;
        while(choice != -1){
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите имя файла, с которым предстоит работать");
                    String inputFile = scanner.next();

                    System.out.println("Введите имя файла, в который будет помещён результат работы");
                    String outputFile = scanner.next();

                    coder.toEncode(inputFile, outputFile);
                    break;
                case 2:
                    System.out.println("Введите имя файла, с которым предстоит работать");
                    String inputFileToDecode = scanner.next();

                    System.out.println("Введите имя файла, в который будет помещён результат работы");
                    String outputFileToDecode = scanner.next();

                    coder.toDecode(inputFileToDecode, outputFileToDecode);
                    break;
                case 3:
                    System.out.println("Введите имя файла, с которым предстоит работать");
                    String inputFileToInform = scanner.next();

                    System.out.println("Введите имя файла, в который будет помещён результат работы");
                    String outputFileToInform = scanner.next();

                    coder.toInform(inputFileToInform, outputFileToInform);
                    break;
                default:
                    System.out.println("Режима не существует. Пожалуйста, выберете режим от 1 до 3");
                    break;
            }
        }

    }
}