package sit.int202.practice_final.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table (name = "customers")
@Data
@NamedQueries({
        @NamedQuery(name = "CUSTOMER.FIND_USER",
                query = "SELECT c FROM Customer c WHERE concat(trim(c.contactFirstName),' ', " + "trim(c.contactLastName)) = :user_account")
        })
public class Customer {
    @Id
    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String salesRepEmployeeNumber;
    private String creditLimit;
    private String password;
}
