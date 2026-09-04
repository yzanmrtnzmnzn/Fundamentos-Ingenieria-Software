package Controladores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import Controladores.ControlCuidador;
import DiagramaDeClases.Cuidador;
import DiagramaDeClases.Dueno;
import DiagramaDeClases.Mascota;
import Repositorios.CuidadorRepositorio;
import Repositorios.DuenoRepositorio;
import Repositorios.Repositorios_Map.CuidadorRepositorio_Map;
import Repositorios.Repositorios_Map.DuenoRepositorio_Map;
import Vistas.VistaCuidador;

public class ControlCuidadorTest {

    private ControlCuidador controlCuidador;
    private CuidadorRepositorio cuidadorRepositorio;
    private DuenoRepositorio duenoRepositorio;

    @BeforeEach
    public void setUp() {
        this.cuidadorRepositorio= new CuidadorRepositorio_Map();
        this.duenoRepositorio= new DuenoRepositorio_Map();
        this.controlCuidador = new ControlCuidador(cuidadorRepositorio,duenoRepositorio);
    }

}
