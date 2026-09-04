package DiagramaDeClases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CuidadorTest {
    private Cuidador cuidador;
    @BeforeEach
    void before(){
this.cuidador= new Cuidador(1,"Daniel","daniel@upm.es","password1234","calle de prueba","soy un buen cuidador",12,20.5f,"No hay documentacion","ES52839300101","Si");
    }
    @Test
    void testCuidador(){
    assertEquals(1,this.cuidador.getId());
    assertEquals("Daniel",this.cuidador.getNombre());
    assertEquals("daniel@upm.es",this.cuidador.getEmail());
    assertEquals("password1234",this.cuidador.getContrasenia());
    assertEquals("calle de prueba",this.cuidador.getDireccion());
    assertEquals("soy un buen cuidador",this.cuidador.getDescripcion());
    assertEquals(12,this.cuidador.getDistanciaMax());
    assertEquals(20.5f,this.cuidador.getTarifa());
    assertEquals("No hay documentacion",this.cuidador.getDocumentacion());
    assertEquals("ES52839300101",this.cuidador.getIBAN());
    }


}