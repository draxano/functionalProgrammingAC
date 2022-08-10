package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


// consumer just prints value of something
public class _Consumer {

    public static void main(String[] args) {

        // Normal Java function.

        Customer maria = new Customer("Maria", "9999999");

        greetCustomer(maria);

        greetCustomerV2(maria, true);

        // This is what Consumer Functional Interface look like.

        greetCustomerConsumer.accept(maria);

        greetCustomerConsumerV2.accept(maria, false);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "xxxxxxx"));
    }


    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "xxxxxxx"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number "
            + customer.customerPhoneNumber);

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}




