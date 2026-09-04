package Repositorios;

import DiagramaDeClases.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaRepositorio extends RepositorioGenerico<Mascota> {

    Optional<Mascota> findById(Long id);

    void deleteById(Integer id);

    List<Mascota> findByName(String name);


}
