package com.insightfindr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "favourited_stocks")
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "amount_invested")
    private double invested;

    @Column(name = "date_invested")
    private String date_invested;
}
