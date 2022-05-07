package com.example.registercomplete.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Table(value = "cliente")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cliente implements UserDetails {

    @Id
    private Long id;

    @NotNull
    @NotEmpty
    @Column("firstname")
    private String fisrtName;

    @NotNull
    @NotEmpty
    @Column("lastname")
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    @Column(value = "email")
    private String email;


    @Column(value = "active")
    private boolean active;

    @Column(value = "locked")
    private boolean locked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
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
