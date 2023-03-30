package com.smartreservation.UserService.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartreservation.UserService.Enum.RoleEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Embeddable
@ToString(exclude = "users")

@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "roles")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @Fetch(value= FetchMode.SELECT)
    private Set<User> users = new HashSet<>();
    public Integer getId() {
        return id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    public Role(Integer id, RoleEnum name) {
        this.id = id;
        this.name = name;
    }
}