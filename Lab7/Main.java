public class Main {
    public static void main(String[] args) {
        Integer firstInteger = 100;
        Integer secondInteger = 5;

        String firstString = "Hello";
        String secondString = "World";

        Person firstPerson = new Person(17, "Harry");
        Person secondPerson = new Person(5, "Second");

        Wrapper<Integer> firstIntegerWrap = new Wrapper<>(firstInteger);
        Wrapper<Integer> secondIntegerWrap = new Wrapper<>(secondInteger);

        Wrapper<String> firstStringWrap = new Wrapper<>(firstString);
        Wrapper<String> secondStringWrap = new Wrapper<>(secondString);

        Wrapper<Person> firstPersonWrap = new Wrapper<>(firstPerson);
        Wrapper<Person> secondPersonWrap = new Wrapper<>(secondPerson);


        System.out.println("До обмена:\n" +
                "\tfirstInteger = " + firstInteger + "\n" +
                "\tsecondInteger = " + secondInteger);

        firstIntegerWrap.swap(secondIntegerWrap);

        firstInteger = firstIntegerWrap.GetData();
        secondInteger = secondIntegerWrap.GetData();

        System.out.println("После обмена:\n" +
                "\tfirstInteger = " + firstInteger + "\n" +
                "\tsecondInteger = " + secondInteger);



        System.out.println("\nДо обмена:\n" +
                "\tfirstString = " + firstString + "\n" +
                "\tsecondString = " + secondString);

        Wrapper.SwapObjects(firstStringWrap, secondStringWrap);

        firstString = firstStringWrap.GetData();
        secondString = secondStringWrap.GetData();

        System.out.println("После обмена:\n" +
                "\tfirstString = " + firstString + "\n" +
                "\tsecondString = " + secondString);




        System.out.println("\nДо обмена:\n" +
                "\tFirst person: " + firstPerson + "\n" +
                "\tSecond person: " + secondPerson);

        Wrapper.SwapObjects(firstPersonWrap, secondPersonWrap);

        firstPerson = firstPersonWrap.GetData();
        secondPerson = secondPersonWrap.GetData();

        System.out.println("После обмена:\n" +
                "\tFirst person: " + firstPerson + "\n" +
                "\tSecond person: " + secondPerson);

    }

    private static class Person {
        int m_age;
        String m_name;

        Person (int age, String name) {
            this.m_age = age;
            this.m_name = name;
        }

        @Override
        public String toString() {
            return "{" + "age=" + m_age + ", name=\"" + m_name + '\"' + '}';
        }
    }
}