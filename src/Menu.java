import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1. Adicionar um novo contato");
            System.out.println("2. Remover um contato existente");
            System.out.println("3. Buscar um contato pelo nome");
            System.out.println("4. Atualizar informacoes de um contato");
            System.out.println("5. Listar todos os contatos na agenda");
            System.out.println("6. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Numero de telefone: ");
                    String numeroTelefone = scanner.nextLine();

                    Contato novoContato = new Contato(nome, numeroTelefone);
                    if (agenda.buscarContato(nome) == null) {
                        agenda.adicionarContato(novoContato);
                        System.out.println("Contato adicionado com sucesso.");
                    } else {
                        System.out.println("Contato com o mesmo nome ja existe na agenda.");
                    }
                    break;
                case 2:
                    System.out.print("Nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                    System.out.println("Contato removido com sucesso.");
                    break;
                case 3:
                    System.out.print("Nome do contato a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();
                    Contato contatoEncontrado = agenda.buscarContato(nomeBuscar);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado: " + contatoEncontrado);
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do contato a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    Contato contatoExistente = agenda.buscarContato(nomeAtualizar);
                    if (contatoExistente != null) {
                        System.out.print("Novo nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Novo numero de telefone: ");
                        numeroTelefone = scanner.nextLine();

                        Contato novoContatoAtualizado = new Contato(nome, numeroTelefone);
                        agenda.atualizarContato(nomeAtualizar, novoContatoAtualizado);
                        System.out.println("Contato atualizado com sucesso.");
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Contatos na agenda:");
                    agenda.listarContatos();
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}