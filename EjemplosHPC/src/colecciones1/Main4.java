
import java.util.HashMap;
import java.util.Map;

public class Main4 {

    public static void main(String[] args) {
// HashMap con claves string y valores double
        HashMap<String, Double> mapa = new HashMap<>();
// agregar elementos al HashMap
        mapa.put("nota1", 3.2);
        mapa.put("nota2", 4.3);
        mapa.put("nota3", 3.9);
// cantidad de elementos en el HashMap
        System.out.println("Tama~no: " + mapa.size());
// impresion del HashMap
        System.out.println("HashMap 1: " + mapa);
// verificacion de llave y extraccion de valor
        if (mapa.containsKey("nota2")) {
            Double valor = mapa.get("nota2");
            System.out.println("nota 2 === " + valor);
        }
        mapa.remove("nota1");
        System.out.println("HashMapFinal:");
// recorrer HashMap por llave y clave
        for (Map.Entry<String, Double> elem : mapa.entrySet()) {
            System.out.println(elem.getKey() + " : " + elem.getValue());
        }
    }   
}
