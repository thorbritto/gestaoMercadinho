import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mercadinho mercadinho = new Mercadinho();

        int opcao;
        do {
            System.out.println("\n----- Sistema do Mercadinho -----");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Editar cliente");
            System.out.println("3. Excluir cliente");
            System.out.println("4. Exibir clientes cadastrados");
            System.out.println("5. Cadastrar produto");
            System.out.println("6. Editar produto");
            System.out.println("7. Excluir produto");
            System.out.println("8. Exibir produtos cadastrados");
            System.out.println("9. Calcular frete para cliente");
            System.out.println("10. Exibir lucro de cada produto");
            System.out.println("11. Comparar produtos por setor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    mercadinho.cadastrarCliente(scanner);
                    break;
                case 2:
                    mercadinho.editarCliente(scanner);
                    break;
                case 3:
                    mercadinho.excluirCliente(scanner);
                    break;
                case 4:
                    mercadinho.exibirClientes();
                    break;
                case 5:
                    mercadinho.cadastrarProduto(scanner);
                    break;
                case 6:
                    mercadinho.editarProduto(scanner);
                    break;
                case 7:
                    mercadinho.excluirProduto(scanner);
                    break;
                case 8:
                    mercadinho.exibirProdutos();
                    break;
                case 9:
                    calcularFreteParaCliente(scanner, mercadinho);
                    break;
                case 10:
                    mercadinho.exibirLucroDosProdutos();
                    break;
                case 11:
                    mercadinho.compararProdutosPorSetor();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void calcularFreteParaCliente(Scanner scanner, Mercadinho mercadinho) {
        System.out.print("Informe o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = mercadinho.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Informe o valor da compra: ");
        double valorCompra = scanner.nextDouble();
        
        double frete = mercadinho.calcularFrete(valorCompra, cliente);
        System.out.printf("O valor do frete para o cliente %s é: R$%.2f\n", cliente.getNome(), frete);
    }
}