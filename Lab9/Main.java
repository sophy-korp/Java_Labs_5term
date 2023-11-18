import java.lang.foreign.SymbolLookup;
import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Person");
            Object pers = cls.getConstructor(String.class, String.class, String.class).newInstance("Jhon", "Oxford", "Xstreet, 22");
            System.out.println(cls.getMethod("PrintInfo").invoke(pers));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}