import sys

def mostrar_menu():
    print("\nBienvenido al CineMas - Loja")
    print("1. Ver cartelera")
    print("2. Comprar Boletos")
    print("3. Comprar Snacks")
    print("4. Finalizar y Emitir Factura")
    print("Seleccione una opcion: ", end="")

def mostrar_cartelera(cartelera, horarios, precios, salas):
    print("\nCartelera:")
    for i, pelicula in enumerate(cartelera):
        print(
            f"{i + 1}. {pelicula} - Horario: {horarios[i]} - "
            f"Precio: ${precios[i]} - {salas[i]}"
        )

def comprar_boletos(cartelera, horarios, precios, salas, factura):
    mostrar_cartelera(cartelera, horarios, precios, salas)
    seleccion = int(input("Seleccione la pelicula (numero): "))
    cantidad = int(input("Ingrese la cantidad de boletos: "))
    print("Seleccione el dia de la semana:")
    print("1. Lunes, 2. Martes, 3. Miercoles, 4. Jueves, "
          "5. Viernes, 6. Sabado, 7. Domingo")
    dia = int(input("Ingrese el numero del dia: "))
    total = calcular_total(float(precios[seleccion - 1]), cantidad, dia)
    factura.append(f"{cantidad} boletos para {cartelera[seleccion - 1]} - Total: ${total}")
    print(f"El total a pagar es: ${total}")
    return total

def comprar_snacks(snacks, precios_snacks, factura):
    print("\nSeleccione un snack:")
    for i, snack in enumerate(snacks):
        print(f"{i + 1}. {snack} - Precio: ${precios_snacks[i]}")
    seleccion = int(input("Seleccione un snack para comprar (1-3): "))
    precio = float(precios_snacks[seleccion - 1])
    factura.append(f"Snack: {snacks[seleccion - 1]} - Total: ${precio}")
    print(f"Has comprado: {snacks[seleccion - 1]} por ${precio}")
    return precio

def calcular_total(precio_unitario, cantidad, dia):
    total = precio_unitario * cantidad
    if dia in [1, 3, 5, 7]:
        print("Recibe 50% de descuento")
        total *= 0.5
    return total

def emitir_factura(factura, total_factura):
    print("\nFactura:")
    for item in factura:
        print(f"- {item}")
    print(f"Total a pagar: ${total_factura}")
    print("Gracias por visitar CineMas - Loja. Hasta pronto")
    sys.exit()

def main():
    factura = []
    total_factura = 0.0
    cartelera = ["El Rey Leon", "Interestellar", "Pulp Fiction", "Moana 2"]
    horarios = ["11:00", "15:00", "19:00", "22:00"]
    precios = ["6.0", "5.0", "7.0", "3.50"]
    salas = ["Sala 1", "Sala 2", "Sala 3", "Sala 4"]
    snacks = ["Canguil", "Granizado", "Nachos"]
    precios_snacks = ["3.0", "2.0", "4.0"]

    while True:
        mostrar_menu()
        opcion = int(input())
        if opcion == 1:
            mostrar_cartelera(cartelera, horarios, precios, salas)
        elif opcion == 2:
            total_factura += comprar_boletos(cartelera, horarios, precios, salas, factura)
        elif opcion == 3:
            total_factura += comprar_snacks(snacks, precios_snacks, factura)
        elif opcion == 4:
            emitir_factura(factura, total_factura)
        else:
            print("Opcion no valida. Intente nuevamente")

if __name__ == "__main__":
    main()
