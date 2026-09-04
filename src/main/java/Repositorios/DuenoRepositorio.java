package Repositorios;

import DiagramaDeClases.Dueno;

import java.util.List;
import java.util.Optional;

public interface DuenoRepositorio extends RepositorioGenerico<Dueno> {
    Optional<Dueno> findById(Integer id);

    Optional<Dueno> findByEmail(String email);

    void deleteById(Integer id);

    List<Dueno> findByName(String name);
}
