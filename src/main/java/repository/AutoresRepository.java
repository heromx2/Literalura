package repository;

import com.herox.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a.nombre FROM Autor a ")
    List<String> comprobacionDeExistenciaAutor();
    @Query("SELECT a.id FROM Autor a WHERE a.nombre = :autorLibro")
    List<Long> obtenerIdAutor(String autorLibro);

    @Query("SELECT a.id FROM Autor a WHERE a.nombre = :autorLibro")
    List<Long> obtenerIdAutor(List<String> autorLibro);

    @Query("SELECT a FROM Autor a")
    List<Autor> registroAutores();

    @Query("SELECT a FROM Autor a WHERE a.fechaFallecimiento > :fechaSeleccionada AND a.fechaNacimiento < :fechaSeleccionada")
    List<Autor> nombreAutoresVivos(Integer fechaSeleccionada);
}
