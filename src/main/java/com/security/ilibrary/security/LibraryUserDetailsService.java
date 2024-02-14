package com.security.ilibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.ilibrary.user.UserRepository;
import com.security.ilibrary.user.UserService;
@Component
public class LibraryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(LibraryUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
