package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor

public class OrderDetails {

    @EmbeddedId
    OrderDetailsPrimaryKey orderDetailsPrimaryKey;

    @Column(nullable = false)
    Integer quantityOrdered;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal priceEach;

    @Column(nullable = false, length = 6)
    Short orderLineNumber;


}
