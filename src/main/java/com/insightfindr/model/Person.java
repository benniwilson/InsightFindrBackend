package com.insightfindr.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Person {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private String user_id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_stock_id", referencedColumnName = "user_id")
    private List<Stock> stock;

    public String getUser_id() {
        return user_id;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }
}
