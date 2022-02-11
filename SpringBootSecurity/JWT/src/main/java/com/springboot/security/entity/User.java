package com.springboot.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="users_id_seq")
    private Long id;

    @Column(name = "username", length = 50, unique = true)
    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @Column(name = "password", length = 100)
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "firstname", length = 50)
    @Size(min = 2, max = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    @Size(min = 2, max = 50)
    private String lastname;

    @Column(name = "email", length = 50)
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "status")
    private boolean status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public Set<Roles> getRoles() {
        return roles;
    }
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public User (String username,String email,String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
