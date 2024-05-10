package br.com.bonnasys.trasactions.app.api.controller;

import br.com.bonnasys.trasactions.app.api.TransactionsApi;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController implements TransactionsApi {
    @Override
    public ResponseEntity<?> searchTransactions(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<?> createTransaction() {
        return null;
    }
}
