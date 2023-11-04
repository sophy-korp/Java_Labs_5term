/*Написать программу, демонстрирующую использование

логических операций && || !
тернарной операции x < y ? x : y
поразрядных логических операций & | ^ ~
операции сдвига >> << >>>*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Логическое И (&&): ");
        System.out.println("&&    true   false");
        System.out.println("true  " + (true && true) + "   " + (true && false));
        System.out.println("false " + (false && true) + "  " + (false && true));

        System.out.println("Логическое ИЛИ (||): ");
        System.out.println("&&    true   false");
        System.out.println("true  " + (true || true) + "   " + (true || false));
        System.out.println("false " + (false || true) + "   " + (false || false));

        System.out.println("Логическое НЕ (!): ");
        System.out.println("!    true   false");
        System.out.println("     " + (!true) + "   " + (!false));

        System.out.println("Тернарный оператор: ");
        System.out.println("7 больше 9?: " + (9 > 7 ? "Да" : "Нет"));


        System.out.println("Поразрядные логические операции: ");
        int first = 0b1010;
        int second =  0b1001;
        System.out.println("1010 & 1100: " + Integer.toBinaryString(first & second));
        System.out.println("1010 | 1100: " + Integer.toBinaryString(first | second));
        System.out.println("1010 ^ 1100: " + Integer.toBinaryString(first ^ second));
        System.out.println("~(1010): " + Integer.toBinaryString(~first));


        System.out.println("Операции сдвига: ");
        System.out.println("101011 << 2: " + Integer.toBinaryString(0b101011 << 2));
        System.out.println("101011 >> 2: " + Integer.toBinaryString(0b101011 >> 2));
        System.out.println("11111111111111111111111111101011 >> 2: " +
                Integer.toBinaryString(0b11111111111111111111111111101011 >> 2));
        System.out.println("11111111111111111111111111101011 >>> 2: " +
                Integer.toBinaryString(0b11111111111111111111111111101011 >>> 2));
        System.out.println("101011 >>> 2: " + Integer.toBinaryString(0b101011 >>> 2));
    }
}
