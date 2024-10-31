package com.example.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * These coding kata on the Stream API can all be completed with a single return line.
 */
public class GentlyDownTheStream {

    protected List<String> fruits;
    protected List<String> veggies;
    protected List<Integer> integerValues;

    public GentlyDownTheStream() {
        fruits = Arrays.asList("Apple", "Orange", "Banana", "Pear", "Peach", "Tomato");
        veggies = Arrays.asList("Corn", "Potato", "Carrot", "Pea", "Tomato");
        integerValues = new Random().ints(0, 1001)
                                    .boxed()
                                    .limit(1000)
                                    .collect(Collectors.toList());
    }

    // returns a list of sorted fruits based on the fruits list

    public List<String> sortedFruits()
    {
        return fruits.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // returns a list of sorted fruits with all fruits filtered out that start with "A"

    public List<String> sortedFruitsException()
    {
        return fruits.stream()
                .filter(fruit -> !fruit.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    // returns a list with the first 2 elements of a sorted list of fruits

    public List<String> sortedFruitsFirstTwo()
    {
        return fruits.stream()
                .sorted()
                .limit(2)
                .collect(Collectors.toList());
    }

    // returns a comma separated String of sorted fruits

    public String commaSeparatedListOfFruits()
    {
        return fruits.stream()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    // returns a list of veggies that are sorted in reverse (descending) order

    public List<String> reverseSortedVeggies()
    {
        return veggies.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // returns a list of veggies that are sorted in reverse order, and all in upper case

    public List<String> reverseSortedVeggiesInUpperCase()
    {
        return veggies.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // returns a list of the top 10 values in the list of random integers

    public List<Integer> topTen()
    {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }

    // returns a list of the top 10 unique values in the list of random integers

    public List<Integer> topTenUnique()
    {
        return integerValues.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }

    // returns a list of the top 10 unique values in the list of random integers that are odd

    public List<Integer> topTenUniqueOdd()
    {
        return integerValues.stream()
                .filter(num -> num % 2 != 0)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }

    // returns a single value that represents the average of all of your random numbers

    public Double average()
    {
        return integerValues.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}
