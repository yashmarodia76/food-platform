package com.foodplatform.restaurant_service.controller;

import com.foodplatform.restaurant_service.dto.RestaurantRequest;
import com.foodplatform.restaurant_service.entity.Restaurant;
import com.foodplatform.restaurant_service.repository.RestaurantRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    @PostMapping
    public ResponseEntity<Restaurant> create(@Valid @RequestBody RestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setCuisine(request.getCuisine());
        restaurant.setCity(request.getCity());
        restaurant.setStatus("ACTIVE");

        Restaurant saved = restaurantRepository.save(restaurant);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

