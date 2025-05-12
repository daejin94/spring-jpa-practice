package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor

public class Products {

    @Id
    @Column(length = 15)
    String productCode;

    @Column(length = 70, nullable = false)
    String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_line", nullable = false)
    ProductLines productLine;

    @Column(length = 10, nullable = false)
    String productScale;

    @Column(length = 50, nullable = false)
    String productVendor;

    @Lob
    @Column(nullable = false, length = 256)
    String productDescription;

    @Column(nullable = false, length = 6)
    Short quantityInStock;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal buyPrice;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal MSRP;


}
