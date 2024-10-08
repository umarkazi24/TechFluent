package org.studyeasy.SpringStarter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.models.Authority;
import org.studyeasy.SpringStarter.repositories.AccountRepository;
import org.studyeasy.SpringStarter.util.constants.Roles;

/**
 * Service class for managing user accounts.
 * Implements UserDetailsService to provide user authentication details to Spring Security.
 */
@Service
public class AccountService implements UserDetailsService {


   @Value("/resources/static/**")
   private String photo_prefix; 

    @Autowired
    private AccountRepository accountRepository; // Repository for performing CRUD operations on Account entities.

    @Autowired 
    private PasswordEncoder passwordEncoder; // Encoder for hashing passwords before storage.

    /**
     * Saves a new account after encoding the password and setting a default role.
     */
    public Account save(Account account) {
        // Encodes the account's password using the provided PasswordEncoder for security purposes.
        account.setPassword(passwordEncoder.encode(account.getPassword())); 
        if(account.getRole() == null){
            account.setRole(Roles.USER.getRole());          // Sets the default role of the account to 'USER' if not already defined.        
        }
        if(account.getPhoto() == null){
            String path = photo_prefix.replace("**", "images/person.png");
            account.setPhoto(path);          // Sets the default role of the account to 'USER' if not already defined.        
        }               
        
        // Persists the account entity in the database using the AccountRepository.
        return accountRepository.save(account);                            
    }

    /**
     * Loads the user details by username (email).
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Looks up the account using the email in a case-insensitive manner from the database.
        Optional<Account> optionalAccount = accountRepository.findOneByEmailIgnoreCase(username);
        
        // If the account is not found, throws a UsernameNotFoundException.
        if (!optionalAccount.isPresent()) {                                                      
            throw new UsernameNotFoundException("Account not found");
        }
        
        Account account = optionalAccount.get();
        List<GrantedAuthority> grantedAuthority = new ArrayList<>(); // List to hold granted authorities for the user.

        // Retrieves the role of the account and assigns it as a GrantedAuthority.
        grantedAuthority.add(new SimpleGrantedAuthority(account.getRole())); 
        
        for(Authority _auth: account.getAuthorities()){
            grantedAuthority.add(new SimpleGrantedAuthority(_auth.getName()));
        }

        // Returns a User object containing the account's email, encoded password, and authorities.
        return new User(account.getEmail(), account.getPassword(), grantedAuthority); 
    }

    public Optional<Account> findOneByEmail(String email){
        return accountRepository.findOneByEmailIgnoreCase(email);
    }
}