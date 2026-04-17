
public class Validador {

    public static boolean isHTMLMatched(String html) {
        TDAStack<String> stack = new ListStack<String>();
        int i = 0;
        int n = html.length();

        while (i < n) {
            // Buscar el inicio de una etiqueta '<'
            int inicio = html.indexOf('<', i);
            if (inicio == -1) break; // No hay más etiquetas
            // Buscar el cierre de la etiqueta '>'
            int fin = html.indexOf('>', inicio + 1);
            if (fin == -1) return false; // Etiqueta mal formada
            // Extraer el contenido entre '<' y '>'
            String etiqueta = html.substring(inicio, fin + 1);
            // Determinar si es etiqueta de cierre (comienza con "</")
            if (etiqueta.startsWith("</")) {
                // Es una etiqueta de cierre
                String nombre = etiqueta.substring(2, etiqueta.length() - 1).trim();
                if (stack.isEmpty()) {
                    return false; // Cierre sin apertura correspondiente
                }
                String tope = stack.pop();
                if (!tope.equals(nombre)) {
                    return false; // El cierre no coincide con la última etiqueta abierta
                }
            } else {
                // Es una etiqueta de apertura (ignoramos atributos para simplificar)
                String nombre = etiqueta.substring(1, etiqueta.length() - 1).trim();
                stack.push(nombre);
            }
            i = fin + 1; // Continuar después del '>'
        }
        // Si la stack está vacía, todas las etiquetas están balanceadas
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] pruebas = {
            "<body><h1></h1><p></p><p></p><h1></h1></body>",
            "<body><h1></h1><p></p><p></p><h1></h1></body>", // según el enunciado este da false (posible errata)
            "<body></h1><p></p><p></p><h1></h1></body>",
            "<body><h1></body></h1><p></p><p></p><h1></h1>"
        };

        boolean[] esperados = {true, false, false, false};

        for (int i = 0; i < pruebas.length; i++) {
            boolean resultado = isHTMLMatched(pruebas[i]);
            System.out.println("Prueba " + (i+1) + ": " + resultado +
                               (resultado == esperados[i] ? " (OK)" : " (ERROR)"));
        }
    }
}
