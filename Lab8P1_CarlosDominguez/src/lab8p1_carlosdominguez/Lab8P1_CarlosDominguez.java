//Fila3,asiento11
package lab8p1_carlosdominguez;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Lab8P1_CarlosDominguez {
    
    static Scanner sc = new Scanner (System.in);
    static Random rm = new Random ();
    static ArrayList<String> coordenadas = new ArrayList<>();
    
    public static void main(String[] args) {
        boolean resp = true;
        while (resp == true){
            System.out.println("********MENU*********");
            System.out.println("1. Game of life");
            System.out.println("2. Salir");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1 : {
                    Lab8P1_CarlosDominguez game = new Lab8P1_CarlosDominguez();
                    int columnas = 10;
                    int filas = 10;
                    int [][] llenadoinicial = llenadorandom(filas,columnas);
                    System.out.println("Cordenadas de celulas vivas :");
                    for (int i = 0;i<llenadoinicial.length;i++){
                        for(int j = 0;j<llenadoinicial[i].length;j++){
                            switch (j) {
                                case 0:
                                    if (llenadoinicial [i][j] == 1){
                                        System.out.print("("+Arrays.toString(llenadoinicial[i])+ ":"+ Arrays.toString(llenadoinicial[j])+",");
                                    }    
                                    break;
                                case 9:
                                    if (llenadoinicial [i][j] == 1){
                                        System.out.print(Arrays.toString(llenadoinicial[i])+ ":"+ Arrays.toString(llenadoinicial[j])+")");
                                    }   
                                    break;
                                default:
                                    if (llenadoinicial [i][j] == 1){
                                        System.out.print(Arrays.toString(llenadoinicial[i])+ ":"+ Arrays.toString(llenadoinicial[j])+",");
                                    }
                                    break;
                            }
                        }
                        System.out.println("");
                    }     
                    System.out.println("Tablero Inicial :");
                    print (llenadoinicial);
                    System.out.println("");
                    System.out.println("Ingrese el numero de rondas :");
                    int x = sc.nextInt();
                    int [][] revisadodespues;
                    int [][] revisadoaunmasdespues;
                    revisadodespues = revisadoactual(llenadoinicial);
                    for (int z = 1 ; z<x+1; z++){
                        System.out.println("Ronda " + z + " :");
                        print (revisadodespues);
                        revisadoaunmasdespues = revisadodespues;
                        revisadodespues = revisadoaunmasdespues;
                    }
                    System.out.println("");
                    System.out.println("Termino la simulacion");
                    System.out.println("");
                    break;
                }
                case 2 : {
                    System.out.println("Saliendo....");
                    resp = false;
                    break;
                }
                default : {
                    System.out.println("Ingrese 1 o 2");
                    break;
                }
            }   
        }   
    }//menu inicial
    
    public void game (int x){
        System.out.println("prueba");
    
    }
    public void jugar (int x){
        
        for (int i = 0;i < x;i++){
            
        }
    }
    
    
    public static void print (int [][] inicial){
        for (int i = 0;i<inicial.length;i++){
            for(int j = 0;j<inicial[i].length;j++){
                System.out.print("["+inicial[i][j]+"]");
            }
            System.out.println("");
        }     
    }
    
    public static int[][] llenadorandom (int filas, int columnas){
        int temporal [][] = new int [filas][columnas];
        for (int i = 0;i<temporal.length; i++){
            for (int j = 0;j<temporal[i].length;j++){
                if ( i == 0 || i == 9 || j == 0 || j == 9){
                    temporal [i][j] = 0;
                }else {
                    temporal[i][j] = rm.nextInt((1-0)+1);   
                }
            }    
        }
        return temporal;
    }
    public static int[][] revisadoactual (int[][]llenadoinicial){
        for (int i = 0;i<llenadoinicial.length; i++){
            for (int j = 0;j<llenadoinicial[i].length;j++){
                if (llenadoinicial [i][j] !=0 && llenadoinicial[i-1][j]== 0 && llenadoinicial [i+1][j] == 0 && llenadoinicial [i][j+1]==0 && llenadoinicial [i][j-1] == 0 && llenadoinicial [i+1][j+1] == 0 && llenadoinicial [i-1][j-1] == 0 && llenadoinicial [i+1][j-1]==0 && llenadoinicial [i-1][j+1]== 0){
                    llenadoinicial [i][j] = 0;
                }else if (llenadoinicial [i][j] !=0 &&(llenadoinicial[i-1][j]== 1 && llenadoinicial [i+1][j] == 1 && llenadoinicial [i][j+1]==1) && llenadoinicial [i][j-1] == 0 && llenadoinicial [i+1][j+1] == 0 && llenadoinicial [i-1][j-1] == 0 && llenadoinicial [i+1][j-1]==0 && llenadoinicial [i-1][j+1]== 0){
                    llenadoinicial [i][j] = 1;
                }else if (llenadoinicial [i][j] !=0 &&(llenadoinicial[i-1][j]== 0 && llenadoinicial [i+1][j] == 0 && llenadoinicial [i][j+1]==0)&&llenadoinicial [i][j-1] == 0 && llenadoinicial [i+1][j+1] == 0 && llenadoinicial [i-1][j-1] == 0 && llenadoinicial [i+1][j-1]==0 && llenadoinicial [i-1][j+1]== 0){
                    llenadoinicial [i][j] = 0;
                }else if (llenadoinicial [i][j] !=0 &&(llenadoinicial[i-1][j]== 1 && llenadoinicial [i+1][j] == 0) && (llenadoinicial [i][j+1]==1 && llenadoinicial [i][j-1] == 0) && (llenadoinicial [i+1][j+1] == 1 && llenadoinicial [i-1][j-1] == 0) && (llenadoinicial [i+1][j-1]==1 && llenadoinicial [i-1][j+1]== 0)){
                    llenadoinicial [i][j] = 0;
                }else if (llenadoinicial [i][j] !=0 &&(llenadoinicial[i-1][j]== 0 && llenadoinicial [i+1][j] == 0 && llenadoinicial [i][j+1]==0) && llenadoinicial [i][j-1] == 1 && llenadoinicial [i+1][j+1] == 0 && llenadoinicial [i-1][j-1] == 1 && llenadoinicial [i+1][j-1]==0 && llenadoinicial [i-1][j+1]== 0){
                    llenadoinicial [i][j]= 1; 
                }
            }    
        }
        return llenadoinicial;
    }
   /* public void play(int x) {
        
    }

    public static class Arraylist {

        public Arraylist() {
            
        }
    }
    */
}
