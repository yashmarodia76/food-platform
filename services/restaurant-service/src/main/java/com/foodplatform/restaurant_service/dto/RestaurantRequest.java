package com.foodplatform.restaurant_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequest {
    @NotBlank(message = "Name is required")
    private String name;

    private String cuisine;
    private String city;
}

