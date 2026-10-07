package com.foodplatform.restaurant_service.repository;

import com.foodplatform.restaurant_service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
