package PatronSingleton;

class Corona {
    //Creamos todos los atributos de la clase corona, incluido un atributo de la propia clase Corona, que usaremos para la comprobación de que solo se puede crear una.
    private static Corona corona;
    private int dinero;
    private int hombres;
    private int armas;
    private int comida;

    //Constructor privado de la clase Corona.
    //Con esto conseguiremos controlar el uso del contructor
    private Corona() {
        dinero = 25000;
        hombres = 45000;
        armas = 90000;
        comida = 15000;
    }

    //Este método crea una nueva corona en caso de que no haya otra ya creada, y devuelve un mensaje de error en caso de que ya exista una.
    public static Corona getCorona() {
        if(corona == null) {
            corona = new Corona();
        }
        else {
            System.out.println("SOLO PUEDE EXISTIR UNA CORONA");
        }

        return corona;
    }
    //Getters y Setters de los atributos que forman la corona.
    public int getDinero() {
        return this.dinero;
    }

    public int getHombres() {
        return this.hombres;
    }

    public int getArmas() {
        return this.armas;
    }

    public int getComida() {
        return this.comida;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setHombres(int hombres) {
        this.hombres = hombres;
    }

    public void setArmas(int armas) {
        this.armas = armas;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    //Adders y Removers que añadirán o quitarán unidades de los atributos a los que corresponda.
    //Tendrá un parámetro de entrada 'num' el cuál será la cantidad de unidades a dar/quitar a dicho atributo.
    public void addDinero(int num) {
        this.dinero += num;
    }

    public void removeDinero(int num) {
        this.dinero -= num;
    }

    public void addHombres(int num) {
        this.hombres += num;
    }

    public void removeHombres(int num) {
        this.hombres -= num;
    }

    public void addArmas(int num) {
        this.armas += num;
    }

    public void removeArmas(int num) {
        this.armas -= num;
    }

    public void addComida(int num) {
        this.comida += num;
    }

    public void removeComida(int num) {
        this.comida -= num;
    }

    //El método balanceActual muestra por pantalla el número de unidades de todos los atributos que componen la corona.
    //Usaremos los getters para mostrar dicho valor.
    public void balanceActual() {
        System.out.println("Dinero: " +getDinero());
        System.out.println("Hombres: " +getHombres());
        System.out.println("Armas: " +getArmas());
        System.out.println("Comida: " +getComida());
    }
}

public class Coronas {
    public static void main(String[] args) {

        //Creamos una corona mediante el método getCorona().
        Corona corona1 = Corona.getCorona();

        //Mostramos los recursos de la corona antes de la guerra.
        System.out.println("-- BALANCE ANTES DE LA GUERRA --");
        corona1.balanceActual();

        System.out.println("-- BALANCE DESPUÉS DE LA GUERRA --");
        //Usamos los métodos 'add' y 'remove' para reflejar los acontecimientos de la guerra.
        corona1.addComida(20000);
        corona1.removeDinero(15000);
        corona1.removeHombres(7500);
        corona1.addHombres(5000);
        corona1.addDinero(50000);
        corona1.removeHombres(5000);

        //Mostramos los recursos de la corona después de la guerra.
        corona1.balanceActual();

    }
}
