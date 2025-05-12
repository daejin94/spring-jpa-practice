package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Customers {

    @Id
    Integer customerNumber;

    @Column(length = 50, nullable = false)
    String customerName;

    @Column(length = 50, nullable = false)
    String contactLastName;

    @Column(length = 50, nullable = false)
    String contactFirstName;

    @Column(length = 50, nullable = false)
    String phone;

    @Column(length = 50, nullable = false)
    String addressLine1;

    @Column(length = 50)
    String addressLine2;

    @Column(length = 50, nullable = false)
    String city;

    @Column(length = 50)
    String state;

    @Column(length = 15)
    String postalCode;

    @Column(length = 50, nullable = false)
    String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_rep_employee_number")
    Employees employees;

    @Column(precision = 10, scale = 2)
    BigDecimal creditLimit;

}
