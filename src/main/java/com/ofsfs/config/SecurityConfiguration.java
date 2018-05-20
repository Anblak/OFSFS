package com.ofsfs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;
//    private final UserDetailsService userDetails;
//
//    @Autowired
//    public SecurityConfiguration(EntryPointUnauthorizedHandler entryPointUnauthorizedHandler, UserDetailsService userDetails) {
//        this.entryPointUnauthorizedHandler = entryPointUnauthorizedHandler;
//        this.userDetails = userDetails;
//    }

//    @Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(this.userDetails);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.exceptionHandling()
//                .authenticationEntryPoint(this.entryPointUnauthorizedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .antMatchers("/api/private/**")
                .hasRole("USER")
                .anyRequest()
                .permitAll();
//        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationTokenFilter authenticationTokenFilter() throws Exception {
//        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
//        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
//        return authenticationTokenFilter;
//    }


}
