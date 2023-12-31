package com.example.exchangeapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String currencyName;
    private String currencyUnit;
    private String buying;
    private String selling;
    private String change ;

}
