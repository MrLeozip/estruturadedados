import java.util.Scanner;

public class SistemaCafeteria {
    public static void main(String[] args) {
        FilaPedidos filaPendentes = new FilaPedidos();
        PilhaPedidos pilhaCancelados = new PilhaPedidos();
        Scanner scanner = new Scanner(System.in);
        int idPedidoCounter = 1;

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("\n--- Sistema de Pedidos da Cafeteria ---");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido Cancelado");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a descrição do pedido: ");
                        String desc = scanner.nextLine();
                        Pedido novoPedido = new Pedido(idPedidoCounter++, desc);
                        filaPendentes.enqueue(novoPedido);
                        System.out.println("Pedido " + novoPedido.getId() + " adicionado à fila.");
                        break;
                    case 2:
                        Pedido pedidoAtendido = filaPendentes.dequeue();
                        if (pedidoAtendido != null) {
                            System.out.println("Pedido atendido: " + pedidoAtendido);
                        } else {
                            System.out.println("Não há pedidos para atender.");
                        }
                        break;
                    case 3:
                        Pedido pedidoACancelar = filaPendentes.dequeue();
                        if (pedidoACancelar != null) {
                            pilhaCancelados.push(pedidoACancelar);
                            System.out.println("Pedido cancelado: " + pedidoACancelar);
                        } else {
                            System.out.println("Não há pedidos para cancelar.");
                        }
                        break;
                    case 4:
                        Pedido pedidoRestaurado = pilhaCancelados.pop();
                        if (pedidoRestaurado != null) {
                            filaPendentes.enqueue(pedidoRestaurado);
                            System.out.println("Pedido restaurado para a fila: " + pedidoRestaurado);
                        } else {
                            System.out.println("Não há pedidos cancelados para restaurar.");
                        }
                        break;
                    case 5:
                        filaPendentes.printQueue();
                        break;
                    case 6:
                        pilhaCancelados.printStack();
                        break;
                    case 7:
                        System.out.println("Encerrando o sistema.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                opcao = 0; // Reseta a opção para continuar no loop
            }
        }
        scanner.close();
    }
}