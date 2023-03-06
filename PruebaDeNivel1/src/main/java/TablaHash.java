import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

public class TablaHash {
    private HashMap<Integer, LinkedList<String>> tabla;

    public TablaHash(int tamanio) {
        this.tabla = new HashMap<>();
        for (int i = 0; i <tamanio ; i++) {
            tabla.put(i,new LinkedList<String>());
        }
    }

    public void agregarPalabra(String dato) {
        String datoAux = dato.toLowerCase();
        int posicion = funcion_hash(datoAux);
        LinkedList<String> aux = new LinkedList<>();
        if (this.tabla.get(posicion)==null) {
            this.tabla.put(posicion,new LinkedList<String>());
             aux = this.tabla.get(posicion);
             aux.add(datoAux);
        }else{
            aux = this.tabla.get(posicion);
            aux.add(datoAux);
        }
        this.tabla.put(posicion,aux);
    }

    public void quitarPalabra(String dato) {
        String datoAux = dato.toLowerCase();
        int posicion = funcion_hash(datoAux);
        LinkedList<String> aux = new LinkedList<>();
        if (this.tabla.get(posicion) != null) {
            aux = this.tabla.get(posicion);
            aux.remove(datoAux);
            this.tabla.put(posicion,aux);
        }
    }

    public int[] buscarPalabra(String dato) {
        int[] posiciones = {-1,-1};
        int posicion = funcion_hash(dato);
        if (this.tabla.get(posicion) != null) {
            for (int i = 0; i < this.tabla.get(posicion).size(); i++) {
                if (this.tabla.get(posicion).get(i).equals(dato)) {
                    posiciones[0]=posicion;
                    posiciones[1]=i;
                    return posiciones;
                }
            }
        }
        return posiciones;
    }

    public int funcion_hash(String dato) {
        String datoAux = dato.toLowerCase();
        int valorHash = 0;
        for (int i = 0; i < dato.length(); i++) {
            valorHash += datoAux.charAt(i);
        }
        return valorHash % this.tabla.size();
    }

    public int sondeo(int posicion) {
        int nueva_posicion = (posicion + 1) % this.tabla.size();
        int i = 2;
        while (nueva_posicion != posicion && this.tabla.get(i) != null) {
            nueva_posicion = (posicion + i) % this.tabla.size();
            i++;
        }
        return nueva_posicion;
    }

    public int cantidad_elementos() {
        int elementos = 0;

        for (int i = 0; i <tabla.size() ; i++) {
            if(this.tabla.get(i)!=null){
                elementos+=this.tabla.get(i).size();
            }
        }
        return elementos;
    }

    // Aquí podrías incluir la función de lectura del archivo CSV o de texto


}
