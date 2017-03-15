package PatronComponente;

import java.util.ArrayList;

interface Zona {
    void generarPlano();
    String getTipo();
    void agregarZona(Zona z);
    Zona subzona(int i);
}

class Ciudad implements Zona{
    private String nombre;
    private ArrayList<Zona> subzonas;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        subzonas = new ArrayList();
    }

    @Override
    public void generarPlano() {
        System.out.println("CIUDAD: " + this.nombre);

        for (int i = 0; i < subzonas.size(); i++) {
            subzonas.get(i).generarPlano();
        }
    }

    @Override
    public String getTipo() {
        return "ciudad";
    }

    @Override
    public void agregarZona(Zona z) {
        if(z.getTipo().equals("barrio")) {
            subzonas.add(z);
        } else {
            System.out.println("No se puede añadir " + z.getTipo() + "directamente a una ciudad");
        }
    }

    public Zona subzona(int i) {
        return subzonas.get(i);
    }
}

class Barrio implements Zona {
    private String nombre;
    private ArrayList<Zona> subzonas;

    public Barrio(String nombre) {
        this.nombre = nombre;
        subzonas = new ArrayList();
    }

    public void generarPlano() {
        System.out.println("\tBARRIO: " + this.nombre);
        for (int i = 0; i < subzonas.size(); i++) {
            subzonas.get(i).generarPlano();
        }
    }

    @Override
    public String getTipo() {
        return "barrio";
    }

    @Override
    public void agregarZona(Zona z) {
        if(!(z.getTipo().equals("ciudad") || z.getTipo().equals("barrio"))) {
            subzonas.add(z);
        } else {
            System.out.println("No se puede añadir " + z.getTipo() + "directamente a mi barrio");
        }
    }

    public Zona subzona(int i) {
        return subzonas.get(i);
    }
}

class Calle implements Zona {
    private String nombre;

    public Calle(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void generarPlano() {
        System.out.println("\t\tCALLE: " + this.nombre);
    }

    @Override
    public String getTipo() {
        return "calle";
    }

    @Override
    public void agregarZona(Zona z) {
        System.out.println("No se pueden agregar zonas a " + this.getTipo());
    }

    public Zona subzona(int i) {
        System.out.println("Este elemento no contiene subzonas");

        return null;
    }
}

class Avenida implements Zona {
    private String nombre;

    public Avenida(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void generarPlano() {
        System.out.println("\t\tAVENIDA: " + this.nombre);
    }

    @Override
    public String getTipo() {
        return "avenida";
    }

    public void agregarZona(Zona z) {
        System.out.println("No se puede agregar zonas a " + z.getTipo());
    }

    @Override
    public Zona subzona(int i) {
        System.out.println("Este elemento no contiene subzonas");

        return null;
    }
}

class Plaza implements Zona {
    private String nombre;

    public Plaza(String nombre) {
        this.nombre = nombre;
    }

    public void generarPlano() {
        System.out.println("\t\tPLAZA: " + this.nombre);
    }

    public String getTipo() {
        return "plaza";
    }

    public void agregarZona(Zona z) {
        System.out.println("No se pueden agregar zonas a " + z.getTipo());
    }

    public Zona subzona(int i) {
        System.out.println("Este elemento no contiene subzonas");

        return null;
    }
}

class Travesia implements Zona {
    private String nombre;

    public Travesia(String nombre) {
        this.nombre = nombre;
    }

    public void generarPlano() {
        System.out.println("\t\tTRAVESÍA: " + this.nombre);
    }

    public String getTipo() {
        return "travesia";
    }

    public void agregarZona(Zona z) {
        System.out.println("No se pueden agregar zonas a " + z.getTipo());
    }

    public Zona subzona(int i) {
        System.out.println("Este elemento no contiene subzonas");

        return null;
    }
}

public class Zonas {
    public static void main(String[] args) {
        ArrayList<Zona> zonas = new ArrayList();

        Zona cadiz = new Ciudad("Cádiz");

        Zona laViña = new Barrio("La Viña");
        Zona populo = new Barrio("El Pópoulo");

        Zona delaRosa = new Calle("De la Rosa");
        Zona delaPalma = new Calle("De la Palma");
        Zona venezuela = new Calle("Venezuela");
        Zona mesonNuevo = new Calle("Mesón Nuevo");
        Zona posadilla = new Calle("Posadilla");
        Zona pelota = new Calle("Pelota");

        cadiz.agregarZona(laViña);
        cadiz.agregarZona(populo);

        laViña.agregarZona(delaRosa);
        laViña.agregarZona(delaPalma);
        laViña.agregarZona(venezuela);
        populo.agregarZona(mesonNuevo);
        populo.agregarZona(posadilla);
        populo.agregarZona(pelota);

        zonas.add(cadiz);

        for(Zona z : zonas) {
            z.generarPlano();
        }
    }
}




















