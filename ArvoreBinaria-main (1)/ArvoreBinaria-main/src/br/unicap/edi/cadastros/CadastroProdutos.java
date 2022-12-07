package br.unicap.edi.cadastros;
import br.unicap.edi.informacao.Produto;
import br.unicap.edi.trees.BinaryTree;
import br.unicap.edi.informacao.Produto;
import java.util.Scanner;
public class CadastroProdutos<T extends Comparable<T>> {
    private BinaryTree<Produto> lista;

    public CadastroProdutos() {
        lista = new BinaryTree();
    }

    public void CadastrarProduto() {
        Scanner in = new Scanner(System.in);
        Produto prod;
        String descricao, codigo, fornecedor;
        int estoque;
        double preco;
        System.out.print("Informe a descrição do produto: ");
        descricao = in.nextLine();
        System.out.print("Informe o código do produto: ");
        codigo = in.nextLine();
        System.out.println("Informe o fornecedor do produto");
        fornecedor = in.nextLine();
        System.out.println("Informe o preco do produto");
        preco = in.nextDouble();
        System.out.println("Informe o estoque do produto");
        estoque = in.nextInt();
        prod = new Produto(codigo, descricao, fornecedor, preco, estoque);
        lista.insert(prod);
    }

    public void AlterarPreco() {
        Scanner in = new Scanner(System.in);
        Produto prod, retorno;
        String codigo;
        double preco;
        System.out.print("Informe o código do produto: ");
        codigo = in.nextLine();
        prod = new Produto(codigo);
        retorno = lista.find(prod);
        if (retorno == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println("Dados do produto");
            System.out.println(retorno);
            System.out.print("Informe o novo preço do produto: ");
            preco = in.nextDouble();
            retorno.setPreco(preco);
            System.out.println("Preço alterado");
            System.out.println("Dados após a alteração");
            System.out.println(retorno);
        }
    }
    public void AlterarEstoque() {
        Scanner in = new Scanner(System.in);
        Produto prod, retorno;
        String codigo;
        int estoque;
        System.out.print("Informe o código do produto: ");
        codigo = in.nextLine();
        prod = new Produto(codigo);
        retorno = lista.find(prod);
        if (retorno == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println("Dados do produto");
            System.out.println(retorno);
            System.out.print("Informe o novo estoque do produto: ");
            estoque = in.nextInt();
            retorno.setEstoque(estoque);
            System.out.println("Estoque alterado");
            System.out.println("Dados após a alteração");
            System.out.println(retorno);
        }
    }

    public void ExibirDadosProduto() {
        Scanner in = new Scanner(System.in);
        Produto prod, retorno;
        String codigo;
        System.out.print("Informe o código do produto: ");
        codigo = in.nextLine();
        prod = new Produto(codigo);
        retorno = lista.find(prod);
        if (retorno == null) {
            System.out.println("Produto não encontrado");
        } else {
            System.out.println("Dados do produto");
            System.out.println(retorno);
        }
    }

    public void ExibirTodosProdutos() {
        if (this.lista.isEmpty() == true) {
            System.out.println("Lista vazia");
        } else {
            this.lista.emOrdem();
        }
    }

    public void RemoverProduto() {
        Scanner in = new Scanner(System.in);
        Produto prod, retorno;
        String codigo;
        if (this.lista.isEmpty() == true) {
            System.out.println("Lista vazia");
        } else {
            System.out.print("Informe o código do produto: ");
            codigo = in.nextLine();
            prod = new Produto(codigo);
            retorno = lista.find(prod);
            if (retorno == null) {
                System.out.println("Produto não encontrado");
            } else {
                this.lista.remove(retorno);
            }
        }
    }
}