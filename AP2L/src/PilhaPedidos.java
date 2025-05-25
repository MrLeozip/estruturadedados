public class PilhaPedidos {
    private No topo;

    public PilhaPedidos() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    // Adiciona um pedido no topo da pilha
    public void push(Pedido pedido) {
        No novoNo = new No(pedido);
        novoNo.setProximo(topo);
        topo = novoNo;
    }

    // Remove um pedido do topo da pilha
    public Pedido pop() {
        if (isEmpty()) {
            return null;
        }
        Pedido pedidoRemovido = topo.getPedido();
        topo = topo.getProximo();
        return pedidoRemovido;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Pilha de pedidos cancelados está vazia.");
            return;
        }
        System.out.println("--- Pilha de Pedidos Cancelados ---");
        No atual = topo;
        while (atual != null) {
            System.out.println(atual.getPedido());
            atual = atual.getProximo();
        }

    }
}