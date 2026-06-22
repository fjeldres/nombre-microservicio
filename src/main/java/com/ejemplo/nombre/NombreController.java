package com.ejemplo.nombre;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class NombreController {

    @GetMapping("/nombre")
    public Map<String, String> getNombre() {
        return Map.of("nombre", "Fidel Jeldres");
    }
}
