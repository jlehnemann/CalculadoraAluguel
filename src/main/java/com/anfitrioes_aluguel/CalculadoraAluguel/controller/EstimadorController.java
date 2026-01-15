package com.anfitrioes_aluguel.CalculadoraAluguel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/aluguel")
@CrossOrigin(origins = "*")
public class EstimadorController {

    @PostMapping("/calcular")
    public ResponseEntity<Map<String, Double>> calcular(@RequestBody Map<String, Double> payload) {
        double valorImovel = payload.get("valorImovel");

        // Regra de negócio: 0.5% do valor do imóvel
        double estimativa = valorImovel * 0.005;

        Map<String, Double> resposta = new HashMap<>();
        resposta.put("estimativa", estimativa);

        return ResponseEntity.ok(resposta);
    }


}
