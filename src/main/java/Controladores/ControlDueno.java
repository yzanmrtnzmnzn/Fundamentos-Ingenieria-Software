package Controladores;

import DiagramaDeClases.Dueno;
import DiagramaDeClases.Mascota;
import DiagramaDeClases.MascotaExotica;
import Repositorios.DuenoRepositorio;
import Vistas.VistaDueno;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ControlDueno {
    private final DuenoRepositorio duenoRepositorio;
    private final VistaDueno gui;

    public ControlDueno(DuenoRepositorio duenoRepositorio) {
        this.duenoRepositorio = duenoRepositorio;
        gui = new VistaDueno();
    }

    public void registrarDueno() {
        HashMap<String, String> datosRegistro = gui.registrarDueno();
        if (validarDatosRegistro(datosRegistro)) {
            Dueno nuevoDueno = new Dueno(
                    datosRegistro.get("Nombre"),
                    datosRegistro.get("Email"),
                    datosRegistro.get("Contrasenia"),
                    datosRegistro.get("Direccion")
            );
            this.duenoRepositorio.create(nuevoDueno);
        } else {
            gui.mostrarMensaje("No se ha podido realizar el login, intentelo de nuevo");
        }
    }

    private boolean validarDatosRegistro(HashMap<String, String> datos) {
        if (datos.get("Nombre").trim().isEmpty() ||
                datos.get("Email").trim().isEmpty() ||
                datos.get("Contrasenia").trim().isEmpty() ||
                datos.get("Direccion").trim().isEmpty()) {
            return false;
        }
        if (!datos.get("Email").contains("@") || !datos.get("Email").contains(".")) {
            return false;
        }
        return !this.existeDueno(datos.get("Email"));

    }

    public void agregarMascota(Dueno dueno, Mascota mascota) {
        dueno.agregarMascota(mascota);
    }

    public void agregarMascotaExotica(Dueno dueno, MascotaExotica mascotaExotica) {
        dueno.agregarMascotaExotica(mascotaExotica);
    }

    public void listarMascotas(Dueno dueno) {

        for (Mascota mascota : dueno.getMascotas()) {
            gui.mostrarMensajeCorrecto(mascota.toString());
        }
        for (Mascota mascotaExotica : dueno.getMascotasExoticas()) {
            gui.mostrarMensajeCorrecto(mascotaExotica.toString());
        }

    }

    private boolean existeDueno(String email) {

        return this.duenoRepositorio.findByEmail(email).isPresent();
    }

    public Optional<Dueno> loginDueno() {
        HashMap<String, String> datosLogin = gui.loginDueno();
        Optional<Dueno> duenoEncontrado = this.duenoRepositorio.findByEmail(datosLogin.get("Email"));

        if (duenoEncontrado.isPresent() && duenoEncontrado.get().getContrasenia().equals(datosLogin.get("Contrasenia"))) {
            return duenoEncontrado;
        } else {
            this.gui.mostrarMensaje("Error al iniciar sesion, las credenciales no son validas");
            return Optional.empty();
        }
    }

    public void listarDuenosYMascotas() {
        List<Dueno> duenos = this.duenoRepositorio.findAll();
        for (Dueno dueno : duenos) {
            this.gui.mostrarMensajeCorrecto("Dueno: " + dueno.getNombre());
            List<Mascota> mascotas = dueno.getMascotas();
            for (Mascota mascota : mascotas) {
                this.gui.mostrarMensajeCorrecto("  Mascota: " + mascota.getNombre() + " - Descripcion: " + mascota.getDescripcion());
            }
            List<MascotaExotica> mascotasExoticas = dueno.getMascotasExoticas();
            for (MascotaExotica mascotaExotica : mascotasExoticas) {
                this.gui.mostrarMensajeCorrecto("  MascotaExotica: " + mascotaExotica.getNombre() + " - Descripcion: " + mascotaExotica.getDescripcion());
            }
        }

    }
}
