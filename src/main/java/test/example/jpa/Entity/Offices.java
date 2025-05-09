package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity

@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offices {

    @Id
    @Column(length = 10)
    String officeCode;

    @Column(length = 50, nullable = false)
    String city;

    @Column(length = 50, nullable = false)
    String phone;

    @Column(length = 50, nullable = false)
    String addressLine1;

    @Column(length = 50)
    String addressLine2;

    @Column(length = 50)
    String state;

    @Column(length = 50, nullable = false)
    String country;

    @Column(length = 15, nullable = false)
    String postalCode;

    @Column(length = 10, nullable = false)
    String territory;


}
