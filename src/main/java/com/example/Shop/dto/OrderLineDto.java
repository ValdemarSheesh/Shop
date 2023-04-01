package com.example.Shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineDto {

    private Long id;

    @Valid
    private OrderDto order;

    @Valid
    private List<GoodsDto> goodsList;

    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    @Max(Long.MAX_VALUE)
    private double count;
}
