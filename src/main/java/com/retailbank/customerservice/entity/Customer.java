package com.retailbank.customerservice.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "Customers"
)
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private  CustomerStatus status;

    @CreatedDate
    @Column(
            updatable = false
    )
    private LocalDateTime createdAt;

}

enum CustomerStatus {

    INITIATED("Initiated"),
    DOC_UPLOADED("Document Uploaded"),
    UNDER_REVIEW("Under Review"),
    VERIFIED("Verified"),
    REJECTED("Rejected");

    public final String value;

    CustomerStatus(String value) {
        this.value = value;
    }
}
