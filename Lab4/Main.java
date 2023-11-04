import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte ByteVariable;
        short ShortVariable;
        int IntegerVariable;
        char CharVariable;
        String StringVariable;
        enum Colours {
            GREEN,
            YELLOW,
            BLUE,
            VIOLET
        };
        Scanner in = new Scanner(System.in);
        // Byte switch case
        System.out.println("Введите число от 1 до 3: ");
        ByteVariable = in.nextByte();
        switch (ByteVariable) {
            case 0 -> System.out.println("ByteVariable is empty");
            case 1 -> System.out.println("ByteVariable = 1");
            case 2 -> System.out.println("ByteVariable = 2");
            case 3 -> System.out.println("ByteVariable = 3");
            default -> System.out.println("ByteVariable вне допустимого диапазона");
        }

        System.out.println("Введите число от 50 до 52: ");
        ShortVariable = in.nextShort();
        switch (ShortVariable) {
            case 0 -> System.out.println("ShortVariable is empty");
            case 50 -> System.out.println("ShortVariable = 50");
            case 51 -> System.out.println("ShortVariable = 51");
            case 52 -> System.out.println("ShortVariable = 52");
            default -> System.out.println("ShortVariable вне допустимого диапазона");
        }

        System.out.println("Введите число от 562 до 564: ");
        IntegerVariable = in.nextInt();
        switch (IntegerVariable) {
            case 0 -> System.out.println("IntegerVariable is empty");
            case 562 -> System.out.println("IntegerVariable = 562");
            case 563 -> System.out.println("IntegerVariable = 563");
            case 564 -> System.out.println("IntegerVariable = 564");
            default -> System.out.println("IntegerVariable вне допустимого диапазона");
        }

        System.out.println("Введите символ (@, $, *): ");
        CharVariable = in.next().charAt(0);;
        switch (CharVariable) {
            case 0 -> System.out.println("CharVariable is empty");
            case '@' -> System.out.println("CharVariable = @");
            case '$' -> System.out.println("CharVariable = $");
            case '*' -> System.out.println("CharVariable = *");
            default -> System.out.println("Введён другой символ");
        }

        System.out.println("Ведите слово");
        StringVariable = in.next();
        switch (StringVariable) {
            case "Яблоко" -> System.out.println("StringVariable = \"Яблоко\"");
            case "Груша" -> System.out.println("\"StringVariable = \"Груша\"");
            default -> System.out.println("Введено неизвестное слово");
        }
        
        System.out.println("Enum switch case");
        Colours colour = Colours.GREEN;
        switch (colour) {
            case GREEN -> System.out.println("Лягушка");
            case BLUE -> System.out.println("Небо");
            case YELLOW -> System.out.println("Солнце");
            case VIOLET -> System.out.println("Аконит");
            default -> System.out.println("Неизвестный цвет");
        }
    };
};