package com.example.Shop.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String client;

    private LocalDate date;

    private String address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
