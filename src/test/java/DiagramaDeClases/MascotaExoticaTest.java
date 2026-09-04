package DiagramaDeClases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MascotaExoticaTest {
    private MascotaExotica mascotaExotica;
    @BeforeEach
    void before(){
        mascotaExotica = new MascotaExotica(123456789L, "Coco", "Loro muy hablador", "Calle Selva, 456", 98765, "Ave", "A123456789", "B987654321", "C012345678");
    }

    @Test
    public void testConstructor() {

        Assertions.assertEquals(123456789L, mascotaExotica.getCodigoRIAC());
        Assertions.assertEquals("Coco", mascotaExotica.getNombre());
        Assertions.assertEquals("Calle Selva, 456", mascotaExotica.getDireccion());
        Assertions.assertEquals(98765, mascotaExotica.getNPoliza());
        Assertions.assertEquals("Ave", mascotaExotica.getTipo());
        Assertions.assertEquals("A123456789", mascotaExotica.getCertificadoProcedencia());
        Assertions.assertEquals("B987654321", mascotaExotica.getCertificadoSalud());
        Assertions.assertEquals("C012345678", mascotaExotica.getPermisoLegal());
    }

    @Test
    public void testGetCertificadoProcedencia() {

        String certificado = mascotaExotica.getCertificadoProcedencia();

        Assertions.assertEquals("A123456789", certificado);
    }

    @Test
    public void testSetCertificadoProcedencia() {
        String newCertificadoProcedencia = "Y987654321";

        mascotaExotica.setCertificadoProcedencia(newCertificadoProcedencia);

        String certificado = mascotaExotica.getCertificadoProcedencia();

        Assertions.assertEquals(newCertificadoProcedencia, certificado);
    }

    @Test
    public void testGetCertificadoSalud() {

        String certificado = mascotaExotica.getCertificadoSalud();

        Assertions.assertEquals("B987654321", certificado);
    }

    @Test
    public void testSetCertificadoSalud() {
        String newCertificadoSalud = "X012345678";

        mascotaExotica.setCertificadoSalud(newCertificadoSalud);

        String certificado = mascotaExotica.getCertificadoSalud();

        Assertions.assertEquals(newCertificadoSalud, certificado);
    }

    @Test
    public void testGetPermisoLegal() {

        String permisoLegal = mascotaExotica.getPermisoLegal();

        Assertions.assertEquals("C012345678", permisoLegal);
     }
     @Test
    public void testSetPermisoLegal(){
        String newPermisoLegal = "Z123456789";

        mascotaExotica.setPermisoLegal(newPermisoLegal);

        String permisoLegal = mascotaExotica.getPermisoLegal();

        Assertions.assertEquals(newPermisoLegal, permisoLegal);
    }
}
