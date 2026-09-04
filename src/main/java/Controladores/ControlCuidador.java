package Controladores;

import DiagramaDeClases.Cuidador;
import DiagramaDeClases.Dueno;
import DiagramaDeClases.Mascota;
import DiagramaDeClases.MascotaExotica;
import Repositorios.CuidadorRepositorio;
import Repositorios.DuenoRepositorio;
import Vistas.VistaCuidador;
import Vistas.VistaGenerica;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ControlCuidador {
    private final CuidadorRepositorio cuidadorRepositorio;
    private final DuenoRepositorio duenoRepositorio;
    private final VistaCuidador gui;

    public ControlCuidador(CuidadorRepositorio cuidadorRepositorio, DuenoRepositorio duenoRepositorio) {
        this.cuidadorRepositorio = cuidadorRepositorio;
        this.duenoRepositorio = duenoRepositorio;
        gui = new VistaCuidador();
    }

    public void registrarCuidador() {
        HashMap<String, String> datosRegistro = gui.registrarCuidador();
        if (validarDatosRegistro(datosRegistro)) {
            Cuidador nuevoCuidador = new Cuidador(
                    datosRegistro.get("Nombre"),
                    datosRegistro.get("Email"),
                    datosRegistro.get("Contrasenia"),
                    datosRegistro.get("Direccion"),
                    datosRegistro.get("Descripcion"),
                    Integer.parseInt(datosRegistro.get("DistanciaMax")),
                    Float.parseFloat(datosRegistro.get("Tarifa")),
                    datosRegistro.get("Documentacion"),
                    datosRegistro.get("IBAN"),
                    datosRegistro.get("Foto")//Quitar foto de la clase Cuidador y en el constructor que si no da error
            );
            this.cuidadorRepositorio.create(nuevoCuidador);
        } else {
            gui.mostrarMensaje("No se ha podido realizar el login, intentelo de nuevo");
        }
    }

    private boolean validarDatosRegistro(HashMap<String, String> datos) {
        if (datos.get("Nombre").trim().isEmpty() ||
                datos.get("Email").trim().isEmpty() ||
                datos.get("Contrasenia").trim().isEmpty() ||
                datos.get("Direccion").trim().isEmpty() ||
                datos.get("Descripcion").trim().isEmpty() ||
                datos.get("Documentacion").trim().isEmpty() ||
                datos.get("IBAN").trim().isEmpty()) {
            return false;
        }
        if (!datos.get("Email").contains("@") || !datos.get("Email").contains(".")) {
            return false;
        }
        return !this.existeCuidador(datos.get("Email"));

    }

    private boolean existeCuidador(String email) {
        return this.cuidadorRepositorio.findByEmail(email).isPresent();
    }

    public Optional<Cuidador> loginCuidador() {
        HashMap<String, String> datosLogin = gui.loginCuidador();
        Optional<Cuidador> cuidadorEncontrado = cuidadorRepositorio.findByEmail(datosLogin.get("Email"));

        if (cuidadorEncontrado.isPresent() && cuidadorEncontrado.get().getContrasenia().equals(datosLogin.get("Contrasenia"))) {
            return cuidadorEncontrado;
        } else {
            this.gui.mostrarMensaje("Error al iniciar sesion, las credenciales no son validas");
            return Optional.empty();
        }
    }

    public void creacionReservaMascota(Cuidador cuidador, String nombreDueno) {
        List<Dueno> duenos = duenoRepositorio.findByName(nombreDueno);
        if (!duenos.isEmpty()) {
            Dueno dueno = duenos.get(0);
            List<Mascota> mascotas = dueno.getMascotas();
            List<MascotaExotica> mascotasExoticas = dueno.getMascotasExoticas();
            this.gui.mostrarMensajeCorrecto("Mascotas del dueño " + dueno.getNombre() + ":");
            for (Mascota mascota : mascotas) {
                this.gui.mostrarMensajeCorrecto("  Mascota: " + mascota.getNombre());
            }
            for (MascotaExotica mascotaExotica : mascotasExoticas) {
                this.gui.mostrarMensajeCorrecto("  Mascota Exótica: " + mascotaExotica.getNombre());
            }
            this.gui.mostrarMensajeCorrecto("Por favor, introduce el nombre de la mascota que quieres reservar: ");
            String nombreMascota = VistaGenerica.getS().nextLine();

            Optional<Mascota> mascotaOpt = mascotas.stream()
                    .filter(mascota -> mascota.getNombre().equals(nombreMascota))
                    .findFirst();

            Optional<MascotaExotica> mascotaExoticaOpt = mascotasExoticas.stream()
                    .filter(mascotaExotica -> mascotaExotica.getNombre().equals(nombreMascota))
                    .findFirst();
            if (mascotaOpt.isPresent()) {
                cuidador.agregarMascota(mascotaOpt.get());
                cuidador.agregarDueno(dueno);
                this.gui.mostrarMensajeCorrecto("Reserva creada con éxito para la mascota " + nombreMascota);

            } else if (mascotaExoticaOpt.isPresent()) {
                cuidador.agregarMascotaExotica(mascotaExoticaOpt.get());
                cuidador.agregarDueno(dueno);
                this.gui.mostrarMensajeCorrecto("Reserva creada con éxito para la mascota exótica " + nombreMascota);
            } else {
                this.gui.mostrarMensaje("No se encontró ninguna mascota con el nombre " + nombreMascota);
            }

        } else {
            this.gui.mostrarMensaje("No se pudo encontrar al dueño con el nombre: " + nombreDueno);
        }
    }
}
