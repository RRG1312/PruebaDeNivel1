import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Diccionario {

    private HashMap<Character, LinkedList<String>> tablaHash;
    private String url;

    public Diccionario() {
        this.tablaHash = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            this.tablaHash.put(c, new LinkedList<String>());
        }
    }

    public void agregarPalabra(String palabra) {
        char primeraLetra = palabra.toLowerCase().charAt(0);
        String datoAux = palabra.toLowerCase();
        LinkedList<String> aux = new LinkedList<>();
        if (this.tablaHash.get(primeraLetra)==null) {
            this.tablaHash.put(primeraLetra,new LinkedList<String>());
            aux = this.tablaHash.get(primeraLetra);
            aux.add(datoAux);
        }else{
            aux = this.tablaHash.get(primeraLetra);
            aux.add(datoAux);
        }

        this.tablaHash.put(primeraLetra,aux);
    }


    public boolean buscarPalabra(String palabra) {
        char primeraLetra = palabra.toLowerCase().charAt(0);

        LinkedList<String> palabrasConLetra = this.tablaHash.get(primeraLetra);
        return palabrasConLetra.contains(palabra);
    }


    public void leerArchivo(String nombreArchivo) throws IOException {
        this.url=nombreArchivo;
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] palabras = linea.split(",");
            agregarPalabra(palabras[0]);
        }
        br.close();
    }

    public void mostrarDiccionario(){
        try {
            // Crea una instancia de File y Scanner
            File archivo = new File(this.url);
            Scanner scanner = new Scanner(archivo);

            // Lee el archivo línea por línea
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] palabras = linea.split(",");
                // Procesa la línea de texto
                System.out.println(palabras[0]);
            }

            // Cierra el Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }
    }
}
