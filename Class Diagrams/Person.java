package busstation;


public abstract class Person  {

    protected String userName;
    protected String passWord;
    protected String name;
    protected int age;

    public Person(String userName, String passWord, String name, String age) {
        this.userName = userName;
        this.age = Integer.parseInt(age);
        this.passWord = passWord;
        this.name = name;
    }
   
}
