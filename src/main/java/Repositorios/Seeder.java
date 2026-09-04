package Repositorios;

import DiagramaDeClases.Cuidador;
import DiagramaDeClases.Dueno;
import DiagramaDeClases.Mascota;
import DiagramaDeClases.MascotaExotica;


public class Seeder {
    private final CuidadorRepositorio cuidadorRepositorio;
    private final DuenoRepositorio duenoRepositorio;
    private final MascotaRepositorio mascotaRepositorio;
    private final MascotaExoticaRepositorio mascotaExoticaRepositorio;

    public Seeder(CuidadorRepositorio cuidadorRepositorio, DuenoRepositorio duenoRepositorio, MascotaRepositorio mascotaRepositorio, MascotaExoticaRepositorio mascotaExoticaRepositorio) {
        this.cuidadorRepositorio = cuidadorRepositorio;
        this.duenoRepositorio = duenoRepositorio;
        this.mascotaRepositorio = mascotaRepositorio;
        this.mascotaExoticaRepositorio = mascotaExoticaRepositorio;

    }

    public void seed() {
        Cuidador[] cuidadores = {
                new Cuidador("Juan", "juan@upm.es", "123", "calle Valencia", "buen cuidador", 12, 10.5f, "Licencia", "ES523479678931", "Si"),
                new Cuidador("Carlos", "carlos@upm.es", "123", "calle Segovia", "buen cuidador", 10, 20.5f, "Licencia", "ES523479678381", "No"),
                new Cuidador("Daniel", "daniel@upm.es", "123", "calle Palencia", "buen cuidador", 9, 13.0f, "Licencia", "ES523479671235", "No"),
        };
        for (int i = 0; i < cuidadores.length; i++) {
            this.cuidadorRepositorio.create(cuidadores[i]);
        }
        Dueno[] duenos = {
                new Dueno("Jose Juan", "josejuan@gmail.com", "123456", "Calle Baleares"),
                new Dueno("Javier", "javier@gmail.com", "123456", "Calle Tenerife"),
                new Dueno("Roberto", "roberto@gmail.com", "123456", "Calle Bilbao"),
        };
        for (int i = 0; i < duenos.length; i++) {
            this.duenoRepositorio.create(duenos[i]);
        }
        Mascota[] mascotas = {
                new Mascota(1234567890L, "Morci", "agresivo", "calle Baleares", 16263801, "gato"),
                new Mascota(1234567891L, "Cookie", "tranquilo", "calle Baleares", 16263801, "canario"),
                new Mascota(1234567892L, "Rex", "algo agresivo", "calle Bilbao", 16263801, "perro"),
        };
        for (int i = 0; i < mascotas.length; i++) {
            this.mascotaRepositorio.create(mascotas[i]);
        }
        MascotaExotica[] mascotasExoticas = {
                new MascotaExotica(1234567880L, "Galletita", "peligrosa", "calle Tenerife", 1212132, "caiman", "A1212233211", "1212313123YX", "EX61722"),
                new MascotaExotica(1234567881L, "flan", "escurridiza", "calle Bilbao", 1212132, "boa", "B1217378311", "32324123XD", "BCV82992"),

        };
        for (int i = 0; i < mascotasExoticas.length; i++) {
            this.mascotaExoticaRepositorio.create(mascotasExoticas[i]);
        }
        duenos[0].agregarMascota(mascotas[0]);
        duenos[0].agregarMascota((mascotas[1]));
        duenos[2].agregarMascota(mascotas[2]);
        duenos[1].agregarMascotaExotica(mascotasExoticas[0]);
        duenos[2].agregarMascotaExotica(mascotasExoticas[1]);
        cuidadores[0].agregarMascota(mascotas[0]);
        cuidadores[0].agregarDueno(duenos[0]);
        duenos[0].agregarCuidador(cuidadores[0]);
    }
}
