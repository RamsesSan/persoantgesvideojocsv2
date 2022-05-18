package cat.itb.personatgesvideojocs.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultaUsuari {
    private String username;
    private String avatar;
    private String rol;
}
