import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    private static TablaHash tabla ;
    private static Diccionario dic = new Diccionario();
    public void init() throws IOException {
        int opcion = 0;
        while(opcion!=6) {


            System.out.println("1. Crear lista");
            System.out.println("2. Agregar palabra");
            System.out.println("3. Eliminar palabra");
            System.out.println("4. Buscar palabra");
            System.out.println("5. Mostrar diccionario");
            System.out.println("6. Salir");


            Scanner teclado = new Scanner(System.in);
            opcion = teclado.nextInt();
            String palabra;
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Dime el tamaño de la lista");
                    int tamanio = teclado.nextInt();
                    tabla = new TablaHash(tamanio);
                    break;
                case 2:
                    System.out.println("Dime la palabra a añadir");
                    palabra = teclado.nextLine();
                    tabla.agregarPalabra(palabra);
                    break;
                case 3:
                    System.out.println("Dime la palabra a eliminar");
                    palabra = teclado.nextLine();
                    tabla.quitarPalabra(palabra);
                    break;
                case 4:
                    System.out.println("Dime la palabra a buscar");
                    palabra = teclado.nextLine();
                    int[] posiciones = tabla.buscarPalabra(palabra);
                    if (posiciones[0] != -1 && posiciones[1] != -1) {
                        System.out.println(posiciones[0] + " " + posiciones[1]);
                    } else {
                        System.out.println("No se ha encontrado");
                    }

                    break;
                case 5:
                    dic.leerArchivo("src\\palabras.csv");
                    dic.mostrarDiccionario();
                    break;
                default:
                    System.out.println("No has elegido una opcion");
                    break;
            }
        }
    }
}
