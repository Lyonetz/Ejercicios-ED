package PatronCreacion;

class Zapato {
    protected String modelo = "";
    protected String color = "";
    protected int talla = 0;

    public Zapato setModelo(String modelo) {
        this.modelo = modelo;

        return this;
    }
    public Zapato setColor(String color) {
        this.color = color;

        return this;
    }
    public Zapato setTalla(int talla) {
        this.talla = talla;

        return this;
    }

    public String getModelo() {return this.modelo;}
    public String getColor() {return this.color;}
    public int getTalla() {return this.talla;}
}

abstract class ConstructorZapatos {
    protected Zapato zapato;

    public void nuevo() {zapato = new Zapato();}
    public Zapato obtenerZapato() {return zapato;}

    public abstract void asignarModelo();
    public abstract void asignarColor();
    public abstract void asignarTalla();
}

class ConstructorZapatosNike extends ConstructorZapatos {

    @Override
    public void asignarModelo() {
        zapato.modelo = "Modelo Nike 1";
    }

    @Override
    public void asignarColor() {
        zapato.color = "Color Nike 1";
    }

    @Override
    public void asignarTalla() {
        zapato.talla = 0;
    }

}

class ConstructorZapatosAdidas extends ConstructorZapatos {

    @Override
    public void asignarModelo() {
        zapato.modelo = "Modelo Adidas 1";
    }

    @Override
    public void asignarColor() {
        zapato.color = "Color Adidas 1";
    }

    @Override
    public void asignarTalla() {
        zapato.talla = 0;
    }
}

class FabricaZapatos {
    private ConstructorZapatos constructorZapatos;

    public void establecerConstructorZapatos(ConstructorZapatos cz){this.constructorZapatos = cz;};
    public Zapato obtenerZapato(){return constructorZapatos.obtenerZapato();};

    public void construirZapato() {
        constructorZapatos.nuevo();
        constructorZapatos.asignarModelo();
        constructorZapatos.asignarColor();
        constructorZapatos.asignarTalla();
    }
}

public class Zapatos {
    public static void main(String[] args) {
        FabricaZapatos f1 = new FabricaZapatos();

        ConstructorZapatos cz1 = new ConstructorZapatosNike();

        f1.establecerConstructorZapatos(cz1);

        f1.construirZapato();

        Zapato z1 = f1.obtenerZapato();

        System.out.println(z1.getModelo());
        System.out.println(z1.getColor());
        System.out.println(z1.getTalla());

    }
}

