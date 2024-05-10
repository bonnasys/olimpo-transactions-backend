package br.com.bonnasys.trasactions.app.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Transactions")
@RequestMapping("transactions")
public interface TransactionsApi {

    @GetMapping
    ResponseEntity<?> searchTransactions(@PageableDefault Pageable pageable);

    @PostMapping
    ResponseEntity<?> createTransaction();

}
