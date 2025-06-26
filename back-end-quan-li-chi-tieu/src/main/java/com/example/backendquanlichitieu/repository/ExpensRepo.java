package com.example.backendquanlichitieu.repository;

import com.example.backendquanlichitieu.entity.Expens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendquanlichitieu.entity.Expens;

@Repository
public interface ExpensRepo extends JpaRepository<Expens, Long> {

}
