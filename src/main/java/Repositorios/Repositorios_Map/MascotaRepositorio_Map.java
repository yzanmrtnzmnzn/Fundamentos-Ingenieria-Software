package Repositorios.Repositorios_Map;

import DiagramaDeClases.Mascota;
import Repositorios.MascotaRepositorio;

import java.util.*;
import java.util.stream.Collectors;

public class MascotaRepositorio_Map implements MascotaRepositorio {

    private final Map<Long, Mascota> mascotas;

    public MascotaRepositorio_Map() {
        this.mascotas = new HashMap<>();
    }


    @Override
    public Optional<Mascota> findById(Long id) {
        for (Mascota mascota : this.findAll()) {
            if (mascota.getCodigoRIAC().equals(id))
                return Optional.of(mascota);
        }
        return Optional.empty();

    }

    @Override
    public Mascota create(Mascota entity) {
        this.mascotas.put(this.getId(entity), entity);
        return entity;
    }


    @Override
    public Mascota update(Mascota entity) {
        if (this.getId(entity) == null) {
            throw new IllegalArgumentException("No se puede actualizar la mascota cuando su id es null: " + entity);
        }
        this.mascotas.put(this.getId(entity), entity);
        return entity;
    }

    private Long getId(Mascota entity) {
        return entity.getCodigoRIAC();

    }

    @Override
    public Optional<Mascota> read(Integer id) {
        return Optional.ofNullable(this.mascotas.get(id.longValue()));
    }

    @Override
    public void deleteById(Integer id) {
        this.mascotas.remove(id.longValue());

    }

    @Override
    public List<Mascota> findAll() {
        return new ArrayList<>(this.mascotas.values());
    }


    @Override
    public List<Mascota> findByName(String name) {
        return this.mascotas.values().stream()
                .filter(mascota -> mascota.getNombre().equals(name))
                .collect(Collectors.toList());
    }


}
