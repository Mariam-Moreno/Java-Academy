package Ejercicio5;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class TextAnalyzer {
    private final List<String> lines;

    public TextAnalyzer(List<String> lines) {
        this.lines = lines;
    }

    private Stream<String> words() {
        // flatMap cada linea en sus palabras (split por espacios)
        return lines.stream()
            .flatMap(line -> Arrays.stream(line.split("\\s+")))
            .filter(w -> !w.isEmpty());
    }

    private Stream<String> cleanWords() {
        // palabras en minusculas, solo caracteres alfabeticos
        return words()
            .map(w -> w.replaceAll("[^a-zA-Z]", ""))
            .filter(w -> !w.isEmpty())
            .map(String::toLowerCase); // Convertir a minúsculas
    }

    public long wordCount() {
        // contar total de palabras
        return words().count();
    }

    public Set<String> uniqueWords() {
        // palabras unicas (limpiadas)
        return cleanWords().collect(toSet());
    }

    public List<Map.Entry<String, Long>> topN(int n) {
        // agrupar por palabra, contar, ordenar desc, limitar a n
        return cleanWords()
            .collect(groupingBy(w -> w, counting())) 
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(n)
            .collect(toList());
    }

    public double averageWordLength() {
        // longitud promedio de palabras limpias
        return cleanWords()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
    }

    public Map<Character, List<String>> wordsByFirstLetter() {
        // agrupar palabras unicas por primera letra
        return cleanWords()
            .distinct()
            .collect(groupingBy(w -> w.charAt(0)));
    }

    public static void main(String[] args) {
        List<String> text = List.of(
            "Java is a powerful programming language",
            "Java streams make data processing elegant",
            "Lambdas and streams are the heart of modern Java"
        );

        TextAnalyzer analyzer = new TextAnalyzer(text);

        System.out.println("=== Estadisticas de Texto ===");
        System.out.println("Total palabras: " + analyzer.wordCount());
        System.out.println("Palabras unicas: " + analyzer.uniqueWords().size());
        System.out.printf(Locale.US, "Longitud promedio: %.2f%n", analyzer.averageWordLength());

        System.out.println("\n=== Top 5 Palabras ===");
        analyzer.topN(5).forEach(e ->
            System.out.printf("  '%s': %d veces%n", e.getKey(), e.getValue()));

        System.out.println("\n=== Palabras por Letra ===");
        analyzer.wordsByFirstLetter().entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(e -> System.out.printf("  %c: %s%n", e.getKey(), e.getValue()));
    }
}