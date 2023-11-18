
public class Main {
    public static void main(String[] args) {
       Triple<Integer> int_triple = new Triple<Integer>(1, 2, 3);
       Triple<Character> char_triple = new Triple<Character>('A', 'B', 'C');

       System.out.println(int_triple + ": ");
       try{
           System.out.println("\tМинимальный элемент: " + int_triple.min());
       }
       catch(ImpossibleOperationExeption e){
           System.out.println(e);
       }

        try{
            System.out.println("\tМаксимальный элемент: " + int_triple.max());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }

        try{
            System.out.println("\tСредний по значению элемент: " + int_triple.mean());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }



        System.out.println(char_triple + ": ");
        try{
            System.out.println("\tМинимальный элемент: " + char_triple.min());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }

        try{
            System.out.println("\tМаксимальный элемент: " + char_triple.max());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }

        try{
            System.out.println("\tСредний по значению элемент: " + char_triple.mean());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }


        int_triple.setFirst(2);
        System.out.println(int_triple + ": ");
        try{
            System.out.println("\tМинимальный элемент: " + int_triple.min());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }

        try{
            System.out.println("\tМаксимальный элемент: " + int_triple.max());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }

        try{
            System.out.println("\tСредний по значению элемент: " + int_triple.mean());
        }
        catch(ImpossibleOperationExeption e){
            System.out.println(e);
        }
    }
}