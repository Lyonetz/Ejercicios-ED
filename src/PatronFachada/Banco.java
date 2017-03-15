package PatronFachada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Autentificacion {
    public boolean leerTarjeta() {
        return true;
    }
    public String introducirClave() throws IOException {
        System.out.println("Introduzca la clave de la tarjeta: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        return s;
    }
    public boolean comprobarClave(String clave, String pass) {
        return pass.equals(clave);
    }
    public Cuenta obtenerCuenta(){
        return new Cuenta();
    }
}

class Cajero {
    private int saldo = 1000000;

    //Metodo que leeria la cantidad que el usuario quiere sacar de la cuenta
    public int introducirCantidad() throws IOException {
        System.out.println("Introduzca la cantidad que desea sacar (múltiplo de 5): ");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        //int i = new Integer(br2.readLine());
        int cant = Integer.parseInt(br2.readLine());

        /*if(cant % 5 != 0) {
            System.out.println("La cantidad introducida no es múltiplo de 5");
            introducirCantidad();
        } else {
            return cant;
        }*/
        return cant;
    }

    //Metodo que comprueba si el cajero tiene saldo suficiente para entregar
    //la cantidad solicitada
    public boolean tieneSaldo(int cantidad) {
        return saldo >= cantidad;
    }

    public void imprimirTicket(int cantidad, double saldo) throws IOException {
        System.out.println("__________________________________________________");
        System.out.println("-- Operacion realizada con exito --");
        System.out.println("Ha sacado " + cantidad + "€ de su cuenta.");
        System.out.println("Ahora mismo tiene " + saldo + "€ en su cuenta.");
        System.out.println("Formato --");
        formatoExtraccion(cantidad);
        System.out.println("__________________________________________________");
    }
    //Método que imprimirá el número de billetes de cada tipo que el cajero ha dado a usuario.
    public void formatoExtraccion(int cantidad) {
        int b5 = 0, b10 = 0, b20 = 0, b50 = 0, b100 = 0;

        do {
            if(cantidad >= 100) {
                cantidad -= 100;
                b100++;
            }else if(cantidad >= 50) {
                cantidad -= 50;
                b50++;
            }else if(cantidad >= 20) {
                cantidad -= 20;
                b20++;
            }else if(cantidad >= 10) {
                cantidad -= 10;
                b10++;
            }else if(cantidad >= 5) {
                cantidad -= 5;
                b5++;
            }
        } while(cantidad >= 5);

        if(b5 > 0) {
            System.out.println(b5 + " billetes de 5.");
        }
        if(b10 > 0) {
            System.out.println(b10 + " billete(s) de 10.");
        }
        if(b20 > 0) {
            System.out.println(b20 + " billete(s) de 20.");
        }
        if(b50 > 0) {
            System.out.println(b50 + " billete(s) de 50.");
        }
        if(b100 > 0) {
            System.out.println(b100 + " billete(s) de 100.");
        }
    }
}

class Cuenta {
    private int saldo;
    private boolean bloqueada;
    private String pass;

    public Cuenta () {
        saldo = 50000;
        bloqueada = false;
        pass = "123abc";
    }
    public double comprobarSaldoDisponible() {
        return this.saldo;
    }
    public void bloquearCuenta() {
        this.bloqueada = true;
    }
    public void desbloquearCuenta() {
        this.bloqueada = false;
    }
    public void retirarSaldo(int cantidad) {
        this.saldo -= cantidad;
    }
    public String getPass() {
        return pass;
    }
}

class FachadaCajero {

    //Creamos objetos de las clases a emplear
    private Autentificacion autentificacion = new Autentificacion();
    private Cajero cajero = new Cajero();
    private Cuenta cuenta = null;

    //Metodo que identifica al usuario
    public void introducirCredenciales() throws IOException {
        boolean tarjetaCorrecta = autentificacion.leerTarjeta();
        if(tarjetaCorrecta) {
            cuenta = autentificacion.obtenerCuenta();
            String clave = autentificacion.introducirClave();
            boolean claveCorrecta = autentificacion.comprobarClave(clave, cuenta.getPass());
            if(claveCorrecta) {
                System.out.println("Clave correcta.");
            } else {
                System.out.println("Clave incorrecta.");
                introducirCredenciales();
            }
        }
    }

    //Metodo para sacar dinero de la cuenta
    public void sacarDinero() throws IOException {
        if(cuenta != null) {
            int cantidad = cajero.introducirCantidad();
            boolean tiene_dinero = cajero.tieneSaldo(cantidad);
            if(tiene_dinero) {
                System.out.println("El cajero tiene saldo suficiente, procesando...");
                if(cuenta.comprobarSaldoDisponible() >= cantidad){
                    System.out.println("Su cuenta tiene saldo suficiente, procesando...");
                    cuenta.bloquearCuenta();
                    cuenta.retirarSaldo(cantidad);
                    cuenta.desbloquearCuenta();
                    cajero.imprimirTicket(cantidad, cuenta.comprobarSaldoDisponible());
                } else {
                    System.out.println("No tiene saldo suficiente en su cuenta. Seleccione una cantidad menor.");
                    sacarDinero();
                }
            } else {
                System.out.println("Saldo insuficiente en el cajero. Seleccione una cantidad menor.");
                sacarDinero();
            }
        }
    }
}

public class Banco {
    public static void main(String[] args) throws IOException {
        FachadaCajero cajeroAutomatico = new FachadaCajero();

        cajeroAutomatico.introducirCredenciales();
        cajeroAutomatico.sacarDinero();
    }
}
