public class FilaPedidos {
    private No inicio;
    private No fim;

    public FilaPedidos() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    // Adiciona um pedido no final da fila
    public void enqueue(Pedido pedido) {
        No novoNo = new No(pedido);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
    }

    // Remove um pedido do início da fila
    public Pedido dequeue() {
        if (isEmpty()) {
            return null;
        }
        Pedido pedidoRemovido = inicio.getPedido();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null; // A fila ficou vazia
        }
        return pedidoRemovido;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Fila de pedidos pendentes está vazia.");
            return;
        }
        System.out.println("--- Fila de Pedidos Pendentes ---");
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.getPedido());
            atual = atual.getProximo();
        }
        System.out.println("---------------------------------");
    }
}