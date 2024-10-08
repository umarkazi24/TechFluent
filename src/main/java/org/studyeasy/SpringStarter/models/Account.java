package org.studyeasy.SpringStarter.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a user account in the system.
 * This entity is mapped to the "accounts" table in the database.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    /**
     * Unique identifier for the account.
     * Automatically generated using a sequence strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * Email address of the account holder.
     * This should be unique for each account.
     */
    @Email(message = "Invalid email")
    @NotEmpty(message = "Email missing")
    private String email;

    /**
     * Password for the account.
     * It should be securely hashed before storage.
     */
    @NotEmpty(message = "Password missing")
    private String password;

    /**
     * First name of the account holder.
     */
    @NotEmpty(message = "First Name missing")
    private String firstname;

    /**
     * Last name of the account holder.
     */
    @NotEmpty(message = "Last Name missing")
    private String lastname;

    private String gender;

    @Min(value = 18)
    @Max(value = 99)
    private int age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;

    private String photo;

    /**
     * Role assigned to the account (e.g., USER, ADMIN).
     * This can be used to determine access levels in the application.
     */
    private String role;

    /**
     * List of posts associated with this account.
     * This represents a one-to-many relationship with the Post entity.
     */
    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    /**
     * Set of authorities granted to this account.
     * This represents a many-to-many relationship with the Authority entity.
     */
    @ManyToMany
    @JoinTable(name = "account_authority", joinColumns = {
            @JoinColumn(name = "account_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "authority_id", referencedColumnName = "id") })
    private Set<Authority> authorities = new HashSet<>();
}