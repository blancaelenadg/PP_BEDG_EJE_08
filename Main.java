// https://github.com/blancaelenadg/PP_BEDG_EJE_08
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        //  NIVEL 1

        List<Integer> numeros = Arrays.asList(5, 7, 30, 20, 1, -3, 60, 80, 45, 100, 12, 8, -10, 55);

        System.out.println("=== NIVEL 1: Operaciones básicas ===");
        // 1. Sumar elementos
        int suma = numeros.stream().reduce(0, Integer::sum);
        System.out.println("1. Suma: " + suma);

        // 2. Obtener el máximo
        int maximo = numeros.stream().max(Integer::compareTo).orElse(0);
        System.out.println("2. Máximo: " + maximo);

        // 3. Obtener el mínimo
        int minimo = numeros.stream().min(Integer::compareTo).orElse(0);
        System.out.println("3. Mínimo: " + minimo);

        // 4. Contar elementos
        long total = numeros.stream().count();
        System.out.println("4. Total de elementos: " + total);

        // NIVEL 2
        System.out.println("\n=== NIVEL 2: filter ===");
        // 5. Números pares
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("5. Números pares: " + pares);

        // 6. Números mayores que 50
        List<Integer> mayores50 = numeros.stream()
                .filter(n -> n > 50)
                .toList();
        System.out.println("6. Mayores que 50: " + mayores50);

        // 7. Contar números positivos
        long positivos = numeros.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("7. Cantidad de positivos: " + positivos);

        // 8. Números dentro de un rango (por ejemplo, entre 10 y 50)
        List<Integer> enRango = numeros.stream()
                .filter(n -> n >= 10 && n <= 50)
                .toList();
        System.out.println("8. Números entre 10 y 50: " + enRango);

        // NIVEL 3
        System.out.println("\n=== NIVEL 3: map ===");
        // 9. Elevar al cuadrado
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("9. Cuadrados: " + cuadrados);

        // 10. Multiplicar por 10
        List<Integer> por10 = numeros.stream()
                .map(n -> n * 10)
                .toList();
        System.out.println("10. Multiplicados por 10: " + por10);

        // 11. Convertir temperaturas (Celsius a Fahrenheit)
        List<Double> celsius = Arrays.asList(0.0, 10.0, 20.0, 30.0, 37.0);
        List<Double> fahrenheit = celsius.stream()
                .map(c -> c * 9/5 + 32)
                .toList();
        System.out.println("11. Temperaturas en Fahrenheit: " + fahrenheit);

        //  NIVEL 4
        System.out.println("\n=== NIVEL 4: combinar operaciones ===");
        // 12. Pares elevados al cuadrado
        List<Integer> paresCuadrados = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("12. Pares al cuadrado: " + paresCuadrados);

        // 13. Suma de números pares
        int sumaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("13. Suma de pares: " + sumaPares);

        // 14. Promedio de números mayores que 50
        double promedioMayores50 = numeros.stream()
                .filter(n -> n > 50)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("14. Promedio >50: " + promedioMayores50);

        // 15. Máximo de números pares
        int maxPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("15. Máximo de pares: " + maxPares);

        //  NIVEL 5: ordenamiento
        System.out.println("\n=== NIVEL 5: ordenamiento ===");
        // 16. Ordenar de menor a mayor
        List<Integer> ordenAsc = numeros.stream()
                .sorted()
                .toList();
        System.out.println("16. Orden ascendente: " + ordenAsc);

        // 17. Ordenar de mayor a menor
        List<Integer> ordenDesc = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("17. Orden descendente: " + ordenDesc);

        // 18. Tres números más grandes
        List<Integer> tresMayores = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("18. Tres mayores: " + tresMayores);

        // NIVEL 6
        System.out.println("\n=== NIVEL 6: String[] ===");
        String[] nombres = {"Ana", "Carlos", "Beatriz", "Juan", "Pedro", "Maria", "Luis", "Alejandro"};

        // 19. Filtrar nombres (por ejemplo, que empiecen con 'A')
        List<String> nombresConA = Arrays.stream(nombres)
                .filter(n -> n.startsWith("A"))
                .toList();
        System.out.println("19. Nombres que empiezan con A: " + nombresConA);

        // 20. Nombres con más de 5 caracteres
        List<String> nombresLargos = Arrays.stream(nombres)
                .filter(n -> n.length() > 5)
                .toList();
        System.out.println("20. Nombres con más de 5 letras: " + nombresLargos);

        // 21. Convertir a mayúsculas
        List<String> nombresMayus = Arrays.stream(nombres)
                .map(String::toUpperCase)
                .toList();
        System.out.println("21. Nombres en mayúsculas: " + nombresMayus);

        // 22. Ordenar nombres
        List<String> nombresOrdenados = Arrays.stream(nombres)
                .sorted()
                .toList();
        System.out.println("22. Nombres ordenados: " + nombresOrdenados);


        // NIVEL 7
        System.out.println("\n=== NIVEL 7 ===");
        // 23. Buscar un número (por ejemplo, si existe el 30)
        boolean existe30 = numeros.stream()
                .anyMatch(n -> n == 30);
        System.out.println("23. ¿Existe el 30? " + existe30);

        // 24. Determinar si todos cumplen una condición (por ejemplo, todos > 0)
        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);
        System.out.println("24. ¿Todos son positivos? " + todosPositivos);

        // 25. Determinar si alguno cumple una condición (por ejemplo, alguno > 90)
        boolean algunoMayor90 = numeros.stream()
                .anyMatch(n -> n > 90);
        System.out.println("25. ¿Alguno es mayor que 90? " + algunoMayor90);
    }
}