package repository;

import com.herox.literalura.model.Autor;
import com.herox.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l.titulo FROM Libro l")
    List<String> comprobacionDeExitenciaLibro();

    @Query("SELECT l FROM Libro l WHERE l.titulo ILIKE %:tituloLibro%")
    List<Libro> obtenerDatosLibro(String tituloLibro);

    @Query("SELECT l FROM Libro l")
    List<Libro> obtenerTituloLibro();

    @Query("SELECT l FROM Libro l WHERE l.autor IN %:autor%")
    List<Libro> obtenerTituloLibro(List<Autor> autor);

    @Query("SELECT l FROM Libro l WHERE l.idiomas IN %:idiomas%")
    List<Libro> obtenerLibroIdioma(List<String> idiomas);

    @Query("SELECT l.titulo FROM Libro l WHERE autor IN %:autor%")
    List<String> obtener(List<Autor> autor);
}
