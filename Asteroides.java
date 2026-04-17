
public class Asteroides {

    public static void main(String[] args) {
        int[] arregloAsteroides = {5, 10, -5};
        TDAStack<Integer> stack = new ListStack<Integer>();

        for(int i = 0; i < arregloAsteroides.length; i++) {
            // Caso "Cero": Si no hay asteroides, pushea lo que sea al stack
            // este caso es obvio al inicio del juego pero tambien se da el
            // caso que el stack se quede vacio durante el juego, pero hay mas
            // asteroides que llegan del arreglo de asteroides, tambien hay que
            // pushear lo que sea
            if(stack.isEmpty()) {
                stack.push(arregloAsteroides[i]);
            } else {
                // Primer caso: Si el top del stack es negativo significa que
                // este asteroide ya se fue a la izquierda y no puede chocar,
                // lo pusheamos
                if(stack.top() < 0) {
                    stack.push(arregloAsteroides[i]);
                } else {
                    //Segundo caso: Si tenemos asteroide positivo en el top del
                    //stack y metemos otro positivo no pasa nada simplemente se
                    //pushea al stack
                    if(arregloAsteroides[i] > 0) {
                        stack.push(arregloAsteroides[i]);
                    } else {
                        // Tercer caso: Aqui ya podemos tener colisiones porque
                        // el top es positivo pero el nuevo asteroide es
                        // negativo, primero revisamos que el nuevo asteroide
                        // sea igual o mas grande que el top porque si es mas
                        // chico entonces el grande gana y no se pushea
                        if(stack.top() <= Math.abs(arregloAsteroides[i])) {
                            // Si tienen las misma magnitud entonces popeamos
                            // el ultimo asteroide del stack y no pusheamos el
                            // nuevo asteroide
                            if(stack.top() == Math.abs(arregloAsteroides[i])) {
                                stack.pop();
                            } else {
                                // Aqui mientras que nuevo asteroide sea mas
                                // grande que los que estan en el stack, los
                                // vamos popeando
                                while(!stack.isEmpty()) {
                                    if(stack.top() < Math.abs(arregloAsteroides[i])){
                                        stack.pop();
                                    }
                                }
                                // Si el stack no esta vacio significa que
                                // algun asteroide de nuestro stack 'gano', de
                                // lo contrario todos perdieron y el stack
                                // estara vacio y agregamos el nuevo asteroide
                                if(stack.isEmpty()){
                                    stack.push(arregloAsteroides[i]);
                                }
                            }
                        }
                    }
                }
            }
        }

        //Todo esto es solo para poder imprimer el array final
        String asteroides = "";
        while(!stack.isEmpty()) {
            asteroides += stack.pop() + ", ";
        }
        String[] arregloTemp = asteroides.split(", ");
        String[] arregloFinal = new String[arregloTemp.length];
        for(int i = arregloTemp.length - 1; i >= 0; i--) {
            arregloFinal[arregloTemp.length - 1 - i] = arregloTemp[i];
        }
        String mensajeFinal = "[";
        for(String t : arregloFinal) {
            mensajeFinal += t + ", ";
        }
        mensajeFinal = mensajeFinal.substring(0, mensajeFinal.length() - 2) + "]";
        System.out.println(mensajeFinal);

    }

}
