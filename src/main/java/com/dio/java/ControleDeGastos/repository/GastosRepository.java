package com.dio.java.ControleDeGastos.repository;

import com.dio.java.ControleDeGastos.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosRepository extends JpaRepository<Gastos, Long> {
}
