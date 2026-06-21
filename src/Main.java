import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArvoreLivros arvore = new ArvoreLivros();

        arvore.inserir(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        arvore.inserir(new Livro("O Hobbit", "J. R. R. Tolkien", 1937));
        arvore.inserir(new Livro("1984", "George Orwell", 1949));
        arvore.inserir(new Livro("Harry Potter", "J. K. Rowling", 1997));
        arvore.inserir(new Livro("Capitaes da Areia", "Jorge Amado", 1937));
        arvore.inserir(new Livro("O Pequeno Principe", "Saint-Exupery", 1943));
        arvore.inserir(new Livro("Memorias Postumas", "Machado de Assis", 1881));
        arvore.inserir(new Livro("A Revolucao dos Bichos", "George Orwell", 1945));

        int op;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir Livro");
            System.out.println("2 - Buscar Livro");
            System.out.println("3 - Remover Livro");
            System.out.println("4 - Em Ordem");
            System.out.println("5 - Pre Ordem");
            System.out.println("6 - Pos Ordem");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();

                    arvore.inserir(new Livro(titulo, autor, ano));
                    System.out.println("Livro inserido!");
                    break;

                case 2:
                    System.out.print("Titulo: ");
                    titulo = sc.nextLine();

                    Livro livro = arvore.buscar(titulo);

                    if (livro != null)
                        System.out.println(livro);
                    else
                        System.out.println("Livro nao encontrado!");
                    break;

                case 3:
                    System.out.print("Titulo: ");
                    titulo = sc.nextLine();

                    arvore.remover(titulo);
                    System.out.println("Livro removido!");
                    break;

                case 4:
                    arvore.emOrdem();
                    break;

                case 5:
                    arvore.preOrdem();
                    break;

                case 6:
                    arvore.posOrdem();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (op != 0);

        sc.close();
    }
}