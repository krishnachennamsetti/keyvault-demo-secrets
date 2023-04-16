package com.azure.sample.keyvault.controller;

import com.azure.identity.ManagedIdentityCredentialBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/v1/secrets")
public class KeyvaultController {
    private final String keyVaultUri ="https://mysamplekeyvault.vault.azure.net/";

    @GetMapping(value = "/fetch")
    public ResponseEntity<String> fetchSecrets() {
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(new ManagedIdentityCredentialBuilder().build())
                .buildClient();
        String secret = Objects.nonNull(secretClient) ? secretClient.getSecret("mysecret").getValue() : "No secret found";
        return new ResponseEntity<>("my secret is :: " + secret, HttpStatus.OK);
    }

}
