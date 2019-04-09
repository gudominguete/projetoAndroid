package app.controller;

import app.util.json.Json;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @GetMapping("/usuario")
    public Json findAll() {
        String teste = "teste";
        return new Json(teste);
    }
}
