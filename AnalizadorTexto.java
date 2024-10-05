import java.util.Scanner;

public class AnalizadorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto para analizar:");
        String texto = scanner.nextLine().toLowerCase();

        int[] frecuencia = new int[26];
        int totalLetras = 0;
        int totalPalabras = 0;
        int totalVocales = 0;

        boolean enPalabra = false; // Para rastrear si estamos dentro de una palabra

        for (char c : texto.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                frecuencia[c - 'a']++;
                totalLetras++;
                totalVocales += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
                enPalabra = true;
            } else if (c == ' ' && enPalabra) {
                totalPalabras++;
                enPalabra = false;
            }
        }

        if (enPalabra) totalPalabras++; // Contar la última palabra si termina en una palabra

        imprimirResultados(totalLetras, totalPalabras, totalVocales, frecuencia);
        scanner.close();
    }

    private static void imprimirResultados(int totalLetras, int totalPalabras, int totalVocales, int[] frecuencia) {
        System.out.println("Análisis del texto:");
        System.out.println("Total de letras: " + totalLetras);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de vocales: " + totalVocales);
        System.out.println("Frecuencia de letras:");
        for (int i = 0; i < 26; i++) {
            if (frecuencia[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + frecuencia[i]);
            }
        }
    }
}
