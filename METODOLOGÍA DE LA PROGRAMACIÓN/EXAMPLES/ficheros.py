from io import open
import os

texto = "Nombre: Agustina \nApellido: Cars"
try:
    fichero = open('text.txt', 'w')
    fichero.write(texto)
    fichero.close()
except Exception as e:
    print(f"Error: {e}")

# Leer texto
try:
    fichero = open('text.txt', 'r')
    text = fichero.read()
    fichero.close()
    print(text)
except Exception as e:
    print(f"Error: {e}")


# Leer creando una lista
try:
    fichero = open('text.txt', 'r')
    text1 = fichero.readlines()
    fichero.close()
    print(text1)

except Exception as e:
    print(f"Error: {e}")


# Leer con while
with open('text.txt', 'r') as fichero:
    for linea in fichero:
        print(linea)


# Añadir datos al final de un fichero
fichero = open('text.txt', 'a')  # puntero al final
fichero.write('\n DNI:44516402')
fichero.close()

# Crear fichero si no existe
fichero = open('text.txt', 'a+')


# Leer todas las líneas en una lista, modificar una línea en la lista, posicionar el
# puntero al principio y reescribir de nuevo todas las líneas
fichero = open('text.txt', 'r+')
texto = fichero.readlines()

texto[2] = "Linea 3"  # Modificar linea deseada

fichero.seek(0)  # Puntero al inicio
fichero.writelines(texto)  # Reescribir
fichero.close()
