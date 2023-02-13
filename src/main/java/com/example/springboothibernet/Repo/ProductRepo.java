package com.example.springboothibernet.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboothibernet.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
