package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionURLSUpplier.get());
        System.out.println(getDBConnectionURLList.get());

    }

    static String getDBConnectionURL () {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionURLSUpplier = ()
            -> "jdbc://localhost:5432/users";

    // Or even different dataType

    static Supplier<List<String>> getDBConnectionURLList = () ->
            List.of("jdbc://localhost:5432/users",
                    "jdbc://localhost:5432/customer");

}

