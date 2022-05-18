package cat.itb.personatgesvideojocs.model.serveis;

import cat.itb.personatgesvideojocs.model.entitats.Usuari;
import cat.itb.personatgesvideojocs.model.repositoris.RepositoriUsuari;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ServeiUsuari {
    @Autowired
    private final RepositoriUsuari repositoriUsuari;
    private final PasswordEncoder xifrat;

    public Usuari consultarPerUsername(String username) {
        return repositoriUsuari.findByUsername(username).orElse(null);
    }

    public Usuari crearNouUsuari(Usuari nouUsuari) {
        nouUsuari.setPassword(xifrat.encode(nouUsuari.getPassword()));
        repositoriUsuari.save(nouUsuari);
        return nouUsuari;
    }

    public List<Usuari> llistarUsuaris(){
        return repositoriUsuari.findAll();
    }




    public void add(Usuari u){
        u.setPassword(passwordEncoder(u.getPassword()));
        repositoriUsuari.save(u);
    }



    @PostConstruct
    public void init() {
        repositoriUsuari.save(new Usuari(100L, "ramses", "pass", passwordEncoder("ramses"), "UwU", "ADMIN"));


    }


    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }


}
