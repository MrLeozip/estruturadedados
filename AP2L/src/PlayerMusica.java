import java.util.Scanner;

public class PlayerMusica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        // Adicionando algumas músicas para começar
        playlist.adicionarMusicaNoFim(new Musica("Bohemian Rhapsody", "Queen", "A Night at the Opera", 355));
        playlist.adicionarMusicaNoFim(new Musica("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301));
        playlist.adicionarMusicaNoFim(new Musica("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482));
        playlist.adicionarMusicaNoFim(new Musica("Anna Julia", "Los Hermanos", "Los Hermanos", 205));

        int opcao = 0;
        while (opcao != 8) {
            System.out.println("\n--- Bem-vindo ao seu Gerenciador de Músicas! ---");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist (por Título ou Artista)");
            System.out.println("4. Tocar música atual");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        playlist.proximaMusica();
                        break;
                    case 2:
                        playlist.musicaAnterior();
                        break;
                    case 3:
                        System.out.print("Ordenar por (1) Título ou (2) Artista? ");
                        int sortOption = Integer.parseInt(scanner.nextLine());
                        if (sortOption == 1) {
                            playlist.ordenarPorTitulo();
                        } else if (sortOption == 2) {
                            playlist.ordenarPorArtista();
                        } else {
                            System.out.println("Opção de ordenação inválida.");
                        }
                        playlist.listarMusicas();
                        break;
                    case 4:
                        playlist.tocarMusica();
                        break;
                    case 5:
                        System.out.print("Título da música: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Artista: ");
                        String artista = scanner.nextLine();
                        System.out.print("Álbum: ");
                        String album = scanner.nextLine();
                        System.out.print("Duração (em segundos): ");
                        int duracao = Integer.parseInt(scanner.nextLine());
                        playlist.adicionarMusicaNoFim(new Musica(titulo, artista, album, duracao));
                        break;
                    case 6:
                        playlist.listarMusicas();
                        System.out.print("Digite o número da música a ser removida: ");
                        int pos = Integer.parseInt(scanner.nextLine());
                        playlist.removerMusica(pos);
                        break;
                    case 7:
                        playlist.listarMusicas();
                        break;
                    case 8:
                        System.out.println("Saindo do programa. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                opcao = 0; // Reseta
            }
        }
        scanner.close();
    }
}