
import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String[] factura = new String[100];
        double totalFactura = 0.0;

        String[] cartelera = {"El Rey Leon", "Interestellar", "Pulp fiction", "Moana 2"};
        String[] horarios = {"11:00", "15:00", "19:00", "22:00"};
        String[] precios = {"6.0", "5.0", "7.0", "3.50"};
        String[] salas = {"Sala 1", "Sala 2", "Sala 3", "Sala 4"};
        String[] snacks = {"Canguil", "Granizado", "Nachos"};
        String[] preciosSnacks = {"3.0", "2.0", "4.0"};

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = tcl.nextInt();

            switch (opcion) {
                case 1:
                    mostrarCartelera(cartelera, horarios, precios, salas);
                    break;
                case 2:
                    totalFactura += comprarBoletos(cartelera, horarios, precios, salas, tcl, factura);
                    break;
                case 3:
                    totalFactura += comprarSnacks(snacks, preciosSnacks, tcl, factura);
                    break;
                case 4:
                    emitirFactura(factura, totalFactura);
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\nBienvenido al CineMas - Loja");
        System.out.println("1. Ver cartelera");
        System.out.println("2. Comprar Boletos");
        System.out.println("3. Comprar Snacks");
        System.out.println("4. Finalizar y Emitir Factura");
        System.out.print("Seleccione una opcion: ");
    }

    public static void mostrarCartelera(String[] cartelera, String[] horarios, String[] precios, String[] salas) {
        System.out.println("\nCartelera:");
        for (int i = 0; i < cartelera.length; i++) {
            System.out.println((i + 1) + ". " + cartelera[i] + " - Horario: " + horarios[i] + " - Precio: $" + precios[i] + " - " + salas[i]);
        }
    }

    public static double comprarBoletos(String[] cartelera, String[] horarios, String[] precios, String[] salas, Scanner tcl, String[] factura) {
        mostrarCartelera(cartelera, horarios, precios, salas);

        System.out.print("Seleccione la película que desea adquirir (numero): ");
        int seleccion = tcl.nextInt();

        System.out.print("Ingrese la cantidad de boletos: ");
        int cantidad = tcl.nextInt();

        System.out.println("Seleccione el dia de la semana: ");
        System.out.println("1. Lunes, 2. Martes, 3. Miercoles, 4. Jueves, 5. Viernes, 6. Sabado, 7. Domingo");
        int dia = tcl.nextInt();

        double total = calcularTotal(Double.valueOf(precios[seleccion - 1]), cantidad, dia);
        agregarAFactura(factura, cantidad + " boletos para " + cartelera[seleccion - 1] + " en " + salas[seleccion - 1] + " - Total: $" + total);

        System.out.println("El total a pagar por la pelicula seleccionada es de: $" + total);
        return total;
    }

    public static double comprarSnacks(String[] snacks, String[] preciosSnacks, Scanner tcl, String[] factura) {
        System.out.println("\nSeleccione un snack: ");
        for (int i = 0; i < snacks.length; i++) {
            System.out.println((i + 1) + ". " + snacks[i] + " - Precio: $" + preciosSnacks[i]);
        }

        System.out.print("Seleccione un snack para comprar (1-" + snacks.length + "): ");
        int seleccion = tcl.nextInt();

        double precio = Double.valueOf(preciosSnacks[seleccion - 1]);
        agregarAFactura(factura, "Snack: " + snacks[seleccion - 1] + " - Total: $" + precio);

        System.out.println("Has comprado: " + snacks[seleccion - 1] + " por $" + precio);
        return precio;
    }

    public static void emitirFactura(String[] factura, double totalFactura) {
        System.out.println("\nFactura:");

        for (int i = 0; i < factura.length; i++) {
            if (factura[i] != null) {
                System.out.println("- " + factura[i]);
            }
        }
        System.out.println("Total a pagar: $" + totalFactura);
        System.out.println("Gracias por visitar CineMas - Loja. Hasta pronto");
    }

    public static double calcularTotal(double precioUnitario, int cantidad, int dia) {
        double total = precioUnitario * cantidad;

        if (dia == 1 || dia == 3 || dia == 5 || dia == 7) {
            System.out.println("Recibe 50% de Descuento");
            total *= 0.5;
        }
        return total;
    }

    public static void agregarAFactura(String[] factura, String detalle) {
        for (int i = 0; i < factura.length; i++) {
            if (factura[i] == null) {
                factura[i] = detalle;
                break;
            }
        }
    }
}
