public class Playlist {
    private NoMusica inicio;
    private NoMusica fim;
    private NoMusica musicaAtual;
    private int tamanho;

    public Playlist() {
        this.inicio = null;
        this.fim = null;
        this.musicaAtual = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void adicionarMusicaNoFim(Musica musica) {
        NoMusica novoNo = new NoMusica(musica);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
            musicaAtual = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        tamanho++;
        System.out.println("Música adicionada: " + musica.titulo);
    }

    public void listarMusicas() {
        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }
        System.out.println("\n--- Playlist Atual ---");
        NoMusica aux = inicio;
        int i = 1;
        while (aux != null) {
            System.out.println(i + ". " + aux.musica);
            aux = aux.proximo;
            i++;
        }
        System.out.println("----------------------");
    }

    public void tocarMusica() {
        if (musicaAtual == null) {
            System.out.println("Nenhuma música para tocar. A playlist está vazia ou não foi iniciada.");
        } else {
            System.out.println("\n▶ Tocando agora: " + musicaAtual.musica);
        }
    }

    public void proximaMusica() {
        if (musicaAtual != null && musicaAtual.proximo != null) {
            musicaAtual = musicaAtual.proximo;
            tocarMusica();
        } else {
            System.out.println("Esta é a última música da playlist.");
        }
    }

    public void musicaAnterior() {
        if (musicaAtual != null && musicaAtual.anterior != null) {
            musicaAtual = musicaAtual.anterior;
            tocarMusica();
        } else {
            System.out.println("Esta é a primeira música da playlist.");
        }
    }

    public void removerMusica(int posicao) {
        if (estaVazia() || posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida ou playlist vazia.");
            return;
        }

        NoMusica noParaRemover = inicio;
        for (int i = 1; i < posicao; i++) {
            noParaRemover = noParaRemover.proximo;
        }

        System.out.println("Música removida: " + noParaRemover.musica.titulo);

        if (noParaRemover == musicaAtual) {
            if(musicaAtual.proximo != null) musicaAtual = musicaAtual.proximo;
            else musicaAtual = musicaAtual.anterior;
        }

        if (noParaRemover.anterior != null) {
            noParaRemover.anterior.proximo = noParaRemover.proximo;
        } else {
            inicio = noParaRemover.proximo;
        }

        if (noParaRemover.proximo != null) {
            noParaRemover.proximo.anterior = noParaRemover.anterior;
        } else {
            fim = noParaRemover.anterior;
        }

        if(inicio == null) musicaAtual = null;

        tamanho--;
    }

    // Método de ordenação simples (Bubble Sort) por título
    public void ordenarPorTitulo() {
        if (tamanho < 2) return;

        boolean trocou;
        do {
            NoMusica atual = inicio;
            trocou = false;
            while (atual.proximo != null) {
                if (atual.musica.titulo.compareToIgnoreCase(atual.proximo.musica.titulo) > 0) {
                    // Troca os dados das músicas entre os nós
                    Musica temp = atual.musica;
                    atual.musica = atual.proximo.musica;
                    atual.proximo.musica = temp;
                    trocou = true;
                }
                atual = atual.proximo;
            }
        } while (trocou);
        System.out.println("Playlist ordenada por título.");
    }

    // Método de ordenação simples (Bubble Sort) por artista
    public void ordenarPorArtista() {
        if (tamanho < 2) return;

        boolean trocou;
        do {
            NoMusica atual = inicio;
            trocou = false;
            while (atual.proximo != null) {
                if (atual.musica.artista.compareToIgnoreCase(atual.proximo.musica.artista) > 0) {
                    Musica temp = atual.musica;
                    atual.musica = atual.proximo.musica;
                    atual.proximo.musica = temp;
                    trocou = true;
                }
                atual = atual.proximo;
            }
        } while (trocou);
        System.out.println("Playlist ordenada por artista.");
    }
}