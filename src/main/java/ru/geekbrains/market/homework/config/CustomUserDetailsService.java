package ru.geekbrains.market.homework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.geekbrains.market.homework.entities.User;
import ru.geekbrains.market.homework.services.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUsername(s); // exseption: Optional<ru.geekbrains.market.homework.entities.User>
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}
