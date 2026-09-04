package Repositorios;

import DiagramaDeClases.Cuidador;

import java.util.List;
import java.util.Optional;

public interface CuidadorRepositorio extends RepositorioGenerico<Cuidador> {

    Optional<Cuidador> findById(Integer id);

    Optional<Cuidador> findByEmail(String email);

    void deleteById(Integer id);

    List<Cuidador> findByName(String name);
}
