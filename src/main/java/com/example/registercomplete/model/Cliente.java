package com.example.registercomplete.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Data
@Table(value = "cliente")
public class Cliente implements UserDetails {

    @Id
    @Column("id")
    private final String id = UUID.randomUUID().toString();

    @NotNull
    @NotEmpty
    @Column("firstname")
    private String fisrtName;

    @NotNull
    @NotEmpty
    @Column("lastname")
    private String lastName;

    @NotBlank
    @NotNull
    @NotEmpty
    @Min(value = 6)
    @Column("password")
    private String password;

    @Email
    @NotEmpty
    @Column("email")
    private String email;

    @Column("active")
    private boolean active = false;

    @Column("locked")
    private boolean locked = false;


    @NotBlank
    @NotNull
    @Column("role")
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
