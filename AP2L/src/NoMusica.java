public class NoMusica {
    Musica musica;
    NoMusica proximo;
    NoMusica anterior;

    public NoMusica(Musica musica) {
        this.musica = musica;
        this.proximo = null;
        this.anterior = null;
    }
}
