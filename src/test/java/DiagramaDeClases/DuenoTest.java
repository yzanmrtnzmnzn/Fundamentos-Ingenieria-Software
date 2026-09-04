package DiagramaDeClases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuenoTest {
    private Dueno dueno;
    @BeforeEach
    void before(){
        this.dueno = new Dueno(1,"Juan","juan@upm.es","123","casa1");
    }
    @Test
    void testDueno(){
        assertEquals(1,this.dueno.getId());
        assertEquals("Juan",this.dueno.getNombre());
        assertEquals("juan@upm.es",this.dueno.getEmail());
        assertEquals("123",this.dueno.getContrasenia());
        assertEquals("casa1",this.dueno.getDireccion());
        this.dueno.setNombre("Juan Carlos");
        assertEquals("Juan Carlos",this.dueno.getNombre());
    }
    @Test
    void testToString(){
        assertEquals("Dueno{nombre=Juan, email=juan@upm.es, contrasenia=123, direccion=casa1}",this.dueno.toString());
    }

}