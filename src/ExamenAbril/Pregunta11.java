package ExamenAbril;

interface Pizza {
    String getDescripcion();
    double obtenerPresupuesto();
}

class PizzaMasaNormal implements Pizza {
    private String descripcion = "Pizza de masa normal con: ";
    private double precio = 5;

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double obtenerPresupuesto() {
        return precio;
    }
}

class PizzaMasaFina implements Pizza {
    private String descripcion = "Pizza de masa fina con: ";
    private double precio = 5;

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double obtenerPresupuesto() {
        return precio;
    }
}

class Ingredientes implements Pizza {
    public Pizza pizza;

    public Ingredientes(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public String getDescripcion() {
        return getPizza().getDescripcion();
    }

    @Override
    public double obtenerPresupuesto() {
        return getPizza().obtenerPresupuesto();
    }

}

class Tomate extends Ingredientes {
    public Tomate(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return getPizza().getDescripcion().concat(" Tomate,");
    }

    @Override
    public double obtenerPresupuesto() {
        return getPizza().obtenerPresupuesto() + 2.5;
    }
}

class Mozzarella extends Ingredientes {
    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return getPizza().getDescripcion().concat(" Mozzarella,");
    }

    @Override
    public double obtenerPresupuesto() {
        return getPizza().obtenerPresupuesto() + 2;
    }
}

class Bacon extends Ingredientes {
    public Bacon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return getPizza().getDescripcion().concat(" Bacon,");
    }

    @Override
    public double obtenerPresupuesto() {
        return getPizza().obtenerPresupuesto() + 2.5;
    }
}

class Atun extends Ingredientes {
    public Atun(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return getPizza().getDescripcion().concat(" Atun,");
    }

    @Override
    public double obtenerPresupuesto() {
        return getPizza().obtenerPresupuesto() + 3;
    }
}


class Pepperoni extends Ingredientes {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescripcion() {
        return getPizza().getDescripcion().concat(" Pepperoni,");
    }

    @Override
    public double obtenerPresupuesto() {
        return getPizza().obtenerPresupuesto() + 3;
    }
}

public class Pregunta11 {
    public static void main(String[] args) {
        Pizza p = new PizzaMasaFina();
        p = new Tomate(p);
        p = new Mozzarella(p);
        p = new Bacon(p);

        System.out.println(p.getDescripcion());
        System.out.println(p.obtenerPresupuesto());

        Pizza p2 = new PizzaMasaNormal();
        p2 = new Tomate(p2);
        p2 = new Mozzarella(p2);
        p2 = new Pepperoni(p2);

        System.out.println(p2.getDescripcion());
        System.out.println(p2.obtenerPresupuesto());
    }
}
