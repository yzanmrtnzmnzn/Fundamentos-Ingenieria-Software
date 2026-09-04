package Controladores;

import DiagramaDeClases.Mascota;
import Repositorios.MascotaRepositorio;
import Vistas.VistaMascota;

import java.util.HashMap;

public class ControladorMascota {
    private final MascotaRepositorio mascotaRepositorio;

    private final VistaMascota vistaMascota;

    public ControladorMascota(MascotaRepositorio mascotaRepositorio) {
        this.mascotaRepositorio = mascotaRepositorio;
        this.vistaMascota = new VistaMascota();

    }

    public void mostrarDetalleMascota(HashMap<String, String> datosMascota) {
        vistaMascota.mostrarDetalleMascota(datosMascota);
    }

    public Mascota registrarMascota() {
        HashMap<String, String> datosRegistro = vistaMascota.registrarMascota();

        if (validarDatosRegistro(datosRegistro)) {
            Mascota nuevaMascota = new Mascota(
                    Long.parseLong(datosRegistro.get("codigoRIAC")),
                    datosRegistro.get("Nombre"),
                    datosRegistro.get("Descripcion"),
                    datosRegistro.get("Direccion"),
                    Integer.parseInt(datosRegistro.get("nPoliza")),
                    datosRegistro.get("tipo")
            );
            vistaMascota.mostrarMensaje("Mascota registrada con éxito");
            return this.mascotaRepositorio.create(nuevaMascota);
        }
        vistaMascota.mostrarMensaje("No se ha podido registrar la mascota. Revise los datos introducidos.");
        return null;
    }

    private boolean validarDatosRegistro(HashMap<String, String> datos) {
        if (datos.get("codigoRIAC").trim().isEmpty() ||
                datos.get("Nombre").trim().isEmpty() ||
                datos.get("Descripcion").trim().isEmpty() ||
                datos.get("Direccion").trim().isEmpty() ||
                datos.get("nPoliza").trim().isEmpty() ||
                datos.get("tipo").trim().isEmpty()) {
            return false;
        }
        return datos.get("codigoRIAC").trim().length() == 10;
    }


}
