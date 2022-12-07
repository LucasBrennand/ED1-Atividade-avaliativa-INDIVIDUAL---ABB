package br.unicap.edi.trees;

import br.unicap.edi.Queue;
import br.unicap.edi.trees.Node;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> raiz;

    public void inserir(T valor) {
        Node<T> aux, novo;
        novo = new Node(valor);
        if (this.isEmpty() == true) {
            this.raiz = novo;
            System.out.println("Inserção efetuada");
        } else {
            aux = this.raiz;
            while (true) {
                if (valor.compareTo(aux.getInfo()) == 0) {
                    System.out.println("Valor repetido. Inserção não efetuada");
                    break;
                } else if (valor.compareTo(aux.getInfo()) < 0) { // inserção do lado esquerdo
                    if (aux.getLeft() != null) {
                        aux = aux.getLeft();
                    } else { // inserir
                        aux.setLeft(novo);
                        System.out.println("Inserção efetuada");
                        break;
                    }
                } else {  // inserção do lado direito
                    if (aux.getRight() != null) {
                        aux = aux.getRight();
                    } else { // inserir
                        aux.setRight(novo);
                        System.out.println("Inserção efetuada");
                        break;
                    }
                }
            }
        }
    }

    public T buscar(T valor) {
        Node<T> aux;
        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.raiz;
            while (aux != null) {
                if (valor.compareTo(aux.getInfo()) == 0) {
                    return aux.getInfo();
                } else if (valor.compareTo(aux.getInfo()) < 0) {
                    aux = aux.getLeft();
                } else {
                    aux = aux.getRight();
                }
            }
            return null;
        }
    }

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(T value) {
        if (this.isEmpty() == true) {
            this.raiz = new Node(value);
        } else {
            this.raiz.insertNode(value);
        }
    }

    public void emOrdem () {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            percorrerEmOrdem (this.raiz);
        }
    }

    public void preOrdem () {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            percorrerPreOrdem (this.raiz);
        }
    }
    public void posOrdem () {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            percorrerPosOrdem (this.raiz);
        }
    }
    private void percorrerEmOrdem (Node<T> r) {
        if (r != null) {
            percorrerEmOrdem (r.getLeft());
            System.out.println(r.getInfo());
            percorrerEmOrdem (r.getRight());
        }
    }
    private void percorrerPreOrdem (Node<T> r) {
        if (r != null) {
            System.out.println(r.getInfo());
            percorrerPreOrdem (r.getLeft());
            percorrerPreOrdem (r.getRight());
        }
    }
    private void percorrerPosOrdem (Node<T> r) {
        if (r != null) {
            percorrerPosOrdem (r.getLeft());
            percorrerPosOrdem (r.getRight());
            System.out.println(r.getInfo());
        }
    }

    public T find (T value) {
        if (this.isEmpty() == true) {
            return null;
        }
        else {
            return this.raiz.findNode (value);
        }
    }

    public void passeioPorNivel () {
        Queue<Node<T>> fila;
        Node<T> aux;
        if (this.isEmpty() == false) {
            fila = new Queue();
            fila.enQueue (raiz);
            while (fila.isEmpty () == false) {
                aux = fila.deQueue();
                if (aux.getLeft() != null) {
                    fila.enQueue(aux.getLeft());
                }
                if (aux.getRight() != null) {
                    fila.enQueue(aux.getRight());
                }
                System.out.println(aux.getInfo());
            }
        }
    }

    public void remove(T value) {
        if (this.isEmpty() == true) {
            System.out.println ("Árvore vazia!");
        }
        else {
            this.raiz = this.removeNode (this.raiz, value);
        }
    }

    private Node<T> removeNode (Node<T> r, T value) {
        if (r != null) {
            if (value.compareTo( r.getInfo()) == 0) {
                Node<T> pai, filho;
                if (r.getLeft() == null && r.getRight() == null) {
                    r = null;
                } else if (r.getLeft() == null) {
                    r = r.getRight();
                } else if (r.getRight() == null) {
                    r = r.getLeft();
                } else {
                    pai = r;
                    filho = pai.getLeft();
                    while (filho.getRight() != null) {
                        pai = filho;
                        filho = filho.getRight();
                    }
                    pai.setRight(filho.getLeft());
                    r.setInfo(filho.getInfo());
                }
            }
            else if (value.compareTo( r.getInfo()) < 0) {
                r.setLeft(removeNode (r.getLeft(), value));
            }
            else {
                r.setRight(removeNode (r.getRight(), value));
            }
        }
        return r;
    }

}