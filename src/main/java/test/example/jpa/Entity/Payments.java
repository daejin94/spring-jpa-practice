package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor

public class Payments {

    @EmbeddedId
    PaymentPrimaryKey paymentPrimaryKey;

    LocalDate paymentDate;

    @Column(precision = 10, scale = 2)
    BigDecimal amount;

}
