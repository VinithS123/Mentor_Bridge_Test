import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        // Finding second-highest number
        List<Integer> numbers = Stream.of(10, 45, 67, 23, 89, 54, 89).toList();
        int secondHighest = numbers.stream()
                .sorted((n1,n2)-> n2-n1)
                .distinct()
                .toList()
                .get(1);
        System.out.println("The second highest number is : "+secondHighest );

        // Finding first non-repeated number
        List<Integer> numbersList = Stream.of(4, 5, 1, 2, 0, 4, 5, 2).toList();
        int firstNonRepeated = numbersList.stream()
                .filter(number -> Collections.frequency(numbersList,number)==1)
                .toList()
                .getFirst();
        System.out.println("The first non repeated number is : "+ firstNonRepeated);


        //Finding duplicate elements in list
        List<Integer> numberList2 = Stream.of(10, 20, 30, 20, 40, 10, 50, 30).toList();
        List<Integer> duplicateNumbers =  numberList2.stream()
                .filter(number->Collections.frequency(numberList2,number)>1)
                .distinct()
                .toList();
        System.out.println("The duplicate element list is : "+ duplicateNumbers);


        // counting of appearance of numbers in list
        List<Integer> numberList3 = Stream.of(1, 2, 3, 2, 4, 1, 5, 1).toList();
        numberList3.stream().distinct().forEach(
                (number)-> System.out.println(number+" : "+Collections.frequency(numberList3,number)));

        // Finding top three numbers
        List<Integer> numberList4 = Stream.of(10, 80, 45, 60, 30, 90, 20).toList();
        List<Integer> topThreeNumbers = numberList4.stream()
                .sorted((num1,num2)->num2-num1)
                .limit(3)
                .toList();
        System.out.println("The top three numbers are : "+topThreeNumbers);



        //  Partition of even and odd numbers
        List<Integer> numberList5 = Stream.of(10, 15, 20, 25, 30, 35, 40).toList();
        Map<Boolean,List<Integer>> partitioned = numberList5.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));
        System.out.print("Even : ");
        partitioned.get(true).stream().forEach(num-> System.out.print(num+" "));
        System.out.print("\nOdd : ");
        partitioned.get(false).stream().forEach(num-> System.out.print(num+" "));
        System.out.println();

        // The number starts with 1
        List<Integer> numberList6 = Stream.of(10, 15, 23, 11, 45, 19, 30).toList();
        List<Integer> numberStartsWith1 = numberList6.stream()
                .filter(num->num.toString().startsWith("1"))
                .toList();
        System.out.println("The number starts with 1 are : " + numberStartsWith1);

        // Common numbers in two lists
        List<Integer> list1 = Stream.of(10, 20, 30, 40, 50).toList();
        List<Integer> list2 = Stream.of(30, 40, 60, 70).toList();
        List<Integer> commonNumbers = list1.stream()
                .filter(num->list2.contains(num))
                .toList();
        System.out.println("The Common numbers are : "+commonNumbers);

        // Finding sum of square of even numbers in a list
        List<Integer> numberList7 = Stream.of(1, 2, 3, 4, 5, 6).toList();
        int numberSquareSum = numberList7.stream()
                .filter(number->number % 2 ==0 )
                .map(num -> num * num)
                .mapToInt(e->e)
                .sum();
        System.out.println("The Square Sum of even number is : "+ numberSquareSum);


        // Group by even and odd numbers
        List<Integer> numberList8 = Stream.of(5, 10, 15, 20, 25, 30).toList();
        Map<String,List<Integer>> evenOddMap = numberList8.stream()
                .collect(Collectors.groupingBy(e->{
                        if(e % 2 == 0){
                            return "even";
                        }else{
                            return "odd";
                        }}));
        System.out.print("Even : ");
        evenOddMap.get("even").stream().forEach(num-> System.out.print(num+" "));
        System.out.print("\nOdd : ");
        evenOddMap.get("odd").stream().forEach(num-> System.out.print(num+" "));
        
    }
}
