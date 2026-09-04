package Vistas;

import java.util.HashMap;

public class VistaMascotaExotica extends VistaGenerica{
    public HashMap<String, String> registrarMascotaExotica() {
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
        System.out.print("CertificadoDeProcedencia: ");
        datosRegistro.put("Procedencia", getS().nextLine());
        System.out.print("CertificadoSalud: ");
        datosRegistro.put("CertificadoSalud", getS().nextLine());
        System.out.print("PermisoLegal: ");
        datosRegistro.put("PermisoLegal", getS().nextLine());
        return datosRegistro;
    }
    public void mostrarMensaje(String mensajeError) {
        System.out.println(mensajeError);
    }
}
