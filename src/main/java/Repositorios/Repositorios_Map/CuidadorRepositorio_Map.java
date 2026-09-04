package Repositorios.Repositorios_Map;

import DiagramaDeClases.Cuidador;
import Repositorios.CuidadorRepositorio;

import java.util.*;
import java.util.stream.Collectors;

public class CuidadorRepositorio_Map implements CuidadorRepositorio {

    private final Map<Integer, Cuidador> cuidadores;
    private Integer id;

    public CuidadorRepositorio_Map() {
        this.cuidadores = new HashMap<>();
        this.id = 1;
    }

    @Override
    public Optional<Cuidador> findById(Integer id) {
        for (Cuidador cuidador : this.findAll()) {
            if (cuidador.getId().equals(id))
                return Optional.of(cuidador);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cuidador> findByEmail(String email) {
        for (Cuidador cuidador : this.findAll()) {
            if (cuidador.getEmail().equals(email))
                return Optional.of(cuidador);
        }
        return Optional.empty();
    }

    @Override
    public Cuidador create(Cuidador entity) {
        this.setId(entity, this.id);
        this.cuidadores.put(this.id, entity);
        this.id++;
        return entity;
    }

    private void setId(Cuidador entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public Cuidador update(Cuidador entity) {
        if (this.getId(entity) == null) {
            throw new IllegalArgumentException("No se puede actualizar el Cuidador cuando su id es null: " + entity);
        }
        this.cuidadores.put(this.getId(entity), entity);
        return entity;
    }

    private Integer getId(Cuidador entity) {
        return entity.getId();
    }

    @Override
    public Optional<Cuidador> read(Integer id) {
        return Optional.ofNullable(this.cuidadores.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        this.cuidadores.remove(id);
    }

    @Override
    public List<Cuidador> findAll() {
        return new ArrayList<>(cuidadores.values());
    }


    @Override
    public List<Cuidador> findByName(String name) {
        return cuidadores.values().stream()
                .filter(cuidador -> cuidador.getNombre().equals(name))
                .collect(Collectors.toList());
    }
}
