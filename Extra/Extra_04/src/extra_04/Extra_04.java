package extra_04;

/**
 *
 * @author Samuel Bangslund
 */
public class Extra_04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*--------------Opgave 1-----------------*/
        Customer aCustomer1 = new Customer("John Wick", 1);
        aCustomer1.deposit(1_000);
        aCustomer1.withdraw(500);
        System.out.println(aCustomer1.getBalance());
        
        /*--------------Opgave 2-----------------*/
        Customer aCustomer2 = new Customer("Peter Petersen", 2);
        Customer aCustomer3 = new Customer("Jens Mortensen", 3);
        
        CustomerDatabase customerDB = new CustomerDatabase();
        
        customerDB.addCustomer(aCustomer1);
        customerDB.addCustomer(aCustomer1); // Tries to duplicate
        customerDB.addCustomer(aCustomer2);
        customerDB.addCustomer(aCustomer2); // Tries to duplicate
        customerDB.addCustomer(aCustomer3);
        
        customerDB.removeCustomer(2);
        customerDB.printAllCustomerNames();
    }
    
}
