import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
            public static void main(String[] args) {
                Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3, 4));
                Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5, 6));

                Set<Integer> unionSet = new HashSet<>(set1);
                unionSet.addAll(set2);

                int targetSum = 21;

                int currentSum = unionSet.stream().mapToInt(Integer::intValue).sum();
                AtomicInteger excess = new AtomicInteger(currentSum - targetSum);

                if (excess.get() > 0) {
                    unionSet.removeIf(e -> {
                        excess.addAndGet(-e);
                        return excess.get() >= 0;
                    });
                }

                System.out.println( "Множества 1"+ set1+"\n"+"Множества 2"+set2+"\n"+"Сумма уникалных елементов "+targetSum);
            }
        }



