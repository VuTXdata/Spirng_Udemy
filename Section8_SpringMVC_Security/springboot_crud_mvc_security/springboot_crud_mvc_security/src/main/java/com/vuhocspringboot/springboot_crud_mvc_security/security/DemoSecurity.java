package com.vuhocspringboot.springboot_crud_mvc_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class DemoSecurity {

    //add support jdbc... no more hardcodes user
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager jd = new JdbcUserDetailsManager(dataSource);
        jd.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        jd.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jd;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(config -> config
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leader/**").hasRole("MANAGER")
                        .requestMatchers("/system/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login_form")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling(conf -> conf.accessDeniedPage("/access_denied"));
        return http.build();
    }
    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails join = User.builder()
                .username("join")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails vu = User.builder()
                .username("vu")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(join, marry, vu);
    }
*/
}
