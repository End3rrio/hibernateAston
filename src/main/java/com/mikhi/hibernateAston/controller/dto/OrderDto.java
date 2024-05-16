package com.mikhi.hibernateAston.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long order_id;
    private Long customer_id;
    private Date order_date;
    private String order_status;
}
