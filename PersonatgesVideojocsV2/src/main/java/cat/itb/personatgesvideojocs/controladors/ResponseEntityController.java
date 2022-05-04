package cat.itb.personatgesvideojocs.controladors;

import cat.itb.personatgesvideojocs.model.entitats.Personatge;
import cat.itb.personatgesvideojocs.model.serveis.ServeiPersonatges;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ResponseEntityController {

    private final ServeiPersonatges serveiPersonatges;


    @GetMapping("/character/{id}")
    public ResponseEntity<?> consultarPersonatge(@PathVariable String id) {
        Personatge res = serveiPersonatges.consultarPersonatge(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("/character")
    public ResponseEntity<?> crearPersonatge(@RequestBody Personatge nou){
        Personatge res=serveiPersonatges.afegirPersonatge(nou);
        return new ResponseEntity<Personatge>(res, HttpStatus.CREATED);
    }
    @PutMapping("/character")
    public ResponseEntity<?>modificarPersonatge(Personatge mod){
        Personatge res = serveiPersonatges.modificarPersonatge(mod);
        if(res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }
    @DeleteMapping("/character/{id}")
    public ResponseEntity<?>eliminarPersonatge(@PathVariable String id) {
        Personatge res = serveiPersonatges.eliminarPersonatge(id);
        if (res == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(res);
    }

}
