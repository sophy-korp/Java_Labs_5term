public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("There are no arguments");
        }
        else{
            for(String arg : args){
                System.out.println(arg);
            }
        }
    }
}