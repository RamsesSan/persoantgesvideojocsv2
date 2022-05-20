package cat.itb.personatgesvideojocs.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class PasswordEncoderConf {

    @Bean
    public PasswordEncoder xifrat() {
        return new BCryptPasswordEncoder();
    }

}
