package edu.jdc.swll.berld.Berld.config;

import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login", "/user/token/refresh/**", "/customer/register").permitAll();
        http.authorizeRequests().antMatchers(POST, "/user/add").permitAll();
        http.authorizeRequests().antMatchers(POST, "/course/add").permitAll();
        http.authorizeRequests().antMatchers(POST, "/routine/add").permitAll();
        http.authorizeRequests().antMatchers(POST, "/instructor/add").permitAll();
        http.authorizeRequests().antMatchers(POST, "/account/create", "/creditCard/addPaymentMethod")
                .hasAnyAuthority(RoleType.ADMIN.name(), RoleType.CLIENT.name());
        http.authorizeRequests().anyRequest().authenticated();
        //http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        //http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

}
