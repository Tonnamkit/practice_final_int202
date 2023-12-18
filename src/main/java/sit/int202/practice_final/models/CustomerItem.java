package sit.int202.practice_final.models;

import lombok.Data;
import sit.int202.practice_final.entities.Customer;

@Data
public class CustomerItem implements CartItem {
    private Customer customer;
    private int quantity;

    public CustomerItem(Customer customer){
        this(customer,1);
    }

    public CustomerItem(Customer customer,int quantity) {
        this.customer = customer;
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CustomerItem{" +
                "customerName='" + customer.toString() + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
