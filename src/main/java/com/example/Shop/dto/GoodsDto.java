package com.example.Shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoodsDto {

    private Long id;

    @NotBlank
    private String name;

    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    @Max(Long.MAX_VALUE)
    private double price;
}
