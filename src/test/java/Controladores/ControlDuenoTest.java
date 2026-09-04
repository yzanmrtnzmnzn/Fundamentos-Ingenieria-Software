package Controladores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import DiagramaDeClases.Dueno;
import DiagramaDeClases.Mascota;
import DiagramaDeClases.MascotaExotica;
import Repositorios.DuenoRepositorio;
import Repositorios.Repositorios_Map.DuenoRepositorio_Map;


public class ControlDuenoTest {

    private ControlDueno controlDueno;
    private DuenoRepositorio duenoRepositorio;


    @BeforeEach
    public void setUp() {
        this.duenoRepositorio= new DuenoRepositorio_Map();
        controlDueno = new ControlDueno(duenoRepositorio);
    }


    @Test
    public void agregarMascota_conMascotaValida_agregaMascotaAlDueno() {
        Dueno dueno = new Dueno("Juan Pérez", "juan.perez@email.com", "password123", "Calle Mayor, 123");
        Mascota mascota = new Mascota(1L, "Max", "Perro de raza Golden Retriever", "Calle Mayor, 123", 123456, "Perro");

        controlDueno.agregarMascota(dueno, mascota);

        assertEquals(1, dueno.getMascotas().size());
        assertEquals(mascota, dueno.getMascotas().get(0));
    }

    @Test
    public void agregarMascotaExotica_conMascotaExoticaValida_agregaMascotaExoticaAlDueno() {
        Dueno dueno = new Dueno("Juan Pérez", "juan.perez@email.com", "password123", "Calle Mayor, 123");
        MascotaExotica mascotaExotica = new MascotaExotica(1L, "Max", "Perro de raza Golden Retriever", "Calle Mayor, 123", 123456, "Perro", "Madrid", "Optimo", "Si");
    }
}

