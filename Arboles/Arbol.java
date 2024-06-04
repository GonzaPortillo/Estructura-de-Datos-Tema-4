class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor);
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }

    void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.print(nodo.valor);
            inOrden(nodo.derecha);
        }
    }

    void PostOrden(Nodo nodo) {
        if (nodo != null){
            PostOrden(nodo.izquierda);
            PostOrden(nodo.derecha);
            System.out.print(nodo.valor);
        }
    }

    public Nodo construirArbol(String postfix) {
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo, izquierda, derecha;

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                nodo = new Nodo(c);
                pila.push(nodo);
            } else {
                nodo = new Nodo(c);
                derecha = pila.pop();
                izquierda = pila.pop();
                nodo.derecha = derecha;
                nodo.izquierda = izquierda;
                pila.push(nodo);
                nodo = pila.peek();
                pila.pop();
            }
        }
        return nodo;
    }
}
