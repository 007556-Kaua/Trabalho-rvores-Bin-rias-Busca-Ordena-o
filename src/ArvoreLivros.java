public class ArvoreLivros {

    private No raiz;

    public void inserir(Livro livro) {
        raiz = inserirRec(raiz, livro);
    }

    private No inserirRec(No atual, Livro livro) {
        if (atual == null)
            return new No(livro);

        if (livro.compareTo(atual.livro) < 0)
            atual.esquerda = inserirRec(atual.esquerda, livro);
        else if (livro.compareTo(atual.livro) > 0)
            atual.direita = inserirRec(atual.direita, livro);

        return atual;
    }

    public Livro buscar(String titulo) {
        return buscarRec(raiz, titulo);
    }

    private Livro buscarRec(No atual, String titulo) {

        if (atual == null)
            return null;

        int comp = titulo.compareToIgnoreCase(atual.livro.getTitulo());

        if (comp == 0)
            return atual.livro;

        if (comp < 0)
            return buscarRec(atual.esquerda, titulo);

        return buscarRec(atual.direita, titulo);
    }

    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No atual) {
        if (atual != null) {
            emOrdemRec(atual.esquerda);
            System.out.println(atual.livro);
            emOrdemRec(atual.direita);
        }
    }

    public void preOrdem() {
        preOrdemRec(raiz);
    }

    private void preOrdemRec(No atual) {
        if (atual != null) {
            System.out.println(atual.livro);
            preOrdemRec(atual.esquerda);
            preOrdemRec(atual.direita);
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
    }

    private void posOrdemRec(No atual) {
        if (atual != null) {
            posOrdemRec(atual.esquerda);
            posOrdemRec(atual.direita);
            System.out.println(atual.livro);
        }
    }

    public void remover(String titulo) {
        raiz = removerRec(raiz, titulo);
    }

    private No removerRec(No atual, String titulo) {

        if (atual == null)
            return null;

        int comp = titulo.compareToIgnoreCase(atual.livro.getTitulo());

        if (comp < 0)
            atual.esquerda = removerRec(atual.esquerda, titulo);
        else if (comp > 0)
            atual.direita = removerRec(atual.direita, titulo);
        else {

            if (atual.esquerda == null)
                return atual.direita;

            if (atual.direita == null)
                return atual.esquerda;

            No sucessor = atual.direita;

            while (sucessor.esquerda != null)
                sucessor = sucessor.esquerda;

            atual.livro = sucessor.livro;

            atual.direita = removerRec(atual.direita,
                    sucessor.livro.getTitulo());
        }

        return atual;
    }
}