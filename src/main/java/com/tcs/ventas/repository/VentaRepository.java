package com.tcs.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}