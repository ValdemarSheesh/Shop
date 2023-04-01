package com.example.Shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @NotBlank
    private String address;
}
