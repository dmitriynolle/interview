package homeWork1.task1;

public class Main {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .withFirstName("Ivan")
                .withLastName("Ivanov")
                .withMiddleName("Ivanych")
                .withCountry("Russia")
                .withAddress("Street House")
                .withPhone("88000000000")
                .withAge(50)
                .withGender("M")
                .build();
    }
}
