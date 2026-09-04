package Vistas;

import java.util.Scanner;

public abstract class VistaGenerica {
    private static Scanner S = new Scanner(System.in);


    public static Scanner getS() {
        return S;
    }
    public static Scanner getSComandos() {
        System.out.print("> ");
        return S;
    }

}
