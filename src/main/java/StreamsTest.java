import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {

        // find second highest number
        List<Integer> numberList = Stream.of(10, 45, 67, 23, 89, 54, 89).toList();
        int secondHighest = numberList.stream()
                .sorted((num1,num2)-> num2 - num1)
                .toList()
                .get(1);
        System.out.println("Second highest number : " + secondHighest);

        // find first non repeated number
        List<Integer> numberList1 = Stream.of(4, 5, 1, 2, 0, 4, 5, 2).toList();
        int firstNonRepeated = numberList1.stream()
                .filter(num1-> Collections.frequency(numberList1,num1)==1)
                .findFirst().get();
        System.out.println("First non repeated character : "+firstNonRepeated);

        //find duplicate numbers
        List<Integer> numberList2 = Stream.of(10, 20, 30, 20, 40, 10, 50, 30).toList();
        List<Integer> duplicateNumbers = numberList2.stream()
                .filter(num->Collections.frequency(numberList2,num)>1)
                .distinct()
                .toList();
        System.out.println("The duplicate numbers are "+duplicateNumbers);


        // count frequency of each number
        List<Integer> numberList3   =  Stream.of(1, 2, 3, 2, 4, 1, 5, 1).toList();
        numberList3.stream()
                .distinct()
                .forEach(num->System.out.println(num + " : " + Collections.frequency(numberList3,num)));

        // top three highest numbers
        List<Integer> numberList4 = Stream.of(10, 80, 45, 60, 30, 90, 20).toList();
        List<Integer> firstThreeNumbers = numberList4.stream()
                .sorted((num1,num2)->num2-num1)
                .limit(3)
                .toList();
        System.out.println("Top three numbers are " + firstThreeNumbers);

        // partition into even and odd
        List<Integer> numberList5 = Stream.of(10, 15, 20, 25, 30, 35, 40).toList();
        Map<Boolean,List<Integer>> evenAndOddMap =
                numberList5.stream()
                        .collect(Collectors.partitioningBy(num->num % 2==0));
        System.out.println("Even : "+evenAndOddMap.get(true));
        System.out.println("Odd : "+evenAndOddMap.get(false));


        // find number starting with digit 1
        List<Integer> numberList6 = Stream.of(10, 15, 23, 11, 45, 19, 30).toList();
        List<Integer> numbersStartWithOne = numberList6.stream()
                .filter(num1->num1.toString().startsWith("1"))
                .toList();
        System.out.println("The numbers start with one : "+numbersStartWithOne);


        // common elements between two list
        List<Integer> list1 = Stream.of(10, 20, 30, 40, 50).toList();
        List<Integer> list2 = Stream.of(30, 40, 60, 70).toList();
        List<Integer> commonNumbers = list1.stream()
                .filter(num->list2.contains(num))
                .distinct()
                .toList();
        System.out.println(" Common elements between two lists : " +commonNumbers);

        // group even and odd
        List<Integer> numberList7 = Stream.of(5, 10, 15, 20, 25, 30).toList();
        Map<Boolean,List<Integer>> evenOddMap = numberList7.stream()
                .collect(Collectors.groupingBy(num->num%2==0));
        System.out.println("even :"+evenOddMap.get(true));
        System.out.println("odd : "+evenOddMap.get(false));


        // sum of squares of even numbers
        List<Integer> numberList8 =Stream.of(1, 2, 3, 4, 5, 6)
                .toList();
        int evenNumberSum = numberList8.stream()
                .filter(num->num%2==0)
                .mapToInt(num->num*num)
                .sum();
        System.out.println("Square sum of even numbers : "+evenNumberSum);
        
    }
}
