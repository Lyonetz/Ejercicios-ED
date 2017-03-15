package PatronComponente;

import java.util.ArrayList;

abstract class Fichero {

    //Creamos una variable protected nombre, para que pueda ser accedida desde todas las subclases de fichero.
    //También declaramos los métodos abstractos 'add' 'remove' y 'print', que serán implementados en las subclases.
    //Creamos un método getNombre(), que nos devolverá el nombre del objeto componente que lo llame.
    protected String nombre;
    public abstract void add(Fichero componente);
    public abstract void remove(Fichero componente);
    public abstract void print();

    public String getNombre() {
        return nombre;
    }

}

class FicheroSimple extends Fichero {

    //Constructor de FicheroSimple. Tiene como parámetro de entrada el nombre que tendrá dicho fichero que queramos crear.
    public FicheroSimple(String nombre) {
        this.nombre = nombre;
    }

    //Implementamos el cuerpo del método 'add' que lo hereda de Fichero. En este caso la clase FicheroSimple no lo usa, por lo que lanzamos
    //una excepción que nos informa de ello. Lo mismo para el método 'remove'.
    //El método que sí usamos es el print, el cuál devolverá el nombre del fichero por medio de la función getNombre().
    @Override
    public void add(Fichero componente) {
        throw new UnsupportedOperationException("No se pueden añadir elementos a elementos hoja.");
    }

    @Override
    public void remove(Fichero componente) {
        throw new UnsupportedOperationException("Los elementos hoja no tienen elementos por debajo de la jerarquía.");
    }

    @Override
    public void print() {
        System.out.print("Fichero Simple: " + getNombre() + "\n");
    }
}

class Directorio extends Fichero {
    //Creamos un arrayList de tipo Fichero, el cual almacenará todos los ficheros que dicho contenedor contiene.
    private ArrayList<Fichero> ficheros;

    //Constructor de Directorio. Como parámetro de entrada tendremos que introducir el nombre de éste.
    public Directorio(String nombre) {
        this.nombre = nombre;
        ficheros = new ArrayList<>();
    }

    //Implementamos el cuerpo de los métodos 'add' 'remove' y 'print'.
    //En el caso de 'add' y 'remove', lo que hacemos es añadir/eliminar el fichero que nos llega como parámetro de entrada al arrayList que creamos antes.
    //El método 'print' imprime el nombre del directorio y, a continuación, todos los ficheros que contienen el arrayList de dicho directorio.
    //Esto último lo hacemos mediante un bucle 'foreach', el cual llama al método 'print' para cada uno de los ficheros que contienen el arrayList.
    @Override
    public void add(Fichero fichero) {
        ficheros.add(fichero);
    }

    @Override
    public void remove(Fichero fichero) {
        ficheros.remove(fichero);
    }

    @Override
    public void print() {
        System.out.print("Directorio: " + getNombre() + "\n");
        for(Fichero fichero : ficheros){
            fichero.print();
        }
    }
}

public class Ficheros {

    public static void main(String[] args) {

        //Creamos el directorio 'root'. Éste contendrá a los directorios 'home' 'opt' 'usr'
        Fichero root = new Directorio("root");

        //Creamos dichos directorios, los cuales tendrán ficheros simples en su interior.
        Fichero home = new Directorio("home");
        Fichero opt  = new Directorio("opt");
        Fichero usr = new Directorio("usr");

        //Añadimos al directorio 'root' los directorios 'home' 'opt' 'usr'
        root.add(home);
        root.add(opt);
        root.add(usr);

        //Añadimos a home el fichero simple usuario1. Lo creamos a la vez que los añadimos.
        //Lo mismo hacemos para los ficheros simples de 'opt' y de 'usr'
        home.add(new FicheroSimple("usuario1"));

        opt.add(new FicheroSimple("google"));
        opt.add(new FicheroSimple("idea"));
        opt.add(new FicheroSimple("spotify"));

        usr.add(new FicheroSimple("bin"));
        usr.add(new FicheroSimple("lib"));

        //Mostramos toda la estructura jerárquica, que encabeza 'root'.
        root.print();
    }
}
