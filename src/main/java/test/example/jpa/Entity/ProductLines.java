package test.example.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class ProductLines {

    @Id
    @Column(length = 50)
    private String productLine;

//    @Column(columnDefinition = "varchar(4000) DEFAULT NULL")
    @Column(length = 4000)
    private String textDescription;

    @Column(columnDefinition = "mediumtext")
    private String htmlDescription; // mediumText

    @Column(columnDefinition = "mediumblob")
    private byte[] image;


}
