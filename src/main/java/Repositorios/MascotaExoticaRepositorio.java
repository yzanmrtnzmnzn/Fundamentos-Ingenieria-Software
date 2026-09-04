package Repositorios;

import DiagramaDeClases.MascotaExotica;

import java.util.List;
import java.util.Optional;

public interface MascotaExoticaRepositorio extends RepositorioGenerico<MascotaExotica> {

    Optional<MascotaExotica> findById(Long id);

    void deleteById(Integer id);

    List<MascotaExotica> findByName(String name);
}
