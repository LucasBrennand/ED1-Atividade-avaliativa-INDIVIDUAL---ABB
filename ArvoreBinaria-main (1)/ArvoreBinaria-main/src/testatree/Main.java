package testatree;
import br.unicap.edi.cadastros.CadastroProdutos;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        CadastroProdutos listaProdutos = new CadastroProdutos<>();

        int op;
        do {
            menu();
            op = in.nextInt();
            switch (op){
                case 1:
                    listaProdutos.CadastrarProduto();
                    break;
                case 2:
                    listaProdutos.ExibirDadosProduto();
                    break;
                case 3:
                    listaProdutos.ExibirTodosProdutos();
                    break;
                case 4:
                    listaProdutos.AlterarPreco();
                    break;
                case 5:
                    listaProdutos.AlterarEstoque();
                    break;
                case 6:
                    listaProdutos.RemoverProduto();
                    break;
                case 0:
                    System.out.println("Você saiu");
                    break;
                default: System.out.println("Opção inválida, digite novamente");
            }
        } while (op != 0);
    }

    public static void menu () {
        System.out.println("Escolha uma opção: \n"+
                "1 - Cadastrar um produto \n"+
                "2 - Exibir dados de um produto \n"+
                "3 - Exibir todos os produtos da lista \n"+
                "4 - Alterar o preço de um produto \n"+
                "5 - Alterar o estoque de um produto \n"+
                "6 - Remover um produto \n"+
                "0 - Sair");
    }
}