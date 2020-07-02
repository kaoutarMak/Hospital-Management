package com.Hospital_Management.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Hospital_Management.metier.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Autowired
    private UserService userService;
	BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("admin3@gmail.com").password(bc.encode("123456")).roles("ADMIN");
        auth.userDetailsService(this.userService).passwordEncoder(getBCryptPasswordEncoder());
       // 
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/", "/register-patient", "/register-doctor", "/doctors/**", "C:/Users/Kaoutar/pic/**",
                            "/bootstrap/**", "/jquery/**", "/tether/**", "/font-awesome/**", "/select2/**", "/css/**",
                            "/img/**", "/connect/**").permitAll()
                    
                    .antMatchers("/appointment/doctor/**", "/schedule/edit", "/doctor/edit", "/doctor/patients, /doctor/edit-picture").hasRole("DOCTOR")
                    .antMatchers("/appointment/patient/**", "/patient/edit").hasRole("PATIENT")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(myAuthenticationSuccessHandler() ) .and() .logout()
               	  .invalidateHttpSession(true) .clearAuthentication(true)
               	  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               	  .logoutSuccessUrl("/login?logout") .permitAll()
                
                .and()
                    .rememberMe()
                    .rememberMeCookieName("RememberMe")
                    .rememberMeParameter("rememberMe")
                    .key("SecretKey")
                    .tokenValiditySeconds(100000)
                .and()
                  
                    .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                    .csrf().disable();
    }
    @Bean public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
   	  return new MySimpleUrlAuthenticationSuccessHandler(); }
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
