package com.insightfindr.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "favourited_stocks")
public class Stock {

    public Stock() {
    }

    public Stock(long id, String ticker, String name, String message, int invested, String date_invested) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.message = message;
        this.invested = invested;
        this.date_invested = date_invested;
    }

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
    private int invested;

    @Column(name = "date_invested")
    private String date_invested;
}
