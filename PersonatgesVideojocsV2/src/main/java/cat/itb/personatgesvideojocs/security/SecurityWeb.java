package cat.itb.personatgesvideojocs.security;


import cat.itb.personatgesvideojocs.model.serveis.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityWeb extends WebSecurityConfigurerAdapter {



    private final AuthEntryPoint myAuthEntryPoint;
    private final MyUserDetailsService myUserDetailsService;
    private final PasswordEncoder xifrat;

/*    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().oauth2Login();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(xifrat)
                .withUser("ramses")
                .password(xifrat.encode("pass"))
                .roles("ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //per poder accedir al h2-console
                //.authorizeRequests().antMatchers("/").permitAll().and()
                //.authorizeRequests().antMatchers("/h2-console/**").permitAll()
                //.and()
                .csrf().disable()
                //.headers().frameOptions().disable()
                //.and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

}
