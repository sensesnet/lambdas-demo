package com.sensesnet.lambdas.demo.ex16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {

        System.out.println(factorial(5));

        //You have a list numbers:
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        //[1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
        List<Integer> generatedA = numbers.stream()
                .flatMap(n -> Stream.generate(() -> n).limit(n))
                .collect(Collectors.toList());

        //[1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5]
        List<Integer> generatedB = numbers.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, n))
                .boxed()
                .collect(Collectors.toList());

        //[1, 2, 3, 3, 4, 5, 4, 5, 6, 7, 5, 6, 7, 8, 9]
        List<Integer> generatedC = numbers.stream()
                .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
                .boxed()
                .collect(Collectors.toList());

        //[1, 2, 3, 4, 5]
        List<Integer> generatedD = numbers.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList());

        System.out.println(generatedA);
        System.out.println(generatedB);
        System.out.println(generatedC);
        System.out.println(generatedD);


        Department department1 = new Department ("dep-1","111-1",
                List.of(new Employee("William",20000L),new Employee("Sophia",10000L)));

        Department department2 = new Department ("dep-2","222-1",
                List.of(new Employee("John",50000L)));
        System.out.println(calcNumberOfEmployees(List.of(department1,department2),20000));


    }

    //The factorial of n is calculated by the product of integer number from 1 to n (inclusive).
    // The factorial of 0 is equal to 1.
    public static long factorial(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (acc, elem) -> acc * elem);
    }

    //Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.
    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .filter(x -> x % 2 != 0)
                .reduce(0, Long::sum);
    }


    /*
    You have two classes: Employee (name: String, salary: Long) and Department (name: String, code: String, employees: List<Employee>).
    Both classes have getters for all fields with the corresponding names (getName(), getSalary(), getEmployees() and so on).
    Write a method using Stream API that calculates the general number of employees with salary >= threshold for all
    departments whose code starts with string "111-" (without ""). Perhaps, flatMap method can help you to implement it.
    Classes Employee and Department will be available during testing. You can define your own classes for local testing.
    Important. Use the given template for your method. Pay attention to type of an argument and the returned value.
    Please, use only Stream API, no cycles.
    Examples: there are 2 departments (in JSON notation) below and threshold = 20 000.
    The result is 1 (because there is only one suitable employee).

    [
  {
    "name": "dep-1",
    "code": "111-1",
    "employees": [
      {
        "name": "William",
        "salary": 20000
      },
      {
        "name": "Sophia",
        "salary": 10000
      }
    ]
  },
  {
    "name": "dep-2",
    "code": "222-1",
    "employees": [
      {
        "name": "John",
        "salary": 50000
      }
    ]
  }
]
     */

    static class Department {
        String name, code;
        List<Employee> employees;

        public Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    static class Employee {
        String name;
        Long salary;

        public Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }
    }

    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(depart -> depart.getCode().startsWith("111-"))
                .flatMap(depart -> depart.getEmployees().stream()
                        .filter(employer -> employer.getSalary() >= threshold)).count();
    }


}
