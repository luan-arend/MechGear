package br.com.dev.MechGear.domain.user;

public record UserDetailDto(Long id, String name, String username, String role) {

    public UserDetailDto(Users user) {
        this(user.getId(), user.getName(), user.getUsername(), user.getRole());
    }
}
