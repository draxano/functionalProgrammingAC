package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        Object value1 = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        Object value2 = Optional.ofNullable("Hello")
                        .orElseThrow(() -> new IllegalStateException("exception"));

        // if we extract this to a variable we can see that this is a supplier
        // it would be such:   Supplier<IllegalStateException> = () -> new IllegalStateException("exception");

        // let's check one more optional

        Optional.ofNullable("muradalaskarov@yahoo.com")
                        .ifPresent(
                                email -> System.out.println("sending mail to " + email)
                        );

        Optional.ofNullable(null)
                        .ifPresentOrElse(email -> System.out.println("sending mail to " + email) ,
                                () -> System.out.println("Cannot send email"));

        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);
    }
}
