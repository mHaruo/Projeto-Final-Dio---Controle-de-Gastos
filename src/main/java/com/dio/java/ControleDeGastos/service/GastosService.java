package com.dio.java.ControleDeGastos.service;

import com.dio.java.ControleDeGastos.model.Gastos;
import com.dio.java.ControleDeGastos.repository.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastosService {

    @Autowired
    private GastosRepository gastosRepository;

    public List<Gastos> findAll() {
        return gastosRepository.findAll();
    }

    public Optional<Gastos> findById(Long id) {
        return gastosRepository.findById(id);
    }

    public Gastos save(Gastos gastos) {
        return gastosRepository.save(gastos);
    }

    public void deleteById(Long id) {
        gastosRepository.deleteById(id);
    }
}
