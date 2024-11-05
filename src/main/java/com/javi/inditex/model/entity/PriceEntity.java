package com.javi.inditex.model.entity;

import com.javi.inditex.model.PriceBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "PRICE")
public class PriceEntity extends PriceBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private int priority;
    @NotNull
    private String currency;

}