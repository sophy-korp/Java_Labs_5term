import java.lang.reflect.*;
import java.util.Scanner;

public class Main {

    public static void ShowClassInfo(Class<?> cls){
        System.out.println("Имя класса: " + cls.getName());

        System.out.println("Имя пакета: " + cls.getPackage().getName());


        Field[] fields = cls.getDeclaredFields();
        System.out.println("Объявленные поля:");
        for (Field field : fields) {
            System.out.println("  " + field.getType().getName() + " " + field.getName());
        }


        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        System.out.println("Объявленные конструкторы:");
        for (Constructor<?> constructor : constructors) {
            System.out.print("  " + constructor.getName() + "(");
            Parameter[] parameters = constructor.getParameters();
            for (int index = 0; index < parameters.length; index += 1) {
                System.out.print(parameters[index].getType().getName() + " " + parameters[index].getName());

                if (index < parameters.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }


        Method[] methods = cls.getDeclaredMethods();
        System.out.println("Объявленные методы:");
        for (Method method : methods) {
            System.out.print("  " + method.getReturnType().getName() + " " + method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (int index = 0; index < parameters.length; index += 1) {
                System.out.print(parameters[index].getType().getName() + " " + parameters[index].getName());
                if (index < parameters.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }


    };


    public static void main(String[] args) {
        ShowClassInfo(Person.class);

        System.out.print("\n");
        ShowClassInfo(Scanner.class);

        System.out.print("\n");
        ShowClassInfo(Math.class);
    };
};