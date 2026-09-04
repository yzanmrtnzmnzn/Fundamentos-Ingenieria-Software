package Repositorios.Repositorios_Map;

import DiagramaDeClases.Mascota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class MascotaRepositorio_MapTest {

    private MascotaRepositorio_Map mascotaRepositorio;
    private Mascota mascota1;
    private Mascota mascota2;

    @BeforeEach
    public void setUp() {
        mascotaRepositorio = new MascotaRepositorio_Map();
        mascota1 = new Mascota(1273940L, "Perro1","Bulldog", "casa1",71728,"gato");
        mascota1.setCodigoRIAC(1L);


        mascota2 = new Mascota( 1728930L, "Perro2","Pastor Aleman", "casa2",127676,"perro");
        mascota2.setCodigoRIAC(2L);
    }

    @Test
    public void testCreate() {
        Mascota createdMascota = mascotaRepositorio.create(mascota1);
        assertNotNull(createdMascota);
        assertEquals(1, createdMascota.getCodigoRIAC());
    }

    @Test
    public void testFindById() {
        mascotaRepositorio.create(mascota1);
        Optional<Mascota> foundMascota = mascotaRepositorio.findById(1L);
        assertTrue(foundMascota.isPresent());
        assertEquals("Perro1", foundMascota.get().getNombre());
    }

    @Test
    public void testUpdate() {
        mascotaRepositorio.create(mascota1);
        mascota1.setNombre("Firulais Updated");
        Mascota updatedMascota = mascotaRepositorio.update(mascota1);
        assertEquals("Firulais Updated", updatedMascota.getNombre());
    }

    @Test
    public void testRead() {
        mascotaRepositorio.create(mascota1);
        Optional<Mascota> foundMascota = mascotaRepositorio.read(1);
        assertTrue(foundMascota.isPresent());
        assertEquals("Perro1", foundMascota.get().getNombre());
    }

    @Test
    public void testFindAll() {
        mascotaRepositorio.create(mascota1);
        mascotaRepositorio.create(mascota2);
        List<Mascota> mascotas = mascotaRepositorio.findAll();
        assertEquals(2, mascotas.size());
    }

    @Test
    public void testDeleteById() {
        mascotaRepositorio.create(mascota1);
        mascotaRepositorio.deleteById(1);
        Optional<Mascota> foundMascota = mascotaRepositorio.read(1);
        assertFalse(foundMascota.isPresent());
    }

    @Test
    public void testFindByName() {
        mascotaRepositorio.create(mascota1);
        mascotaRepositorio.create(mascota2);
        List<Mascota> foundMascotas = mascotaRepositorio.findByName("Perro1");
        assertEquals(1, foundMascotas.size());
        assertEquals(1, foundMascotas.get(0).getCodigoRIAC());
    }
}

