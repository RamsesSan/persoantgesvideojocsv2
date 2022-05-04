package cat.itb.personatgesvideojocs.model.serveis;

import cat.itb.personatgesvideojocs.model.entitats.Personatge;
import cat.itb.personatgesvideojocs.model.repositoris.RepositoriPersonatges;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiPersonatges {
    private final RepositoriPersonatges repositoriPersonatges;

    /*public List<Personatge> llistarPersonatges() {
        return repositoriPersonatges.findAll();
    }*/

    public List<Personatge> llistarPersonatge(String id) {
        return repositoriPersonatges.findAll();
    }
    public Personatge consultarPersonatge(String id) {
        return repositoriPersonatges.findById(id).orElse(null);
    }

    public List<Personatge> llistarPersonatgesPerStatus(String status) {
        return repositoriPersonatges.findByStatus(status);
    }

    public List<Personatge> llistatPerPersonatgeMort(String status) {
        return repositoriPersonatges.findByStatus(status);
    }


    public long comptarPerStatus(String status) {return repositoriPersonatges.countByStatus(status);}

    public Personatge afegirPersonatge(Personatge it) {
        return repositoriPersonatges.save(it);
    }

    public Personatge eliminarPersonatge(String id) {
        Personatge res=repositoriPersonatges.findById(id).orElse(null);
        if(res!=null) repositoriPersonatges.deleteById(id);
        return res;
    }

    public Personatge modificarPersonatge(Personatge mod) {
        Personatge aux=null;
        if(repositoriPersonatges.existsById(mod.getIdPersonatge())) aux=repositoriPersonatges.save(mod);
        return aux;
    }
}
