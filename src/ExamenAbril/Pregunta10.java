package ExamenAbril;

class Corona {
    private static Corona corona;
    private int dinero;
    private int hombres;
    private int armas;
    private int comida;

    private Corona() {
        dinero = 25000;
        hombres = 45000;
        armas = 90000;
        comida = 15000;
    }

    public static Corona getCorona() {
        if(corona == null) {
            corona = new Corona();
        } else {
            System.out.println("Ya existe una corona");
        }
        return corona;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getHombres() {
        return hombres;
    }

    public void setHombres(int hombres) {
        this.hombres = hombres;
    }

    public int getArmas() {
        return armas;
    }

    public void setArmas(int armas) {
        this.armas = armas;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public void addDinero(int dinero) {
        this.dinero += dinero;
    }

    public void addHombres(int hombres) {
        this.hombres += hombres;
    }

    public void addArmas(int armas) {
        this.armas += armas;
    }

    public void addComida(int comida) {
        this.comida += comida;
    }

    public void removeDinero(int dinero) {
        this.dinero -= dinero;
    }

    public void removeHombres(int hombres) {
        this.hombres -= hombres;
    }

    public void removeArmas(int armas) {
        this.armas -= armas;
    }

    public void removeComida(int comida) {
        this.comida -= comida;
    }

    public void balanceActual() {
        System.out.println("#Dinero actual: " + getDinero());
        System.out.println("#Hombres actuales: " + getHombres());
        System.out.println("#Armas actuales: " + getArmas());
        System.out.println("#Comida actual: " + getComida());
    }
}

public class Pregunta10 {
    public static void main(String[] args) {
        Corona corona = Corona.getCorona();

        System.out.println("Consecuencias de la guerra.");
        corona.addComida(20000);
        corona.removeDinero(15000);
        corona.removeHombres(7500);
        corona.addDinero(50000);
        corona.removeHombres(5000);

        corona.balanceActual();
    }
}
