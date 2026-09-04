package Repositorios.Repositorios_Map;

import DiagramaDeClases.MascotaExotica;
import Repositorios.MascotaExoticaRepositorio;

import java.util.*;
import java.util.stream.Collectors;

public class MascotaExoticaRepositorio_Map implements MascotaExoticaRepositorio {

    private final Map<Long, MascotaExotica> mascotasExoticas;

    public MascotaExoticaRepositorio_Map() {
        this.mascotasExoticas = new HashMap<>();
    }

    @Override
    public Optional<MascotaExotica> findById(Long id) {
        return Optional.of(mascotasExoticas.get(id));
    }

    @Override
    public MascotaExotica create(MascotaExotica entity) {
        //this.setId(entity, this.id);
        this.mascotasExoticas.put(this.getId(entity), entity);
        //this.id++;
        return entity;
    }

    private Long getId(MascotaExotica entity) {
        return entity.getCodigoRIAC();
    }

    @Override
    public MascotaExotica update(MascotaExotica entity) {
        if (this.getId(entity) == null) {
            throw new IllegalArgumentException("No se puede actualizar la mascotaExotica cuando su id es null: " + entity);
        }
        this.mascotasExoticas.put(this.getId(entity), entity);
        return entity;
    }

    @Override
    public Optional<MascotaExotica> read(Integer id) {
        return Optional.ofNullable(this.mascotasExoticas.get(id.longValue()));
    }


    @Override
    public List<MascotaExotica> findAll() {
        return new ArrayList<>(this.mascotasExoticas.values());
    }

    @Override
    public void deleteById(Integer id) {
        this.mascotasExoticas.remove(id.longValue());
    }

    @Override
    public List<MascotaExotica> findByName(String name) {
        return this.mascotasExoticas.values().stream()
                .filter(mascotaExotica -> mascotaExotica.getNombre().equals(name))
                .collect(Collectors.toList());
    }
}