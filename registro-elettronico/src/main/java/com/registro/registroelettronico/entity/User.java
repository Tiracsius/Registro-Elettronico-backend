package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an authenticated user of the system. Each user has
 * credentials and a set of roles that determine what parts of the
 * application they can access. Passwords should be stored as
 * cryptographically secure hashes (not plain text).
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    /**
     * Collection of roles associated with this user. A join table
     * called user_roles is used to persist the role set. Enum values
     * are stored as strings for readability.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @Builder.Default
    private Set<UserRole> roles = new HashSet<>();

    // -------------------------------------------------------------------------
    // UserDetails interface implementation
    // -------------------------------------------------------------------------

    /**
     * Returns authorities granted to the user. Roles are mapped to
     * {@link org.springframework.security.core.authority.SimpleGrantedAuthority}
     * with the prefix "ROLE_" to satisfy Spring Security conventions.
     */
    @Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(java.util.stream.Collectors.toSet());
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