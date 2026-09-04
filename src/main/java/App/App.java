package App;


import Controladores.ControlCuidador;
import Controladores.ControlDueno;
import Controladores.ControladorMascota;
import Controladores.ControladorMascotaExotica;
import DiagramaDeClases.Cuidador;
import DiagramaDeClases.Dueno;
import DiagramaDeClases.Mascota;
import DiagramaDeClases.MascotaExotica;
import Repositorios.*;
import Repositorios.Repositorios_Map.CuidadorRepositorio_Map;
import Repositorios.Repositorios_Map.DuenoRepositorio_Map;
import Repositorios.Repositorios_Map.MascotaExoticaRepositorio_Map;
import Repositorios.Repositorios_Map.MascotaRepositorio_Map;
import Vistas.VistaApp;
import Vistas.VistaGenerica;

import java.util.Optional;

public class App {
    static String[] opcionInicial = {"exit", "Dueno", "Cuidador"};
    static String[] opcionRegistroLogin = {"exit", "Registrarme", "Logearme"};
    static String[] opcionCuidadorLogeado = {"exit", "Logout", "ListarMascotas", "CreacionReserva"};
    static String[] opcionDuenoLogeado = {"exit", "Logout", "ListarMascotas", "AltaMascota", "AltaMascotaExotica"};
    static CuidadorRepositorio cuidadorRepositorio = new CuidadorRepositorio_Map();
    static DuenoRepositorio duenoRepositorio = new DuenoRepositorio_Map();
    static MascotaRepositorio mascotaRepositorio = new MascotaRepositorio_Map();
    static MascotaExoticaRepositorio mascotaExoticaRepositorio = new MascotaExoticaRepositorio_Map();

    public static void main(String[] args) {


        ControlCuidador controlCuidador = new ControlCuidador(cuidadorRepositorio, duenoRepositorio);
        ControlDueno controlDueno = new ControlDueno(duenoRepositorio);
        ControladorMascota controladorMascota = new ControladorMascota(mascotaRepositorio);
        ControladorMascotaExotica controladorMascotaExotica = new ControladorMascotaExotica(mascotaExoticaRepositorio);
        VistaApp gui = new VistaApp();
        Seeder seeder = new Seeder(cuidadorRepositorio, duenoRepositorio, mascotaRepositorio, mascotaExoticaRepositorio);
        seeder.seed();
        gui.bienvenida();
        while (true) {
            String inicioUsuario = gui.getSeleccionUsuario(opcionInicial);
            if (inicioUsuario.trim().equals("exit")) {
                gui.despedida();
                System.exit(0);
            } else if (inicioUsuario.trim().equals("Cuidador")) {
                while (true) {
                    String inicioCuidador = gui.getSeleccion(opcionRegistroLogin);
                    switch (inicioCuidador.trim()) {
                        case "exit":
                            gui.despedida();
                            System.exit(0);
                            break;
                        case "Registrarme":
                            controlCuidador.registrarCuidador();
                            break;
                        case "Logearme":
                            Optional<Cuidador> cuidadorLogeado = controlCuidador.loginCuidador();
                            while (cuidadorLogeado.isPresent()) {
                                String opcionCuidador = gui.getSeleccion(opcionCuidadorLogeado);
                                switch (opcionCuidador.trim()) {
                                    case "exit":
                                        gui.despedida();
                                        System.exit(0);
                                        break;
                                    case "Logout":
                                        cuidadorLogeado = Optional.empty();
                                        gui.mensajeLogout();
                                        break;
                                    case "ListarMascotas":
                                        controlDueno.listarDuenosYMascotas();
                                        break;
                                    case "CreacionReserva":
                                        gui.mostrarMensaje("Introduzca el nombre del dueno con el que hacer la reserva: ");
                                        String nombre = VistaGenerica.getS().nextLine();
                                        controlCuidador.creacionReservaMascota(cuidadorLogeado.get(), nombre);
                                        break;
                                    default:
                                        gui.errorComando(opcionCuidador);
                                }

                            }
                            break;
                        default:
                            gui.errorComando(inicioCuidador);

                    }

                }
            } else if (inicioUsuario.trim().equals("Dueno")) {
                while (true) {
                    String inicioDueno = gui.getSeleccion(opcionRegistroLogin);
                    switch (inicioDueno.trim()) {
                        case "exit":
                            gui.despedida();
                            System.exit(0);
                            break;
                        case "Registrarme":
                            controlDueno.registrarDueno();
                            break;
                        case "Logearme":
                            Optional<Dueno> duenoLogeado = controlDueno.loginDueno();
                            while (duenoLogeado.isPresent()) {
                                String opcionDueno = gui.getSeleccion(opcionDuenoLogeado);
                                switch (opcionDueno.trim()) {
                                    case "exit":
                                        gui.despedida();
                                        System.exit(0);
                                        break;
                                    case "Logout":
                                        duenoLogeado = Optional.empty();
                                        gui.mensajeLogout();
                                        break;
                                    case "ListarMascotas":
                                        controlDueno.listarMascotas(duenoLogeado.get());
                                        break;
                                    case "AltaMascota":
                                        Mascota mascotaregistrada = controladorMascota.registrarMascota();
                                        if (mascotaregistrada != null) {
                                            controlDueno.agregarMascota(duenoLogeado.get(), mascotaregistrada);
                                        }
                                        break;
                                    case "AltaMascotaExotica":
                                        MascotaExotica mascotaExoticaRegistrada = controladorMascotaExotica.registrarMascotaExotica();
                                        if (mascotaExoticaRegistrada != null) {
                                            controlDueno.agregarMascotaExotica(duenoLogeado.get(), mascotaExoticaRegistrada);
                                        }
                                        break;
                                    default:
                                        gui.errorComando(opcionDueno);
                                }

                            }
                            break;
                        default:
                            gui.errorComando(inicioDueno);
                    }
                }
            } else {
                gui.errorComando(inicioUsuario);
            }


        }
    }
}
