package Repositorios.Repositorios_Map;

import DiagramaDeClases.MascotaExotica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class MascotaExoticaRepositorio_MapTest {

    private MascotaExoticaRepositorio_Map mascotaRepositorio;
    private MascotaExotica mascota1;
    private MascotaExotica mascota2;

    @BeforeEach
    public void setUp() {
        mascotaRepositorio = new MascotaExoticaRepositorio_Map();
        mascota1 = new MascotaExotica(1L, "Loro", "Rojo", "Calle Selva, 456", 98756, "Ave", "A123456789", "B987654321", "C012345678");

        mascota2 = new MascotaExotica(2L, "Iguana", "Verde", "Calle Test, 1", 12345, "Iguana", "Z123456789", "Y987654321", "X012345678");
        mascota2.setCodigoRIAC(2L);
        mascota2.setNombre("Iguana");
    }

    @Test
    public void testCreate() {
        MascotaExotica createdMascota = mascotaRepositorio.create(mascota1);
        assertNotNull(createdMascota);
        assertEquals(1, createdMascota.getCodigoRIAC());
    }

    @Test
    public void testFindById() {
        mascotaRepositorio.create(mascota1);
        Optional<MascotaExotica> foundMascota = mascotaRepositorio.findById(1L);
        assertTrue(foundMascota.isPresent());
        assertEquals("Loro", foundMascota.get().getNombre());
    }

    @Test
    public void testUpdate() {
        mascotaRepositorio.create(mascota1);
        mascota1.setNombre("Loro Updated");
        MascotaExotica updatedMascota = mascotaRepositorio.update(mascota1);
        assertEquals("Loro Updated", updatedMascota.getNombre());
    }

    @Test
    public void testRead() {
        mascotaRepositorio.create(mascota1);
        Optional<MascotaExotica> foundMascota = mascotaRepositorio.read(1);
        assertTrue(foundMascota.isPresent());
        assertEquals("Loro", foundMascota.get().getNombre());
    }

    @Test
    public void testFindAll() {
        mascotaRepositorio.create(mascota1);
        mascotaRepositorio.create(mascota2);
        List<MascotaExotica> mascotas = mascotaRepositorio.findAll();
        assertEquals(2, mascotas.size());
    }

    @Test
    public void testDeleteById() {
        mascotaRepositorio.create(mascota1);
        mascotaRepositorio.deleteById(1);
        Optional<MascotaExotica> foundMascota = mascotaRepositorio.read(1);
        assertFalse(foundMascota.isPresent());
    }

    @Test
    public void testFindByName() {
        mascotaRepositorio.create(mascota1);
        mascotaRepositorio.create(mascota2);
        List<MascotaExotica> foundMascotas = mascotaRepositorio.findByName("Loro");
        assertEquals(1, foundMascotas.size());
        assertEquals(1, foundMascotas.get(0).getCodigoRIAC());
    }
}
