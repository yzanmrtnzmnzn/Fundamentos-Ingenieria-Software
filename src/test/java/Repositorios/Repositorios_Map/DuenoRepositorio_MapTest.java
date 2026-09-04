package Repositorios.Repositorios_Map;
import DiagramaDeClases.Dueno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class DuenoRepositorio_MapTest {

    private DuenoRepositorio_Map duenoRepositorio;
    private Dueno dueno1;
    private Dueno dueno2;

    @BeforeEach
    public void setUp() {
        duenoRepositorio = new DuenoRepositorio_Map();
        dueno1 = new Dueno( "Alonso","test1@example.com", "password1234", "Calle Pruebas, 14" );
        dueno2 = new Dueno( "Marc", "test2@example.com", "password1234", "Calle Pruebas, 59");
    }

    @Test
    public void testCreate() {
        Dueno createdDueno = duenoRepositorio.create(dueno1);
        assertNotNull(createdDueno);
        assertEquals(1, createdDueno.getId());
    }

    @Test
    public void testFindById() {
        duenoRepositorio.create(dueno1);
        Optional<Dueno> foundDueno = duenoRepositorio.findById(1);
        assertTrue(foundDueno.isPresent());
        assertEquals("test1@example.com", foundDueno.get().getEmail());
    }

    @Test
    public void testFindByEmail() {
        duenoRepositorio.create(dueno1);
        Optional<Dueno> foundDueno = duenoRepositorio.findByEmail("test1@example.com");
        assertTrue(foundDueno.isPresent());
        assertEquals(1, foundDueno.get().getId());
    }

    @Test
    public void testUpdate() {
        duenoRepositorio.create(dueno1);
        dueno1.setNombre("UpdatedName");
        Dueno updatedDueno = duenoRepositorio.update(dueno1);
        assertEquals("UpdatedName", updatedDueno.getNombre());
    }

    @Test
    public void testRead() {
        duenoRepositorio.create(dueno1);
        Optional<Dueno> foundDueno = duenoRepositorio.read(1);
        assertTrue(foundDueno.isPresent());
        assertEquals("Alonso", foundDueno.get().getNombre());
    }

    @Test
    public void testFindAll() {
        duenoRepositorio.create(dueno1);
        duenoRepositorio.create(dueno2);
        List<Dueno> duenos = duenoRepositorio.findAll();
        assertEquals(2, duenos.size());
    }

    @Test
    public void testDeleteById() {
        duenoRepositorio.create(dueno1);
        duenoRepositorio.deleteById(1);
        Optional<Dueno> foundDueno = duenoRepositorio.read(1);
        assertFalse(foundDueno.isPresent());
    }

    @Test
    public void testFindByName() {
        duenoRepositorio.create(dueno1);
        duenoRepositorio.create(dueno2);
        List<Dueno> foundDuenos = duenoRepositorio.findByName("Alonso");
        assertEquals(1, foundDuenos.size());
        assertEquals("test1@example.com", foundDuenos.get(0).getEmail());
    }
}

