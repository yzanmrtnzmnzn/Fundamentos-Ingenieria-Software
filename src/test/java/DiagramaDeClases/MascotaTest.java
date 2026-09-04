package DiagramaDeClases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MascotaTest {

    private Mascota mascota;

    @BeforeEach
    void before(){
        Long riac= Long.valueOf(123456789);
        mascota = new Mascota(riac, "Max", "Perro labrador", "Calle Mayor, 123", 12345, "Perro");
    }

    @Test
    public void testMascota() {

        Assertions.assertEquals(123456789, mascota.getCodigoRIAC());
        Assertions.assertEquals("Max", mascota.getNombre());
        Assertions.assertEquals("Calle Mayor, 123", mascota.getDireccion());
        Assertions.assertEquals("Perro labrador", mascota.getDescripcion());
        Assertions.assertEquals(12345, mascota.getNPoliza());
        Assertions.assertEquals("Perro", mascota.getTipo());
    }


    @Test
    public void testGetNombre() {

        String nombre = mascota.getNombre();
        Assertions.assertEquals("Max", nombre);
    }

    @Test
    public void testSetNombre() {

        mascota.setNombre("Toby");
        String nombre = mascota.getNombre();
        Assertions.assertEquals("Toby", nombre);
    }

    @Test
    public void testGetDescripcion() {

        String descripcion1 = mascota.getDescripcion();
        Assertions.assertEquals("Perro labrador", descripcion1);
    }

    @Test
    public void testSetDescripcion() {

        mascota.setDescripcion("Golden retriever");
        String descripcion = mascota.getDescripcion();
        Assertions.assertEquals("Golden retriever", descripcion);
    }

    @Test
    public void testGetNPoliza() {

        Integer nPoliza = mascota.getNPoliza();
        Assertions.assertEquals(12345, nPoliza);
    }

    @Test
    public void testSetNPoliza() {

        mascota.setNPoliza(54321);
        Integer nPoliza = mascota.getNPoliza();
        Assertions.assertEquals(54321, nPoliza);
    }

    @Test
    public void testGetCodigoRIAC() {

        Long codigoRIAC = mascota.getCodigoRIAC();
        Assertions.assertEquals(123456789, codigoRIAC);
    }

    @Test
    public void testSetCodigoRIAC() {
        mascota.setCodigoRIAC(98765L);
        Long codigoRIAC= mascota.getCodigoRIAC();
        Assertions.assertEquals(98765L, codigoRIAC);
    }

    @Test
    public void testGetTipo(){

        String tipo=mascota.getTipo();
        Assertions.assertEquals("Perro", tipo);
    }

    @Test
    public void testSetTipo(){
        mascota.setTipo("Gato");
        String tipo=mascota.getTipo();
        Assertions.assertEquals("Gato", tipo);
    }
}