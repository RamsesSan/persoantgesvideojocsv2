package cat.itb.personatgesvideojocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class PersonatgesVideojocsV2Application {

    @GetMapping
    public String welcome(){
        return "Welcome to personatgesVideojocsAPI";
    }
    @GetMapping("/user")
    public Principal user(Principal principal){
        System.out.println("user"+principal.getName());
        return principal;
    }
    public static void main(String[] args) {
        SpringApplication.run(PersonatgesVideojocsV2Application.class, args);
    }

}
