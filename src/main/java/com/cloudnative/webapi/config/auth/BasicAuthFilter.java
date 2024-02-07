package com.cloudnative.webapi.config.auth;

import com.cloudnative.webapi.entity.User;
import com.cloudnative.webapi.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
public class BasicAuthFilter /*extends OncePerRequestFilter*/ {

//    private final BasicAuthService basicAuthService;
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public BasicAuthFilter(
//            BasicAuthService basicAuthService,
//            UserRepository userRepository,
//            PasswordEncoder passwordEncoder) {
//        this.basicAuthService = basicAuthService;
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request,
//                                    @NonNull HttpServletResponse response,
//                                    @NonNull FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//
//        if (authHeader == null || !authHeader.startsWith("Basic ")) {
//            throw new BadCredentialsException("Basic authentication token is required");
//        }
//
//        String[] credentials = basicAuthService.extractAndDecodeHeader(authHeader);
//        String username = credentials[0];
//        String password = credentials[1];
//
//        User userDetails = userRepository.findByUsername(username);
//        if (userDetails == null || passwordEncoder.matches(password, userDetails.getPassword())) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(
//                        userDetails, null, AuthorityUtils.NO_AUTHORITIES
//                );
//        authenticationToken.setDetails(
//                new WebAuthenticationDetailsSource().buildDetails(request)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//        filterChain.doFilter(request, response);
//    }
}
