package cat.itb.personatgesvideojocs.model.repositoris;

import cat.itb.personatgesvideojocs.model.entitats.Personatge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriPersonatges extends JpaRepository<Personatge, String> {

    List<Personatge> findByStatus(String s);

    long countByStatus(String status);
}
