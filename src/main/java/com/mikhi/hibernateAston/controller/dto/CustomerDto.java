package com.mikhi.hibernateAston.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long customer_id;
    private String firstName;
    private String lastName;
    private String email;
}
