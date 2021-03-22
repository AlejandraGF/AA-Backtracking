/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Alejandra G
 */
public class Juego {
    private ArrayList<String> juegoCartas;
    private int numRestriccion;
    private int[] solucion;
    private ArrayList<Integer> sospechoso;
    private ArrayList<Integer> arma;
    private ArrayList<Integer> parteCuerpo;
    private ArrayList<Integer> lugar;
    private ArrayList<Integer> motivo;
    private ArrayList<Boolean> validas;
    private ArrayList<int []> restricciones;
    private int cantidadRestr;
    private int[] cartas;
    private String[] nombres = {"Mejor amigo","El novio","El vecino","El mensajero","El extraño","El hermanastro","El colega",
                                    "Pistola","Cuchillo","Machete","Pala","Bate","Botella","Tubo","Cuerda","Venganza","Celos","Dinero",
                                    "Accidente","Drogas","Robo","Cabeza","Pecho","Abdomen","Espalda","Piernas","Brazos","Sala","Comedor",
                                    "Baño","Terraza","Cuarto","Garage","Patio","Balcón","Cocina"};
    public Juego(){
        juegoCartas = new ArrayList<> ();
        solucion = new int[5];
        validas = new ArrayList<> ();
        sospechoso = new ArrayList<> ();
        arma = new ArrayList<> ();
        parteCuerpo = new ArrayList<> ();
        lugar = new ArrayList<> ();
        motivo = new ArrayList<> ();
        restricciones = new ArrayList<>();
        cartas = new int[36];
        
        cantidadRestr = 50; //Aqui vamos a enlazarlo con la GUI para determinar la cantidad de restricciones.
        
        iniciarDatos();
        obtenerRestriccion(cantidadRestr);
        buscarRespuesta();
    }
      
    public void iniciarDatos(){
        for (int i = 0; i < 36; i++) {
            cartas[i]= i;
        }
        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            juegoCartas.add(nombre);
            
        }
        for (int i = 0; i < 7; i++) {
            sospechoso.add(i);
        }
        for (int i = 0; i < 8; i++) {
            arma.add(i);
        }
        for (int i = 0; i < 6; i++) {
            motivo.add(i);
        }
        for (int i = 0; i < 6; i++) {
            parteCuerpo.add(i);
        }
        for (int i = 0; i < 9; i++) {
            lugar.add(i);
        }
    }
    public void buscarRespuesta(){
        int numero = (int) (Math.random() * 7);
        solucion[0] = sospechoso.get(numero);
        numero = (int) (Math.random() * 8);
        solucion[1] = arma.get(numero);
        numero = (int) (Math.random() * 6);
        solucion[2] = motivo.get(numero);
        numero = (int) (Math.random() * 6);
        solucion[3] = parteCuerpo.get(numero);
        numero = (int) (Math.random() * 9);
        solucion[4] = lugar.get(numero);        
    }
    public boolean revisarRestriccion(int num1, int num2){
        for (int i = 0; i < restricciones.size(); i++) {
            int [] get = restricciones.get(i);
            if (get[0] == num1 && get[1] == num2)
                return false;
            if (get[1] == num1 && get[2] == num2)
                return false;
        }
        return true;
    }
    public void obtenerRestriccion(int cant){
        int primeroR;
        int segundoR;
        int primero;
        int segundo;
        int contador = 0;
        for (int i = 0; contador < cant; i++) {
            int numero = (int) (Math.random() * 36);
            
        }
    }
}
