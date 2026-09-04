package Vistas;

import java.util.HashMap;

public class VistaMascota extends VistaGenerica{
    public HashMap<String, String> registrarMascota() {
        HashMap<String, String> datosRegistro = new HashMap<>();
        System.out.println("Por favor, introduce los datos para el registro de la mascota:");
        System.out.print("Nombre: ");
        datosRegistro.put("Nombre", getS().nextLine());
        System.out.print("codigoRIAC(10 digitos): ");
        datosRegistro.put("codigoRIAC", getS().nextLine());
        System.out.print("Descripcion: ");
        datosRegistro.put("Descripcion", getS().nextLine());
        System.out.print("Direccion: ");
        datosRegistro.put("Direccion", getS().nextLine());
        System.out.print("nPoliza: ");
        datosRegistro.put("nPoliza", getS().nextLine());
        System.out.print("tipo: ");
        datosRegistro.put("tipo", getS().nextLine());
        return datosRegistro;
    }

    public void mostrarDetalleMascota(HashMap<String, String> datosMascota) {
        System.out.println("Detalles de la mascota:");
        System.out.println("Nombre: " + datosMascota.get("Nombre"));
        System.out.println("Especie: " + datosMascota.get("Especie"));
        System.out.println("Raza: " + datosMascota.get("Raza"));
        System.out.println("Edad: " + datosMascota.get("Edad") + " años");
    }

    public void mostrarMensaje(String mensajeError) {
        System.out.println(mensajeError);
    }
}

