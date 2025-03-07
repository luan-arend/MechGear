package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.dto.security.AuthenticationDto;
import br.com.dev.MechGear.domain.users.Users;
import br.com.dev.MechGear.dto.security.TokenJWTDto;
import br.com.dev.MechGear.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthenticationDto dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.username(), dados.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Users) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDto(tokenJWT));
    }


}
