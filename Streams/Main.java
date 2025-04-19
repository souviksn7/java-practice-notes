package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Creating stream

        // From collection
        List<Integer> salaryList = Arrays.asList(1,3,6,8,2,6,9);
        Stream<Integer> streamFromInteger = salaryList.stream();

        // From array
        Integer[] salaryArray = {1,3,5,8,2,8,4};
        Stream<Integer> streamFromArray = Arrays.stream(salaryArray);

        // From static method
        Stream<Integer> streamFromStaticMethod = Stream.of(1,3,5,8,2,8,4);

        // From stream builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1).add(3).add(5).add(8).add(2).add(8).add(4);

        Stream<Integer> streamFromBuilder = streamBuilder.build();

        // From Stream Iterator
        Stream<Integer> steamFromIterator = Stream.iterate(100, ((Integer n) -> n+10)).limit(10);

        // Intermediate Operation
        Stream<String> nameStream = Stream.of("Hello", "Everyone", "How", "Are", "You");

        // filter(Predicate<T> predicate)
        // Stream<String> filteredStream = nameStream.filter((name)-> name.length()<=3 );

        // map(Function<T,R> mapper)
        // Stream<String> filteredNames = nameStream.map(name -> name.toLowerCase());

        // flatMap(Function<T, Stream<R>> mapper)
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I", "Love", "Java"),
                Arrays.asList("Concepts", "Are", "Clear"),
                Arrays.asList("Its", "Very", "Easy")
        );
        Stream<String> wordsStream1 = sentenceList.stream().flatMap((List<String> sentence) -> sentence.stream().map(word -> word.toLowerCase()));

        // distinct
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> arrStream = Arrays.stream(numbers).distinct();

        // Sorted
        Integer[] numbers1 = {11,2,15,4,5,6,7,8,9,10};
        Stream<Integer> sortedStream = Arrays.stream(numbers1).sorted();

        Stream<Integer> sortedStreamDecreasing = Arrays.stream(numbers1).sorted((Integer n1, Integer n2) -> n2 - n1);

    }
}