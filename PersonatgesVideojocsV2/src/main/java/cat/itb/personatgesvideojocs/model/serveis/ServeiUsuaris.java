package cat.itb.personatgesvideojocs.model.serveis;

import cat.itb.personatgesvideojocs.model.entitats.Usuari;
import cat.itb.personatgesvideojocs.model.repositoris.RepositoriUsuari;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServeiUsuaris {
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

}
