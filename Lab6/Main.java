// Написать программу, реализующую операции стек с использованием массива
public class Main {
    public static void main(String[] args) {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(5);
        System.out.println("Стек пуст?: " + stack.is_empty());

        System.out.println("Добавим в стек элементы (числа от 1 до 7)");
        for(int i = 1; i <= 7; i++){
            stack.push(i);
        }
        System.out.println("Стек пуст?: " + stack.is_empty());

        System.out.println("Количество элементов в стеке: " + stack.size());
        System.out.println("Последний элемент: " + stack.peek());

        System.out.println("Удалим последний элемент");
        stack.pop();
        System.out.println("Количество элементов в стеке: " + stack.size());
        System.out.println("Последний элемент: " + stack.peek());

        System.out.println("Распечатаем стек: ");
        while(!stack.is_empty()){
            System.out.println(stack.pop());
        }
    }
}