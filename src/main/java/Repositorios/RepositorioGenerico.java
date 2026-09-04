package Repositorios;

import java.util.List;
import java.util.Optional;


public interface RepositorioGenerico<T> {
    T create(T entity);

    T update(T entity);

    Optional<T> read(Integer id);

    void deleteById(Integer id);

    List<T> findAll();

}
