package DiagramaDeClases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {


    @Test
    public void testConstructorWithId() {
        Integer id = 12345;
        String nombre = "John Doe";
        String email = "johndoe@example.com";
        String contrasenia = "password123";
        String direccion = "Calle Mayor, 123";

        Usuario usuario = new Usuario(id, nombre, email, contrasenia, direccion);

        Assertions.assertEquals(id, usuario.getId());
        Assertions.assertEquals(nombre, usuario.getNombre());
        Assertions.assertEquals(email, usuario.getEmail());
        Assertions.assertEquals(contrasenia, usuario.getContrasenia());
        Assertions.assertEquals(direccion, usuario.getDireccion());
    }

    @Test
    public void testConstructorWithoutId() {
        String nombre = "Jane Doe";
        String email = "janedoe@example.com";
        String contrasenia = "password456";
        String direccion = "Calle Real, 456";

        Usuario usuario = new Usuario(nombre, email, contrasenia, direccion);

        Assertions.assertNull(usuario.getId());
        Assertions.assertEquals(nombre, usuario.getNombre());
        Assertions.assertEquals(email, usuario.getEmail());
        Assertions.assertEquals(contrasenia, usuario.getContrasenia());
        Assertions.assertEquals(direccion, usuario.getDireccion());
    }

    @Test
    public void testGetNombre() {
        String nombre = "Peter Jones";
        String email = "peterjones@example.com";
        String contrasenia = "password789";
        String direccion = "Calle Principal, 789";

        Usuario usuario = new Usuario(nombre, email, contrasenia, direccion);

        String nombreActual = usuario.getNombre();

        Assertions.assertEquals(nombre, nombreActual);
    }

    @Test
    public void testSetNombre() {
        String nombre = "Mary Smith";
        String email = "marysmith@example.com";
        String contrasenia = "password012";
        String direccion = "Calle Nueva, 012";

        Usuario usuario = new Usuario(nombre, email, contrasenia, direccion);

        String nuevoNombre = "David Williams";

        usuario.setNombre(nuevoNombre);

        String nombreActual = usuario.getNombre();

        Assertions.assertEquals(nuevoNombre, nombreActual);
    }

    @Test
    public void testGetId() {
        Integer id = 67890;
        String nombre = "Susan Miller";
        String email = "susanmiller@example.com";
        String contrasenia = "password345";
        String direccion = "Calle del Sol, 345";

        Usuario usuario = new Usuario(id, nombre, email, contrasenia, direccion);

        Integer idActual = usuario.getId();

        Assertions.assertEquals(id, idActual);
    }

    @Test
    public void testSetId() {
        Integer id = 12345;
        String nombre = "John Doe";
        String email = "johndoe@example.com";
        String contrasenia = "password123";
        String direccion = "Calle Mayor, 123";

        Usuario usuario = new Usuario(nombre, email, contrasenia, direccion);

        Integer nuevoId = 67890;

        usuario.setId(nuevoId);

        Integer idActual = usuario.getId();

        Assertions.assertEquals(nuevoId, idActual);
    }

    @Test
    public void testGetEmail() {
        String nombre = "Jane Doe";
        String email = "janedoe@example.com";
        String contrasenia = "password456";
        String direccion = "Calle Real, 456";

        Usuario usuario = new Usuario(nombre, email, contrasenia, direccion);

        String emailActual = usuario.getEmail();

        Assertions.assertEquals(email, emailActual);
    }

    @Test
    public void testSetEmail() {
        String nombre = "Peter Jones";
        String email = "peterjones@example.com";
        String contrasenia = "password789";
        String direccion = "Calle Principal, 789";

        Usuario usuario = new Usuario(nombre, email, contrasenia, direccion);

        String nuevoEmail = "maryjones@example";
        usuario.setEmail(nuevoEmail);
        Assertions.assertEquals(nuevoEmail,usuario.getEmail());
    }
}
