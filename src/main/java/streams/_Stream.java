package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

// You can use this as a reference as well
// Questions: Make sure you revise this with the questions

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        // Let's map from person to genders

        System.out.println("Here is the genders: \n " );

          people.stream()   // we streamed the people list.
                .map(person -> person.gender)     // we map everything we cause a transformation on that list which converts everything to a gender. Which means now we have list full of genders
                .collect(Collectors.toSet())  // we collect them into the set, removing the duplicates
                 .forEach(System.out::println);  // then we simply print

        System.out.println();




        // Now let's do the same thing for the names:

        System.out.println("Here is the names : \n " );

        people.stream()   // we streamed the people list.
                .map(person -> person.name)     // we map everything we cause a transformation on that list which converts everything to a name. Which means now we have list full of names
                .collect(Collectors.toSet())  // we collect them into the set, removing the duplicates
                .forEach(System.out::println);  // then we simply print

        System.out.println();

        System.out.println("Here is the length of the names : \n " );

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;  // How can we say this method reference in Lambda? s -> s.length();
        IntConsumer println = System.out::println;  // How can we say this method reference in Lambda? x -> System.out.println(x)
        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        // But we don't need all this mumble jumble when we use streams so we can simply refer to these whole thing above as:

        System.out.println();

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // God this is so much neater.

        //-----------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Do we only have females in the list?");

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));

        // remember that this is the same thing as

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);



        System.out.println(containsOnlyFemales);

        // we can also do
        System.out.println("Do we any have females in the list?");
        System.out.println(people.stream().anyMatch(person -> FEMALE.equals(person.gender)));


        // we can also do
        System.out.println("Do we not have a match with PREFER_NOT_TO_SAY in the list?");
        boolean doesntMatch = people.stream()
                .noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));

        System.out.println(doesntMatch);




    }

    //-----------------------------------------------------------------------------------------------

    static class Person{

        private final String name;
        private final Gender gender;


        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }


//-----------------------------------------------------------------------------------------------

    enum Gender{
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
