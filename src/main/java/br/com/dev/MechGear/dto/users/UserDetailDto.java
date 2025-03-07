package br.com.dev.MechGear.dto.users;

import br.com.dev.MechGear.domain.users.Users;

public record UserDetailDto(Long id, String name, String username, String role) {

    public UserDetailDto(Users user) {
        this(user.getId(), user.getName(), user.getUsername(), user.getRole());
    }
}
