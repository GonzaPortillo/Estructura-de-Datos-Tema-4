public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        String expresion = "a+b*c-d/e";
        String postfix = arbol.infixToPostfix(expresion);
        Nodo raiz = arbol.construirArbol(postfix);
    
        System.out.println("Recorrido en preorden del árbol:");
        arbol.preOrden(raiz);
    
        System.out.println("Recorrido en inorden del árbol:");
        arbol.inOrden(raiz);
    
        System.out.println("Recorrido en postorden del árbol:");
        arbol.postOrden(raiz);
    
        System.out.println("De infix a postfix:");
        System.out.print(arbol.infixToPostfix("a+b*c-d/e"));
    }
}
