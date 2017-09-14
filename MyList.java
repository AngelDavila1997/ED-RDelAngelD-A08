/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.list;

/**
 *
 * @author A01411440
 * @param <T>
 */
public class MyList <T>{
    Node first;
    Node last;
    Node pointer;
    //Constructor
    MyList(){
        this.first = null;
        this.last = null;
        pointer = null;
    }
    MyList(T d){
        Node node = new Node(d);
        first = node;
        last = node;
        node.next = null;
    }
    //Metodos
    public boolean isEmpty(){
        return this.first==null;
    }
    //Inserta al inicio de la lista
    public void insertFirst(T n){
        //Siempre crear el nodo
        Node node = new Node(n);
        if(isEmpty()){//Si esta vacia           
            first = node;
            last = node;
            node.next = null;
        }else{//Caso lista con elementos
            node.next = first;
            first = node;
        }
    }
    //Inserta al final de la lista
    public void insertLast(T n){
        Node node = new Node(n);
        if(isEmpty()){
            first = node;
            last = node;
            node.next = null;
        }else{
            last.next = node;
            last = node;
        }
    }
    //Eliminar al principio
    public void deleteFirst(){
        if(!isEmpty()){
            if(first.next == null){//Si la lista solo tiene un elemento
                first = null;
                last = null;
            }else{//Si la lista tiene mas de un elemento
                first = first.next;
            }
        }
        System.out.println("The list is empty");
    }
    //Eliminar al final
    public void deletaLast(){
        if(!isEmpty()){
            if(first == last){//Si la lista solo tiene un elemento (porque apuntan al mismo elemento)
                first = last = null;
            }else{//Buscamos dentro del arreglo
                pointer = first; //Se coloca en el primer sitio para recorar
                while(pointer.next != last){//Recorre la lista y se detiene en el elemento anterior al ultimo
                    pointer = pointer.next;
                }
                last = pointer;
                last.next = null;
                pointer = null;
            }
        }
    }
    //Eliminar nodo
    public boolean deleteNode(T n){
        Node p = fetchBack(n);
        if(p != null){//Si encuentra el elemento
            if(p.data == n){//Si fue el primero o el unico elemento de la lista
            deleteFirst();
             }else{//Si esta dentro de la lista
                 p.next = p.next.next;
            }
            return true;
        }
        return false;
    }
    
        
    public Node fetch(T n){//Estamos buscando el nodo
        //Si no está vacía la lista
        if(!isEmpty()){
            if(first.data == n){//Si el dato que busco es el primer dato
                return first;//Regreso primero
            } 
            Node p = fetchBack(n); //Se crea un nodo p en donde se busca el dato y regresa el nodo anterior
            if(p!=null){ //Si no es nulo
                if(p.data != n){ //Si el dato dentro de p es diferente al dato buscado
                    return p.next; //Se regresa el nodo siguiente a n (ya que este es el que se busca)
                }
            }
        }
        return null;//Si no regresa nulo
    } 
    //Buscar nodo anterior
    public Node fetchBack(T n){
        if(!isEmpty()){
            if(first == last){//Si la lista tiene solo un elemento
                if(first.data == n){//Si es que este nodo resulta ser el elemento que busco
                    return first;//Se devuelve a si mismo
                }else{
                    return null;//Si no es el que busco regreso nulo
                }
              }else{//Si hay mas elementos en la lista
                    if(first.data == n){//El elemento que busco es el primero
                        return first;
                    }else{//Este te regresa uno anterior al que estas buscando (contiene datos)
                        pointer = first;//Se coloca en el primer sitio para recorar
                        while(pointer.next != null){//Mientras que pointer no llegue al final de la lista(diferente al ultimo)
                            if(pointer.next.data == n){//Si el dato del nodo siguiente es el que estoy buscando
                            return pointer;//regreso el puntero
                            }
                        pointer = pointer.next;//Avanzo al siguiente puntero
                        }
                    }
            }
        }
        return null;
    }

}
