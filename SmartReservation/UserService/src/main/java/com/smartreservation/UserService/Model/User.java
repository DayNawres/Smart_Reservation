package com.smartreservation.UserService.Model;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@ToString(exclude = "roles")

    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "user")
    public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        private String firstname;
        private String lastname;
        @Column(unique=true)
        private String email;
        @Column(unique=true)
        private String username;
        private String password;
        @Lob
        @Column(columnDefinition = "MEDIUMBLOB")
        private String image;
        @CreationTimestamp
        private LocalDateTime createdAt;
        @UpdateTimestamp
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
        private boolean enabled;
        @ManyToMany( fetch = FetchType.LAZY,cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
    @EqualsAndHashCode.Exclude
        @Fetch(value= FetchMode.SELECT)
        private  Set<Role> roles = new HashSet<>();

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        //private RoleEnum roles;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }


        public Long getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

