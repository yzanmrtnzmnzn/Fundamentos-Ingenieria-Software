package Controladores;

import DiagramaDeClases.MascotaExotica;
import Repositorios.MascotaExoticaRepositorio;
import Vistas.VistaMascotaExotica;

import java.util.HashMap;

public class ControladorMascotaExotica {
    private final MascotaExoticaRepositorio mascotaExoticaRepositorio;
    private final VistaMascotaExotica vistaMascotaExotica;

    public ControladorMascotaExotica(MascotaExoticaRepositorio mascotaExoticaRepositorio) {
        this.mascotaExoticaRepositorio = mascotaExoticaRepositorio;
        this.vistaMascotaExotica = new VistaMascotaExotica();
    }

    public MascotaExotica registrarMascotaExotica() {
        HashMap<String, String> datosRegistro = vistaMascotaExotica.registrarMascotaExotica();

        if (validarDatosRegistro(datosRegistro)) {
            MascotaExotica nuevaMascota = new MascotaExotica(
                    Long.parseLong(datosRegistro.get("codigoRIAC")),
                    datosRegistro.get("Nombre"),
                    datosRegistro.get("Descripcion"),
                    datosRegistro.get("Direccion"),
                    Integer.parseInt(datosRegistro.get("nPoliza")),
                    datosRegistro.get("tipo"),
                    datosRegistro.get("Procedencia"),
                    datosRegistro.get("CertificadoSalud"),
                    datosRegistro.get("PermisoLegal")
            );
            vistaMascotaExotica.mostrarMensaje("Mascota registrada con éxito");
            return this.mascotaExoticaRepositorio.create(nuevaMascota);
        }
        vistaMascotaExotica.mostrarMensaje("No se ha podido registrar la mascota. Revise los datos introducidos.");
        return null;
    }

    private boolean validarDatosRegistro(HashMap<String, String> datos) {
        if (datos.get("codigoRIAC").trim().isEmpty() ||
                datos.get("Nombre").trim().isEmpty() ||
                datos.get("Descripcion").trim().isEmpty() ||
                datos.get("Direccion").trim().isEmpty() ||
                datos.get("nPoliza").trim().isEmpty() ||
                datos.get("tipo").trim().isEmpty() ||
                datos.get("Procedencia").trim().isEmpty() ||
                datos.get("CertificadoSalud").trim().isEmpty() ||
                datos.get("PermisoLegal").trim().isEmpty()) {
            return false;
        }
        return datos.get("codigoRIAC").trim().length() == 10;
    }
}
