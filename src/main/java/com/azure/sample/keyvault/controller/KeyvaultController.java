package com.azure.sample.keyvault.controller;

import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

import java.net.MalformedURLException;
import java.util.Collections;
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

    @GetMapping(value = "/token")
    public ResponseEntity<String> fetchAADToken() throws MalformedURLException {
        ConfidentialClientApplication clientApplication = ConfidentialClientApplication.
                builder("850e9b80-3b92-43e6-add5-4cc1661d1ad3",
                        ClientCredentialFactory.createFromSecret("chj8Q~hzeRtCpI5hxnQEtXX4VESR2O74_gC6ZcQo")).
                authority("https://login.microsoftonline.com/1499c20a-2ffb-494b-b51f-c9bf80364478/oauth2/token").build();
        IAuthenticationResult result = clientApplication.acquireToken(ClientCredentialParameters.builder(Collections.singleton("openid")).build()).join();
        String token = Objects.nonNull(result) ? result.accessToken() : "No token found";
        return new ResponseEntity<>("my AAD token is :: " + token, HttpStatus.OK);
    }

}
