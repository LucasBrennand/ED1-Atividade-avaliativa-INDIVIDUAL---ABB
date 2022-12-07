package br.unicap.edi;

public class Queue<T> {

    private LSENode<T> topo;
    private LSENode<T> ultimo;

    public boolean isEmpty() {
        if (this.topo == null) {
            System.out.println("Vazio");
            return true;
        }
        else {
            System.out.println("Não tá vazio");
            return false;
        }
    }
    public void enQueue (T valor) {  // inserir no final (ultimo)
        LSENode novo, aux;
        novo = new LSENode(valor);
        if (this.isEmpty() == true) {
            this.topo = novo;
        } else {
            aux = this.topo;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novo);
        }
    }

    public boolean isFull () {
        System.out.println("Não tá cheio");
        return false;
    }
    public T deQueue() {
        LSENode<T> aux = this.topo;
        this.topo = this.topo.getProx();
        return aux.getInfo();
    }
    public T head() {
        System.out.println(topo.getInfo());
        return this.topo.getInfo();
    }

    public void exibir() {
        LSENode aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        } else {
            aux = this.topo;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }
}