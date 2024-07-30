package com.dio.java.ControleDeGastos.controller;


import com.dio.java.ControleDeGastos.model.Gastos;
import com.dio.java.ControleDeGastos.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gastos")
public class GastosController {

    @Autowired
    private GastosService gastosService;

    @GetMapping
    public List<Gastos> getAllGastos() {
        return gastosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gastos> getGastosById(@PathVariable Long id) {
        Optional<Gastos> gastos = gastosService.findById(id);
        return gastos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gastos createGastos(@RequestBody Gastos gastos) {
        return gastosService.save(gastos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gastos> updateGastos(@PathVariable Long id, @RequestBody Gastos gastosDetails) {
        Optional<Gastos> optionalGastos = gastosService.findById(id);
        if (optionalGastos.isPresent()) {
            Gastos gastos = optionalGastos.get();
            gastos.setDescricao(gastosDetails.getDescricao());
            gastos.setValor(gastosDetails.getValor());
            gastos.setData(gastosDetails.getData());
            final Gastos updatedGastos = gastosService.save(gastos);
            return ResponseEntity.ok(updatedGastos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGastos(@PathVariable Long id) {
        Optional<Gastos> optionalGastos = gastosService.findById(id);
        if (optionalGastos.isPresent()) {
            gastosService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
