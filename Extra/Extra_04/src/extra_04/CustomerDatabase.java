package extra_04;

/**
 *
 * @author Samuel Bangslund
 */
public class CustomerDatabase {

    Customer[] customers = new Customer[1000];

    public CustomerDatabase() {
        
    }

    /**
     * Adds a customer to the database. Checks for customer ID to make sure no
     * customer has the same ID.
     *
     * @param customer to add.
     */
    public void addCustomer(Customer customer) {
        if (hasID(customer.getID())) {
            return;
        }

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                return;
            }
        }

        System.err.println("No more room in database!");
    }

    /**
     * Removes a customer with the matching ID.
     *
     * @param id reference to the associated customer.
     */
    public void removeCustomer(int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getID() == id) {
                customers[i] = null;
                return;
            }
        }
        System.err.println("Could not find a customer with id: " + id);
    }

    /**
     * Prints all the currently stored customers.
     */
    public void printAllCustomerNames() {
        for (Customer customer : customers) {
            if (customer != null) {
                System.out.format("Customer with id[%s] is named %s\n", customer.getID(), customer.getName());
            }
        }
    }

    /**
     * Checks to see if the database already has the given ID.
     *
     * @param id to check for.
     * @return true if the ID is already in the database, false if not.
     */
    boolean hasID(int id) {
        for (Customer customer : customers) {
            if (customer != null && customer.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public Customer[] getCustomers() {
        return customers;
    }
}
