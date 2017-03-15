package PatronDecorador;

public interface Comidas {
    public String getTamaño();
    public String getTipoMasa();
    public int getPrecio();
    public String getDescripcion();
}

class PizzaGrande implements Comidas {
    private String tamaño = "Grande";
    private String tipoMasa = "Gruesa";
    private int precio = 10;
    private String descripcion = "Pizza";

    @Override
    public String getTamaño() {
        return this.tamaño;
    }

    @Override
    public String getTipoMasa() {
        return this.tipoMasa;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion.concat(" Tamaño:" + this.getTamaño()).concat(" Masa:" + this.getTipoMasa());
    }
}

class PizzaMediana implements Comidas {
    private String tamaño = "Mediana";
    private String tipoMasa = "Normal";
    private int precio = 8;
    private String descripcion = "Pizza";

    @Override
    public String getTamaño() {
        return this.tamaño;
    }

    @Override
    public String getTipoMasa() {
        return this.tipoMasa;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion.concat(" Tamaño:" + this.getTamaño()).concat(" Masa:" + this.getTipoMasa());
    }
}
class PizzaPequeña implements Comidas {
    private String tamaño = "Pequeña";
    private String tipoMasa = "Fina";
    private int precio = 6;
    private String descripcion = "Pizza";

    @Override
    public String getTamaño() {
        return this.tamaño;
    }

    @Override
    public String getTipoMasa() {
        return this.tipoMasa;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }
    @Override
    public String getDescripcion() {
        return this.descripcion.concat(" Tamaño:" + this.getTamaño()).concat(" Masa:" + this.getTipoMasa());
    }
}

abstract class ComidaDecorator implements Comidas {
    private Comidas comidas;

    public ComidaDecorator(Comidas comidas) {
        this.comidas = comidas;
    }

    public Comidas getComidas() {
        return this.comidas;
    }

    public void setComidas(Comidas comidas) {
        this.comidas = comidas;
    }

    @Override
    public String getTamaño() {
        return getComidas().getTamaño();
    }

    @Override
    public String getTipoMasa() {
        return getComidas().getTipoMasa();
    }

    @Override
    public int getPrecio() {
        return getComidas().getPrecio();
    }
}

class DobleQueso extends ComidaDecorator {
    public DobleQueso(Comidas comida) {
        super(comida);
    }

    @Override
    public String getDescripcion() {
        return getComidas().getDescripcion().concat(" (Doble de Queso)");
    }

    @Override
    public int getPrecio() {
        return getComidas().getPrecio() + 1;
    }
}

class Jamon extends ComidaDecorator {
    public Jamon(Comidas comida) {
        super(comida);
    }

    @Override
    public String getDescripcion() {
        return getComidas().getDescripcion().concat(" (Jamon)");
    }

    @Override
    public int getPrecio() {
        return getComidas().getPrecio() + 1;
    }
}

class Pimiento extends ComidaDecorator {
    public Pimiento(Comidas comida) {
        super(comida);
    }

    @Override
    public String getDescripcion() {
        return getComidas().getDescripcion().concat(" (Pimiento)");
    }

    @Override
    public int getPrecio() {
        return getComidas().getPrecio() + 1;
    }
}

class Comida {
    public static void main(String[] args) {
        Comidas pizza1 = new PizzaGrande();
        pizza1 = new Pimiento(pizza1);
        pizza1 = new DobleQueso(pizza1);
        System.out.println(pizza1.getDescripcion());
        System.out.println("Coste de la pizza: " + pizza1.getPrecio());
    }
}
