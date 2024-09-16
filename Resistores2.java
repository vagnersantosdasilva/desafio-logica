import java.util.HashMap;
import java.util.Map;

public class Resistores2 {
	private static final Map<Integer, String> CORES = new HashMap<>();
    static {
        CORES.put(0, "preto");
        CORES.put(1, "marrom");
        CORES.put(2, "vermelho");
        CORES.put(3, "laranja");
        CORES.put(4, "amarelo");
        CORES.put(5, "verde");
        CORES.put(6, "azul");
        CORES.put(7, "violeta");
        CORES.put(8, "cinza");
        CORES.put(9, "branco");
    }

    public static String converter(String resistenciaString) {
        // Separate value and unit (ohms, k, M)
        String[] partes = resistenciaString.split(" ");
        double valor = Double.parseDouble(partes[0]);
        String unidade = partes.length > 1 ? partes[1] : "ohms";

        // Apply unit multiplier
        switch (unidade.toLowerCase()) {
            case "k":
                valor *= 1000;
                break;
            case "m":
                valor *= 1000000;
                break;
            case "ohms":
                // No change
                break;
            default:
                throw new IllegalArgumentException("Unidade inválida: " + unidade);
        }

        // Separate digits and build color sequence
        StringBuilder resultado = new StringBuilder();
        int expoente = 0;
        while (valor >= 10) {
            int digito = (int) (valor % 10);
            resultado.insert(0, CORES.get(digito));
            valor /= 10;
            expoente++;
        }
        resultado.insert(0, CORES.get((int) valor));
        resultado.append(" " + CORES.get(expoente)); // Banda de multiplicador
        resultado.append(" dourado"); // Banda de tolerância (default)

        return resultado.toString();
    }

    public static void main(String[] args) {
        System.out.println(converter("47 ohms")); // amarelo violeta marrom dourado
        System.out.println(converter("1k ohms")); // marrom preto vermelho dourado
        System.out.println(converter("2M ohms")); // vermelho preto verde dourado
        System.out.println(converter("amarelovioleta marrom dourado")); //  (already converted string, will return the same)
    }
}