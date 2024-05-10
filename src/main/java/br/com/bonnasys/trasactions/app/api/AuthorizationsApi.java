package br.com.bonnasys.trasactions.app.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Authorizations")
@RequestMapping("transactions/{transactionId}/authorizations")
public interface AuthorizationsApi {

    @GetMapping
    ResponseEntity<?> getAuthorizationByTransaction(@PathVariable String transactionId);

    @PutMapping
    ResponseEntity<?> authorizeTransaction(@PathVariable String transactionId);

}
