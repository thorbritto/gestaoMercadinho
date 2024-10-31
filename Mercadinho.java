import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mercadinho {
    private final List<Cliente> clientes;
    private final List<Produto> produtos;
    private int proximoId;
    private int idProduto;

    public Mercadinho() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
        this.idProduto = 1;
    }

    // Métodos de Clientes
    public void cadastrarCliente(Scanner scanner) {
        System.out.println("Cadastro de novo cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(proximoId++, nome, cpf, endereco);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com o ID: " + cliente.getId());
    }

    public void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public void editarCliente(Scanner scanner) {
        exibirClientes();
        System.out.println("Informe o id do cliente que deseja editar as informações: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteEncontrado = buscarClientePorId(id);

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        System.out.println("Cliente encontrado: " + clienteEncontrado);
        System.out.println("Selecione o campo que deseja editar:");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Endereço");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Informe o novo nome: ");
                String novoNome = scanner.nextLine();
                clienteEncontrado.setNome(novoNome);
                break;

            case 2:
                System.out.println("Informe o novo CPF: ");
                String novoCpf = scanner.nextLine();
                clienteEncontrado.setCpf(novoCpf);
                break;

            case 3:
                System.out.println("Informe o novo endereço: ");
                String novoEndereco = scanner.nextLine();
                clienteEncontrado.setEndereco(novoEndereco);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("Dados do cliente atualizados com sucesso");
        exibirClientes();
    }

    public void excluirCliente(Scanner scanner) {
        exibirClientes();
        System.out.println("Informe o id do cliente que você deseja deletar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteEncontrado = buscarClientePorId(id);

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        System.out.println("Cliente encontrado: " + clienteEncontrado);
        System.out.println("Confirma a exclusão? (S/N)");
        String confirmacao = scanner.nextLine().trim().toUpperCase();

        if (confirmacao.equals("S")) {
            clientes.remove(clienteEncontrado);
            System.out.println("Cliente deletado com sucesso!");
        } else {
            System.out.println("Exclusão cancelada!");
        }
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        System.out.println("Cliente com ID " + id + " não encontrado.");
        return null;
    }

    // Métodos de Produtos
    public void cadastrarProduto(Scanner scanner) {
        System.out.println("Cadastro de novo produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Setor: ");
        String setor = scanner.nextLine();
        System.out.print("Preço de custo: ");
        double precoCusto = scanner.nextDouble();
        System.out.print("Preço de venda: ");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha

        Produto produto = new Produto(idProduto++, nome, setor, precoCusto, precoVenda);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public void editarProduto(Scanner scanner) {
        exibirProdutos();
        System.out.println("Informe o id do produto em que deseja editar as informações: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = buscarProdutoPorId(id);

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Produto encontrado: " + produtoEncontrado.getId());
        System.out.println("Selecione o campo que deseja editar:");
        System.out.println("1 - Nome");
        System.out.println("2 - Setor");
        System.out.println("3 - Preço de Custo");
        System.out.println("4 - Preço de Venda");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Informe o novo nome do produto: ");
                String novoNome = scanner.nextLine();
                produtoEncontrado.setNome(novoNome);
                break;

            case 2:
                System.out.println("Informe o novo setor: ");
                String novoSetor = scanner.nextLine();
                produtoEncontrado.setSetor(novoSetor);
                break;

            case 3:
                System.out.println("Informe o novo preço de custo: ");
                double novoPrecoCusto = scanner.nextDouble();
                produtoEncontrado.setPrecoCusto(novoPrecoCusto);
                break;

            case 4:
                System.out.println("Informe o novo preço de venda: ");
                double novoPrecoVenda = scanner.nextDouble();
                produtoEncontrado.setPrecoVenda(novoPrecoVenda);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("Dados do produto atualizado com sucesso.");
        exibirProdutos();
    }

    public void excluirProduto(Scanner scanner) {
        exibirProdutos();
        System.out.println("Informe o id do produto em que você deseja deletar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = buscarProdutoPorId(id);

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado");
            return;
        }

        System.out.println("Produto encontrado: " + produtoEncontrado);
        System.out.println("Confirma a exclusão? (S/N)");
        String confirmacao = scanner.nextLine().trim().toUpperCase();

        if (confirmacao.equals("S")) {
            produtos.remove(produtoEncontrado);
            System.out.println("Produto deletado com sucesso!");
        } else {
            System.out.println("Exclusão cancelada!");
        }
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
        return null;
    }

    // Métodos de Estatísticas
    public void exibirLucroDosProdutos() {
        System.out.println("Lucro dos produtos cadastrados:");
        for (Produto produto : produtos) {
            double lucro = produto.calcularLucro();
            System.out.printf("Produto: %s - Lucro: R$%.2f\n", produto.getNome(), lucro);
        }
    }

    public void compararProdutosPorSetor() {
        System.out.println("Comparação de produtos por setor:");
        for (Produto produto : produtos) {
            double margemLucro = produto.calcularLucro() / produto.getPrecoCusto() * 100;
            System.out.printf("Produto: %s - Setor: %s - Margem de Lucro: %.2f%%\n",
                    produto.getNome(), produto.getSetor(), margemLucro);
        }
    }

    // Método para calcular o frete
    public double calcularFrete(double valorCompra, Cliente cliente) {
        // Lógica simples para calcular o frete. Você pode adaptar conforme necessário.
        double taxaFixa = 5.0; // taxa fixa de frete
        double taxaPorValor = 0.1; // 10% do valor da compra
        double frete = taxaFixa + (taxaPorValor * valorCompra);
        return frete;
    }
}

