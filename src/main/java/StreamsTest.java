import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {

        // find even numbers
        List<Integer> numberList1 = Stream.of(10,15,8,49,25,98,32).toList();
        List<Integer> evenNumberList = numberList1.stream()
                .filter(e-> e%2==0)
                .toList();
        System.out.println("Even Number list : "+evenNumberList);


        // sort in descending order
        List<Integer> sortedList2 = Stream.of(10,15,8,49,25,98,98,32,15)
                .sorted((e1,e2)->e2-e1)
                .toList();
        System.out.println("Elements in descending order :"+ sortedList2);


        // Map of name and their length
        List<String> nameList = Stream.of("John","Alice","Bob").toList();
        Map<String,Integer> nameLengthMap = nameList.stream()
                .collect(Collectors.toMap(e->e, e-> e.length()));
        System.out.println("Length of names :"+nameLengthMap);


        // finding unique elements
        List<Integer> numberList3 = Stream.of(1, 2, 2, 3, 4, 4, 4, 5).toList();
        List<Integer> uniqueElementList = numberList3.stream().distinct().toList();
        System.out.println("The unique elements are : "+ uniqueElementList);


        // finding duplicate numbers
        List<Integer> numberList4 = Stream.of(10,15,8,49,25,98,98,32,15).toList();
        List<Integer> duplicateElements = numberList4.stream()
                .collect(Collectors.groupingBy(
                        e->e,
                        Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e->e.getValue()>1)
                        .map(e->e.getKey())
                        .toList();
        System.out.println("The duplicate elements are : "+duplicateElements);


        // The duplicate element and its count
        List<String> wordList = Stream.of("AA","BB","AA","CC").toList();
        Map<String,Long> duplicateMap = wordList.stream()
                .collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet()
                .stream().filter(e->e.getValue()>1)
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue()));

        System.out.println("The duplicate map and count are : " + duplicateMap);

    }
}
