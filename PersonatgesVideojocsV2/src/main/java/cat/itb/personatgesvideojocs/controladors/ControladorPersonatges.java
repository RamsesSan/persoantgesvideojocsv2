package cat.itb.personatgesvideojocs.controladors;

import cat.itb.personatgesvideojocs.model.entitats.Personatge;
import cat.itb.personatgesvideojocs.model.serveis.ServeiPersonatges;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ControladorPersonatges {

    private final ServeiPersonatges serveiPersonatges;

    private final ServeiUsuari serveiUsuari;

    @CrossOrigin(origins = "http://localhost:8080")
    /*@GetMapping("/personatges")
    public List<Personatge> llistarPersonatges(@RequestParam(value = "status", required = false) String status) {
        if (status == null) {
            return serveiPersonatges.llistarPersonatges();
        } else if (status == "alive") {
            return serveiPersonatges.llistatPerPersonatgeViu(status);
        }
        else return serveiPersonatges.llistatPerPersonatgeMort();
    }*/

    @GetMapping("/personatges")
    public List<Personatge> llistarPersonatge(@RequestParam() String id)
    {
        return serveiPersonatges.llistarPersonatge(id);
    }
    @GetMapping("/personatges/{id}")
    public Personatge consultarPersonatge(@PathVariable String id)
    {
        return serveiPersonatges.consultarPersonatge(id);
    }

    @GetMapping("/personatges/status/{status}")
    public List<Personatge>llistarPersonatgesPerStatus(@PathVariable String status){return serveiPersonatges.llistarPersonatgesPerStatus(status);}
    @GetMapping("/personatges/comptar/{status}")
    public long comptarPerRol(@PathVariable String status){
        return serveiPersonatges.comptarPerStatus(status);
    }


    @PostMapping("/personatges")
    public Personatge crearPersonatge(@RequestBody Personatge it){
        return serveiPersonatges.afegirPersonatge(it);
    }

    @DeleteMapping("/personatges/{id}")
    public Personatge eliminarPersonatge(@PathVariable String id){
        return serveiPersonatges.eliminarPersonatge(id);
    }

    //per modificar un usuari existent
    @PutMapping("/personatges")
    public Personatge modificarPersonatge(@RequestBody Personatge mod){
        return serveiPersonatges.modificarPersonatge(mod);
    }

    @PostMapping("/crearusuari")
    public Usuari crearNouUsuari(@RequestBody Usuari nou){
        return serveiUsuari.crearNouUsuari(nou);
    }

}
