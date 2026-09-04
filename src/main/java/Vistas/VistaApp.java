package Vistas;


public class VistaApp extends VistaGenerica{
    public VistaApp(){
        super();

    }
    public void bienvenida() {
        System.out.println("Bienvenido a la app de Paseando a Pancho");
        System.out.println();
    }

    public String getSeleccion(String[] values) {
        System.out.println("Elije la opcion que deseas: ");
        for (String op:
                values)
            System.out.println(op);

        System.out.println();
        return getSComandos().nextLine();
    }
    public String getSeleccionUsuario(String[] values) {
        System.out.println("Elije como desea interactuar con la app: ");
        for (String op:
                values)
            System.out.println(op);

        System.out.println();
        return getSComandos().nextLine();
    }
    public void despedida() {
        System.out.println("hasta la proxima");
    }
    public void mensajeLogout() {
        System.out.println("Acaba de cerrar su sesión: ");
    }

    public void errorComando(String comando) {
        System.err.println("comando erroneo: " + comando);
        System.out.println();
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
