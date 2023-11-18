class Person {
    String name_;
    String university_;
    String address_;

    Person(String name, String university, String adress){
        name_ = name;
        university_ = university;
        address_ = adress;
    }

    void PrintInfo(){
        System.out.printf("Name: %s \nUniversity: %s\nAdress: %s", name_, university_, address_);
    }

    int Length(String str){
        return str.length();
    }

    char FirstLetter(String str){
        return str.charAt(0);
    }

    String Item(int start, int finish){
        return this.address_.substring(start, finish);
    }
    String ChangeAddress(String[] from, String[] to){
        String res = this.address_;
        for(int i = 0; i < from.length; i++){
            res = res.replace(from[i], to[i]);
        }
        return res;
    }

    String ToLow(String str){
        return str.toLowerCase();
    }

    String ToUp(String str){
        return str.toUpperCase();
    }

    boolean Compare(String str2){
        return this.university_.equals(str2);
    }

    String Plus(){
        return this.university_.concat(" University");
    }

    String Cheer(){
        String country = this.address_.substring(0, 7);
        return country.repeat(3);
    };

    boolean NameMeaning(String str){
        return this.name_.endsWith(str);
    }

    boolean Country(){
        return this.address_.contains("Russia");
    }


}
