package com.ejemplo.nombre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class NombreController {

    private final NombreService nombreService;

    public NombreController(NombreService nombreService) {
        this.nombreService = nombreService;
    }

    @GetMapping("/nombre")
    public ResponseEntity<Map<String, String>> getNombre(
            @RequestParam(defaultValue = "001") String codigo) {
        try {
            String nombre = nombreService.getNombrePorCodigo(codigo);
            String resultado = nombre != null ? nombre : "No encontrado";
            return ResponseEntity.ok(Map.of("nombre", resultado));
        } catch (Exception e) {
            return ResponseEntity.status(503)
                .body(Map.of("error", "Base de datos no disponible"));
        }
    }
}
