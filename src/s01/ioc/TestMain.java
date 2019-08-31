package s01.ioc;

public class TestMain {
    public static void main(String[] args) {
        MySpring mySpring =  new MySpring();
//        Question question = (Question)mySpring.getBean("s01.ioc.Question");
//        System.out.println(question);
        Person person = (Person)mySpring.getBean("s01.ioc.Person");
        System.out.println(person);

    }
}
