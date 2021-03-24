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
    private int[] solucion;
    private ArrayList<Boolean> validas;
    private ArrayList<int []> restricciones;
    private int cantidadRestr;
    private int[] cartas;
    private String[] nombres = {"Mejor amigo","El novio","El vecino","El mensajero","El extraño","El hermanastro","El colega",
                                    "Pistola","Cuchillo","Machete","Pala","Bate","Botella","Tubo","Cuerda","Venganza","Celos","Dinero",
                                    "Accidente","Drogas","Robo","Cabeza","Pecho","Abdomen","Espalda","Piernas","Brazos","Sala","Comedor",
                                    "Baño","Terraza","Cuarto","Garage","Patio","Balcón","Cocina"};
    private Boolean[] logicBF;
    private Boolean[] logicBT;
    private int[] guessBF;
    private int[] guessBT;
    public Juego(){
        juegoCartas = new ArrayList<> ();
        solucion = new int[5];
        validas = new ArrayList<> ();
        /*sospechoso = new ArrayList<> ();
        arma = new ArrayList<> ();
        parteCuerpo = new ArrayList<> ();
        lugar = new ArrayList<> ();
        motivo = new ArrayList<> ();*/
        restricciones = new ArrayList<>();
        cartas = new int[36];
        cantidadRestr = 5; //Aqui vamos a enlazarlo con la GUI para determinar la cantidad de restricciones.
        logicBT = new Boolean[36];
        logicBF = new Boolean[36]; // estos arreglos son para ver qué carta pueden usar aún
        guessBF = new int[5];
        guessBT = new int[5];
        
        System.out.println("Empieza juego");
        iniciarDatos();
        obtenerRestriccion(cantidadRestr);
        buscarRespuesta();
        System.out.println("La respuesta dada por correcta es: "+nombres[solucion[0]]+" con "+nombres[solucion[1]]+" por "+nombres[solucion[2]]+" en el/la "+nombres[solucion[3]]+" en el/la "+nombres[solucion[4]]);        
        fuerzaBruta();
    }
    
    public void fuerzaBruta(){
        for (int sospechoso = 0; sospechoso < 7; sospechoso++) {
            for (int arma = 0; arma < 8; arma++) {
                for (int motivo = 0; motivo < 6; motivo++) {
                    for (int parteC = 0; parteC < 6; parteC++) {
                        for (int lugar = 0; lugar < 9; lugar++) {
                            if (sospechoso==solucion[0] && arma+7 ==solucion[1] && motivo+15==solucion[2] && parteC+21==solucion[3] && lugar+27==solucion[4]) {
                                System.out.println("La respuesta dada por el Brute Force es: "+nombres[sospechoso]+" con "+nombres[arma+7]+" por "+nombres[motivo+14]+" en el/la "+nombres[parteC+20]+" en el/la "+nombres[lugar+26]);
                                return;
                            }
                        }
                    }
                }
            }
        }
        /*
        do {            
            sospechoso = (int) (Math.random() * 7);
        } while (!logicBF[sospechoso]);
        do {            
            arma = (int) (Math.random() * 8);
            arma += 7;
        } while (!logicBF[arma]);
        do {            
            motivo = (int) (Math.random() * 6);
            motivo += 15;
        } while (!logicBF[motivo]);
        do {            
            parteCuerpo = (int) (Math.random() * 6);
            parteCuerpo += 21;
        } while (!logicBF[parteCuerpo]);
        do {            
            lugar = (int) (Math.random() * 9);
            lugar += 27;
        } while (!logicBF[lugar]);
        */
        /*
        if (pguessBF[0]==solucion[0] && pguessBF[1] ==solucion[1] && pguessBF[2]==solucion[2] && pguessBF[3]==solucion[3] && pguessBF[4]==solucion[4]) {
            System.out.println("La respuesta dada por el Brute Force es: "+nombres[pguessBF[0]]+" con "+nombres[pguessBF[1]+7]+" por "+nombres[pguessBF[2]+14]+" en el/la "+nombres[pguessBF[3]+20]+" en el/la "+nombres[pguessBF[4]+26]);
        }
        else {
            if (pguessBF[0]>6) {
                return;
            }
            if (pguessBF[1]>7||pguessBF[2]>5||pguessBF[3]>5||pguessBF[4]>8) {
                int aux = pguessBF[0];
                pguessBF
                fuerzaBruta(pguessBF);
            }
        }*/
    }
    public void iniciarDatos(){
        for (int i = 0; i < 36; i++) {
            cartas[i]= i;
            logicBT[i]=Boolean.TRUE;
            logicBF[i]=Boolean.TRUE;
        }
        for (int i = 0; i < 5; i++) {
            guessBF[i]=0;
            guessBT[i]=0;
        }
        
    }
    public void buscarRespuesta(){
        int numero;
        do {
            numero = (int) (Math.random() * 7);
            solucion[0] = numero;
            numero = (int) (Math.random() * 8);
            solucion[1] = numero+7;
            numero = (int) (Math.random() * 6);
            solucion[2] = numero + 15;
            numero = (int) (Math.random() * 6);
            solucion[3] = numero + 21;
            numero = (int) (Math.random() * 9);
            solucion[4] = numero +27;
        } while (!solucionValida());
    }
    public boolean solucionValida(){
        for (int i = 0; i < restricciones.size(); i++) {
            int[] rest = restricciones.get(i);
            if (rest[0]==solucion[0] || rest[0]==solucion[1] || rest[0]==solucion[2]|| rest[0]==solucion[3] || rest[0]==solucion[4]) {
                if (rest[1]==solucion[0] || rest[1]==solucion[1] || rest[1]==solucion[2]|| rest[1]==solucion[3] || rest[1]==solucion[4]) {
                    return false;   
                }
            }
        }
        return true;
    }
    public boolean revisarRestriccion(int num1, int num2){
        
        if ((num1<7 && num2<7)||(6<num1 && num1<15 && 6<num2 && num2<15)||(14<num1 && num1<21 && 14<num2 && num2<21)||(20<num1 && num1<27 && 20<num2 && num2<27)||(26<num1 && num1<36 && 26<num2 && num2<36)) {
            return false;
        }
        for (int i = 0; i < restricciones.size(); i++) {
            int [] get = restricciones.get(i);
            if ((get[0] == num1 && get[1] == num2) || (get[1] == num1 && get[0] == num2))
                return false;
        }
        return true;
    }
    public void obtenerRestriccion(int cant){
        int primeroR;
        int segundoR;
        int[] rest = new int[2];
        for (int i = 0; i < cant; i++) {
            primeroR = (int) (Math.random() * 36);
            segundoR = (int) (Math.random() * 36);
            while (!revisarRestriccion(primeroR, segundoR)){
                primeroR = (int) (Math.random() * 36);
                segundoR = (int) (Math.random() * 36);
            }
            rest[0] = primeroR;
            rest[1] = segundoR;
            restricciones.add(rest);
        }
        
    }
}
