public class Calling {
    public static void printPerson(){
        Person person = new Person("ari", 18, Position.MID, "none");

        System.out.println(person.getName()); // ok
        System.out.println(person.getAge());  // ok
        System.out.println(person.getPosition()); // ok
        //person.getCounter();  // Not visible (private)
        //person.setName("adf");  // Error val
        person.setPosition(Position.TOP); // ok
        System.out.println(person.getPosition());
    }
}
