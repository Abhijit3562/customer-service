package com.retailbank.customerservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(
        name = "Customers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"})
        }
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

}

