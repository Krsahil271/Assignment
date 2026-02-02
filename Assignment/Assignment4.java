import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String dept;
    int salary;
    List<String> skills;

    Employee(int id, String name, String dept, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.skills = skills;
    }

    public String toString() {
        return name + " | " + dept + " | " + salary;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
                new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
                new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
                new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
                new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring"))
        );

        List<Employee> t1 = employees.stream()
                .filter(e -> e.salary > 60000)
                .toList();

        List<String> t2 = employees.stream()
                .map(e -> e.name)
                .toList();

        Set<String> t3 = employees.stream()
                .map(e -> e.name)
                .collect(Collectors.toSet());

        List<Employee> t4 = employees.stream()
                .sorted((a, b) -> b.salary - a.salary)
                .toList();

        List<Employee> t5 = employees.stream()
                .sorted((a, b) -> b.salary - a.salary)
                .skip(1)
                .limit(2)
                .toList();

        Set<String> t6 = employees.stream()
                .flatMap(e -> e.skills.stream())
                .collect(Collectors.toSet());

        int t7 = employees.stream()
                .map(e -> e.salary)
                .reduce(0, Integer::sum);

        double t8 = employees.stream()
                .map(e -> e.salary)
                .reduce(0, Integer::sum)
                / (double) employees.stream().count();

        Map<String, List<Employee>> t9 = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));

        Map<String, Employee> t10 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.dept,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(e -> e.salary)),
                                        Optional::get
                                )
                        )
                );

        List<String> t11 = employees.stream()
                .filter(e -> e.dept.equals("IT"))
                .filter(e -> e.salary > 60000)
                .flatMap(e -> e.skills.stream())
                .distinct()
                .sorted()
                .limit(3)
                .toList();

        Map<String, Map<String, Double>> t12 =
                employees.stream().collect(
                        Collectors.groupingBy(
                                e -> e.dept,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            double total = list.stream()
                                                    .map(e -> e.salary)
                                                    .reduce(0, Integer::sum);

                                            double count = list.size();
                                            double avg = total / count;

                                            Map<String, Double> m = new HashMap<>();
                                            m.put("total", total);
                                            m.put("average", avg);
                                            m.put("count", count);
                                            return m;
                                        }
                                )
                        )
                );

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
        System.out.println(t7);
        System.out.println(t8);
        System.out.println(t9);
        System.out.println(t10);
        System.out.println(t11);
        System.out.println(t12);
    }
}
