package com.example.Shop.dto;

import com.example.Shop.validation.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Long id;

    @NotBlank
    private String client;

    @NotBlank
    @ValidDate
    private String date;

    @NotBlank
    private String address;

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }
}
