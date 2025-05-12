package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor

public class Orders {

    @Id
    Integer orderNumber;

    @Column(nullable = false)
    LocalDate orderDate;

    @Column(nullable = false)
    LocalDate requiredDate;

    LocalDate shippedDate;

    @Column(length = 15, nullable = false)
    String status;

    @Lob
    @Column(nullable = false, length = 256)
    String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_number")
    Customers customers;


}
