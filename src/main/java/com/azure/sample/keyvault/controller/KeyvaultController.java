package com.azure.sample.keyvault.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/secrets")
public class KeyvaultController {

    @GetMapping(value = "/fetch")
    public ResponseEntity<String> fetchSecrets() {
        String secret = "hello i'm secret";
        return new ResponseEntity<>(secret, HttpStatus.OK);
    }

}
