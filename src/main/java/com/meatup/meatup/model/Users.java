package com.meatup.meatup.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name="userId", columnNames = "uid"),
        @UniqueConstraint(name = "userEmail", columnNames = "email")
})
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String uid;
    @Column(nullable = false, columnDefinition = "TEXT")
//    @Email
    private String email;
    @Column(columnDefinition = "TEXT")
    private String displayName;
    @Column(columnDefinition = "TEXT")
    private String photoUrl;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
    @JoinTable(name="friendships", joinColumns = @JoinColumn(name = "user_A_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_B_id", referencedColumnName = "id"))
    private Set<Users> addedFriends = new HashSet<>();
//    @ManyToMany(mappedBy ="addedFriends")
//    private Set<Users> receivedFriends;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users other)) {
            return false;
        }
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}