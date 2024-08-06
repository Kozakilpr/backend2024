package com.kozak_burger.KozakBurgerShop.service;

import com.kozak_burger.KozakBurgerShop.domain.entity.User;
import com.kozak_burger.KozakBurgerShop.repository.UserRepository;
import com.kozak_burger.KozakBurgerShop.service.interfaces.RoleService;
import com.kozak_burger.KozakBurgerShop.service.interfaces.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.RoleNotFoundException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder, RoleService roleService) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }
        return user;
    }

	/* return repository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User %s not found", username))
        );*/

    @Override
    public void register(User user) throws RoleNotFoundException {
        String username = user.getUsername();
        User existedUser = repository.findByUsername(username).orElse(null);

        if (existedUser != null && existedUser.isActive()) {
            throw new RuntimeException("User already exists");
        }

        if (existedUser == null) {
            existedUser = new User();
            existedUser.setUsername(username);
            existedUser.setRoles(Set.of(roleService.getRoleUser()));
        }

        existedUser.setPassword(encoder.encode(user.getPassword()));
        existedUser.setEmail(user.getEmail());

        repository.save(existedUser);
    }
}


/*   @Override
    public void register(User user) {
        user.setId(null);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(false);
        user.setRoles(Set.of(roleService.getRoleUser()));

        repository.save(user);
        emailService.sendConfirmationEmail(user);
    }
*/