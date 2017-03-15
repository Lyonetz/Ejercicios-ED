package PatronDecorador;

public interface Alquilable {
    public String getDescripcion();
    public String getTipo();
    public double getPresupuesto();
}

class Hotel implements Alquilable {
    private double costeBase = 100;
    private String tipo = "Hotel";
    private String descripcion;

    public Hotel(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public double getPresupuesto() {
        return this.costeBase;
    }
}

abstract class AlquilableDecorator implements Alquilable {
    private Alquilable alquilable;

    public AlquilableDecorator(Alquilable alquilable) {
        this.alquilable = alquilable;
    }

    public Alquilable getAlquilable() {
        return this.alquilable;
    }

    public void setAlquilable(Alquilable alquilable) {
        this.alquilable = alquilable;
    }

    @Override
    public String getDescripcion() {
        return getAlquilable().getDescripcion();
    }

    @Override
    public String getTipo() {
        return getAlquilable().getTipo();
    }

    @Override
    public double getPresupuesto() {
        return getAlquilable().getPresupuesto();
    }
}

class PrimeraLineaDePlaya extends AlquilableDecorator {
    public PrimeraLineaDePlaya(Alquilable alquilable) {
        super(alquilable);
    }

    @Override
    public String getDescripcion() {
        return getAlquilable().getDescripcion().concat(" (vistas al mar)");
    }

    @Override
    public double getPresupuesto() {
        return getAlquilable().getPresupuesto() + 100;
    }
}

class PensionCompleta extends AlquilableDecorator {
    public PensionCompleta(Alquilable alquilable) {
        super(alquilable);
    }

    @Override
    public String getDescripcion() {
        return getAlquilable().getDescripcion().concat(" (pensión completa)");
    }

    @Override
    public double getPresupuesto() {
        return getAlquilable().getPresupuesto() + 65;
    }
}

class DescuentoClienteVIP extends AlquilableDecorator {
    public DescuentoClienteVIP(Alquilable alquilable) {
        super(alquilable);
    }

    @Override
    public String getDescripcion() {
        return getAlquilable().getDescripcion().concat(" (descuento cliente VIP)");
    }

    @Override
    public double getPresupuesto() {
        return getAlquilable().getPresupuesto() * 0.85;
    }
}

class Alquilables {
    public static void main(String[] args) {
        Alquilable hotelTorremolinos = new Hotel("Hotel en Torremolinos (Málaga)");
        hotelTorremolinos = new PensionCompleta(hotelTorremolinos);
        System.out.println(hotelTorremolinos.getDescripcion());
        System.out.println(hotelTorremolinos.getPresupuesto() + "€");

        Alquilable hotelDenia = new Hotel("Hotel en Denia (Alicante)");
        hotelDenia = new PrimeraLineaDePlaya(hotelDenia);
        hotelDenia = new PensionCompleta(hotelDenia);
        hotelDenia = new DescuentoClienteVIP(hotelDenia);
        System.out.println(hotelDenia.getDescripcion());
        System.out.println(hotelDenia.getPresupuesto() + "€");

    }
}

