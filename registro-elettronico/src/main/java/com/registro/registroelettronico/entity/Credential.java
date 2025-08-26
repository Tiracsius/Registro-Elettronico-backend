package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * Represents a set of credentials used to authenticate against the
 * application. Each credential is associated with exactly one role
 * that defines which parts of the system the account may access.
 */
@Entity
@Table(name = "credential")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    /**
     * Username used to log in. Usernames must be unique across the system.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Password hashed using a {@link org.springframework.security.crypto.password.PasswordEncoder}.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Role assigned to the account. Only a single role is allowed to
     * simplify access control and mapping to domain entities.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    // ---------------------------------------------------------------------
    // UserDetails contract implementation
    // ---------------------------------------------------------------------

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}