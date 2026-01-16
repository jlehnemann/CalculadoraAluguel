package com.anfitrioes_aluguel.CalculadoraAluguel.controller;

import com.anfitrioes_aluguel.CalculadoraAluguel.controller.dto.ImovelRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/aluguel")
@CrossOrigin(origins = "*")
public class EstimadorController {

    @PostMapping("/calcular")
    public ResponseEntity<Map<String, Double>> calcular(@RequestBody ImovelRequest dados) {

        // Agora você acessa os dados de forma elegante com métodos
        double valorBase = dados.getValorImovel() * 0.005;

        double estimativaFinal = (dados.getMobiliado() != null && dados.getMobiliado())
                ? valorBase * 1.30
                : valorBase;

        Map<String, Double> resposta = new HashMap<>();
        resposta.put("estimativa", estimativaFinal);

        return ResponseEntity.ok(resposta);
    }


}
