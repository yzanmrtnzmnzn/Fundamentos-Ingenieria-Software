package Repositorios.Repositorios_Map;

import DiagramaDeClases.Cuidador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CuidadorRepositorio_MapTest {
    private CuidadorRepositorio_Map cuidadorRepositorio_map;
    private Cuidador cuidador;
    @BeforeEach
    void before(){
        this.cuidadorRepositorio_map= new CuidadorRepositorio_Map();
        this.cuidador= new Cuidador(1,"Daniel","daniel@upm.es","password1234","calle de prueba","soy un buen cuidador",12,20.5f,"No hay documentación","ES52839300101","Si");
    }
    @Test
    public void testCreate() {
        Cuidador creado = cuidadorRepositorio_map.create(cuidador);
        assertEquals(cuidador, creado);
    }
    @Test
    public void testUpdate() {
        Cuidador creado = cuidadorRepositorio_map.create(cuidador);
        creado.setNombre("Updated");
        Cuidador updated = cuidadorRepositorio_map.update(creado);
        assertEquals("Updated", updated.getNombre());
    }

    @Test
    public void testRead() {
        Cuidador creado = cuidadorRepositorio_map.create(cuidador);
        Optional<Cuidador> read = cuidadorRepositorio_map.read(creado.getId());
        assertTrue(read.isPresent());
        assertEquals(creado, read.get());
    }

    @Test
    public void testDeleteById() {
        Cuidador creado = cuidadorRepositorio_map.create(cuidador);
        cuidadorRepositorio_map.deleteById(creado.getId());
        Optional<Cuidador> read = cuidadorRepositorio_map.read(creado.getId());
        assertFalse(read.isPresent());
    }

    @Test
    public void testFindAll() {
        Cuidador creado = cuidadorRepositorio_map.create(cuidador);
        List<Cuidador> all = cuidadorRepositorio_map.findAll();
        assertTrue(all.contains(creado));
    }

    @Test
    public void testFindByName() {
        Cuidador creado = cuidadorRepositorio_map.create(cuidador);
        List<Cuidador> found = cuidadorRepositorio_map.findByName("Daniel");
        assertTrue(found.contains(creado));
    }
}