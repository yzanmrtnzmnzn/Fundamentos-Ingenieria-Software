package Vistas;

import java.util.HashMap;

public class VistaCuidador extends VistaGenerica{
    public HashMap<String, String> registrarCuidador() {
        HashMap<String, String> datosRegistro = new HashMap<>();
        System.out.println("Por favor, introduce los datos para el registro del cuidador:");
        System.out.print("Nombre: ");
        datosRegistro.put("Nombre", getS().nextLine());
        System.out.print("Email: ");
        datosRegistro.put("Email", getS().nextLine());
        System.out.print("Contrasenia: ");
        datosRegistro.put("Contrasenia", getS().nextLine());
        System.out.print("Dirección: ");
        datosRegistro.put("Direccion", getS().nextLine());
        System.out.print("Descripción: ");
        datosRegistro.put("Descripcion", getS().nextLine());
        System.out.print("Distancia máxima: ");
        datosRegistro.put("DistanciaMax", getS().nextLine());
        System.out.print("Tarifa: ");
        datosRegistro.put("Tarifa", getS().nextLine());
        System.out.print("Documentación: ");
        datosRegistro.put("Documentacion", getS().nextLine());
        System.out.print("IBAN: ");
        datosRegistro.put("IBAN", getS().nextLine());
        System.out.print("Foto(Si/No): ");
        datosRegistro.put("Foto", getS().nextLine());
        return datosRegistro;
    }

    public HashMap<String, String> loginCuidador() {
        HashMap<String, String> datosLogin = new HashMap<>();
        System.out.println("Por favor, introduce tus credenciales para iniciar sesión:");
        System.out.print("Email: ");
        datosLogin.put("Email", getS().nextLine());
        System.out.print("Contrasenia: ");
        datosLogin.put("Contrasenia", getS().nextLine());
        return datosLogin;
    }

    public void mostrarMensaje(String mensajeError) {
        System.out.println(mensajeError);
    }
    public void mostrarMensajeCorrecto(String mensaje) {
        System.out.println(mensaje);
    }
}
