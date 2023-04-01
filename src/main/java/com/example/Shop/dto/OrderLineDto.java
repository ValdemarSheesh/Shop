package com.example.Shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
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

    private double count;
}
