package br.com.bonnasys.trasactions.app.api.controller;

import br.com.bonnasys.trasactions.app.api.AuthorizationsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationsController implements AuthorizationsApi {

    @Override
    public ResponseEntity<?> getAuthorizationByTransaction(String transactionId) {
        return null;
    }

    @Override
    public ResponseEntity<?> authorizeTransaction(String transactionId) {
        return null;
    }
}
