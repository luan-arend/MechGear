package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.domain.users.Users;
import br.com.dev.MechGear.dto.users.UserDetailDto;
import br.com.dev.MechGear.domain.users.UsersRepository;
import br.com.dev.MechGear.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/me")
    public ResponseEntity<UserDetailDto> getMe(@RequestHeader("Authorization") String token) {
        String tokenJWT = token.replace("Bearer ", "");
        var user = repository.findByUsername(tokenService.getSubject(tokenJWT));
        return ResponseEntity.ok(new UserDetailDto((Users) user));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailDto(user));
    }
}
