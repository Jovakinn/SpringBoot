package com.example.fraud.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "Fraud")
@Entity
public class FraudCheckHistory {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Integer id;

    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "isFraudster")
    private Boolean isFraudster;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;
}
