package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    // give some take some
    public static void main(String[] args) {

        //Function, takes 1 argument and produces 1 result.

        int increment = increment(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);


        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        //BiFunction takes 2 argument and produces 1 result.

        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );

    }

    //-----------------------------------------------------------------------------------------------


    // This is basically the same thing as we have below but this is functional or declarative approach.
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    // this is what we're used to. But how do we do this using Function which is a Functional Interface.
    static int increment(int number) {
        return number + 1;
    }

    //-----------------------------------------------------------------------------------------------
    // We're using this Function in order to demostrate .andThen() method.
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    //-----------------------------------------------------------------------------------------------
    // These are for demonstrating BiFunctions

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

}


