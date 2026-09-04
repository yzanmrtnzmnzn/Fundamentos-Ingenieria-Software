package Repositorios.Repositorios_Map;

import DiagramaDeClases.Dueno;
import Repositorios.DuenoRepositorio;

import java.util.*;
import java.util.stream.Collectors;

public class DuenoRepositorio_Map implements DuenoRepositorio {

    private final Map<Integer, Dueno> duenos;
    private int id;

    public DuenoRepositorio_Map() {
        this.duenos = new HashMap<>();
        this.id = 1;
    }

    @Override
    public Optional<Dueno> findById(Integer id) {
        for (Dueno dueno : this.findAll()) {
            if (dueno.getId().equals(id))
                return Optional.of(dueno);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Dueno> findByEmail(String email) {
        for (Dueno dueno : this.findAll()) {
            if (dueno.getEmail().equals(email))
                return Optional.of(dueno);
        }
        return Optional.empty();
    }

    @Override
    public Dueno create(Dueno entity) {
        this.setId(entity, this.id);
        this.duenos.put(this.id, entity);
        this.id++;
        return entity;
    }

    private void setId(Dueno entity, int id) {
        entity.setId(id);
    }

    @Override
    public Dueno update(Dueno entity) {
        if (this.getId(entity) == null) {
            throw new IllegalArgumentException("No se puede actualizar el Dueno cuando su id es null: " + entity);
        }
        this.duenos.put(this.getId(entity), entity);
        return entity;
    }

    private Integer getId(Dueno entity) {
        return entity.getId();
    }

    @Override
    public Optional<Dueno> read(Integer id) {
        return Optional.ofNullable(this.duenos.get(id));
    }


    @Override
    public List<Dueno> findAll() {
        return new ArrayList<>(duenos.values());
    }

    @Override
    public void deleteById(Integer id) {
        duenos.remove(id);
    }

    @Override
    public List<Dueno> findByName(String name) {
        return duenos.values().stream()
                .filter(dueno -> dueno.getNombre().equals(name))
                .collect(Collectors.toList());
    }
}

