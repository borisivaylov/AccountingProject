package com.tinqin.accountingproject.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String invoiceId;
    private UUID creatorProviderId;
    private UUID receiverProviderId;
    private double sum;
    private String currency;
    private Timestamp dateOfCreation;
    private String paymentMarker;
    private Timestamp dateOfPayment;
    private String employee;
    private boolean paid;
}
