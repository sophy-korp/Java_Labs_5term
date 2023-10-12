public class Main {
    public static void main(String[] args) {

        Person student = new Person("MainHero", "Polytechnic",
                "Russia , Saint-Petersburg , Nevsky Prospect , 28");

        //student.PrintInfo();

        System.out.println("The length of the name is " + student.Length(student.name_) + " symbols");
        System.out.println("The first letter of the name is " + student.FirstLetter(student.name_));
        System.out.println("The city of residence is " + student.Item(9, 25));
        System.out.println("The country is " + student.Item(0, 6));
        System.out.println("When you ask if " + student.name_ + " is from Russia, he proudly says it is " + student.Country());

        String[] to_change = new String[] {"Russia", "Saint-Petersburg", "Nevsky Prospect", "28"};
        String[] dream = new String[] {"New Zealand", "Wellington", "Churner street", "75"};
        String dream_address = student.ChangeAddress(to_change, dream);
        System.out.println(student.name_ + " is living in " + student.Item(0, 24) +
                ", but the adress of his dream is " + dream_address);


        String university = student.Plus();
        System.out.println(student.name_ + " has a following label on his team jacket: "
                + student.ToUp(university));

        System.out.println("But if he is asked to write the name of his university," +
                " he always writes like this: " + student.ToLow(university));

        String uni = "Mining University";
        System.out.println("If someone thinks that " + student.name_ + " studies at " + uni
                + ", he says it is " + student.Compare(uni));
        System.out.println(student.name_ + " shouts \"" + student.Cheer()
                + "\" to support his favourite football club");

        String tail = "\"Hero\"";
        System.out.println(student.name_ + " hates to be asked, but when someone doubts if his " +
                "name ends with " + tail + " he says it is " + student.NameMeaning(tail));



    }
}