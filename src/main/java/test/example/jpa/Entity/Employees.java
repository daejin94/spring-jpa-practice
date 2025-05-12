package test.example.jpa.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor

public class Employees {

    @Id
    Integer employeeNumber;

    @Column(length = 50, nullable = false)
    String lastName;

    @Column(length = 50, nullable = false)
    String firstName;

    @Column(length = 10, nullable = false)
    String extension;

    @Column(length = 100, nullable = false)
    String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_code", nullable = false)
    Offices officeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reports_to", nullable = false)
    Employees reportsTo;

    @Column(length = 50, nullable = false)
    String jobTitle;

}
