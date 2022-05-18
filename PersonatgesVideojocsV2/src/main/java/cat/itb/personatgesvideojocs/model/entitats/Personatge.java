package cat.itb.personatgesvideojocs.model.entitats;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Personatge {
    @Id
    private String idPersonatge;
    private String nom;
    private String ofici;
    private String status;


}
