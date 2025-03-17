package com.insightfindr.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@Table(name = "users")
public class Person {

    public Person() {
    }

    public Person(String user_id, String email, String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private String user_id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_stock_id", referencedColumnName = "id")
    private List<Stock> stock;


}
