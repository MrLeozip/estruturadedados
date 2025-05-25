public class Pedido {
    private int id;
    private String descricao;

    public Pedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Pedido{ID=" + id + ", Descrição='" + descricao + "'}";
    }
}
