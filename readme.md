###Understanding lambda expressions
By lambda expression we mean an anonymous function that allows to use code as data and pass it as an argument to a method.
In previous versions of java many developers used anonymous classes for these purposes. But this solution had some problems: a code was unclear and had redundancy.

Let's see an example.
```
Callable<Integer> callable = new Callable<Integer>() { 
@Override
public Integer call() throws Exception {
return 10;
}};
```


If we use Java 8+ we can rewrite this code more simple and clear with the lambda:

Callable<Integer> callable = () -> 10;
The Callable<V> interface is often used in multithreading programming with lambdas, but in this 
example it is not important. The main thing is it may be instanced with a lambda expression 
because the interface has only one non-static and non-default method.

###Writing lambda expressions
A lambda expression has two parts: the part before the arrow operator "->" are the parameters 
and the part following the "->" is its body.

There are a lot of ways to write lambda expressions in Java 8. Let's consider some examples.
```
// a simple way to write a lambda expression
BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;

// if the only one argument
Function<Integer, Integer> identity = x -> x; // (x) -> x; is valid too

// without type inference
Function<Integer, Integer> mult = (Integer x) -> x * 2;

// with multiple statements
Function<Integer, Integer> adder = (x) -> {
x += 5;
x += 10;
return x;
};
```

The code before operator "=" is not important now, but you should know Function<T, R> 
is an interface for representing functions.

Additional explanations:

**BiFunction<T, U, R>** is an interface representing function with two arguments of types T and U. 
It returns value of type R.
**Function<T, R>** is also a special interface but it has only one argument of type T 
and returns value of type R.

**Functional interface** is an interface with a single abstract method (SAM type). Static and default methods are allowed here. Any functional interface can be implemented using lambda expressions, methods references or anonymous classes.

Examples: Runnable, Callable<V>, Comparator<T>, ActionListener and others.

IMPORTANT: you can't extend class (even abstract), enum or annotation by a lambda expression or a method reference.

There is a special annotation @FunctionalInterface exists in The Java Class Library. It marks functional interfaces and indicates if the interface doesn't satisfy the requirements of a functional interface. The annotation is not mandatory for creating lambda expressions but it's recommended to mark functional interfaces.

Let's declare our own generic functional interface for representing a simple function with one argument. See code below.

```@FunctionalInterface
public interface Fun<T, R> {
R apply(T t);

    static void doNothingStatic() { }
    default void doNothingByDefault() { }
}
```

Now we can create an instance of Fun<Double, Double> using lambda expression.

```
Fun<Double, Double> fun = (x) -> x * 2 + 1;
```
It means the fun accepts Double value  x and returns other double value (x * 2 + 1).

To get result we call the apply method of the functional interface. It's just like an object.
```
double result = fun.apply(3d);
```

Since java 8 the JCL has a lot of functional interfaces that represent functions. These functional interfaces are in java.util.function.
The package contains more than 40 functional interfaces of five groups: functions, operators, predicates, suppliers and consumers.

Let's consider these groups.
**Functions** accept arguments and produce results.
**Operators** produce results of the same type as their arguments (special case of function).
**Predicates** return boolean values and accept any arguments (boolean-valued function).
**Suppliers** return values and accept nothing.
**Consumers** accept arguments and return no result.
Main differences between functional interfaces in the same group are number of arguments and generic or not.

Some examples:
**Function<T, R>** accepts a value of type T and produces a result of type R.
**BiFunction<T, U, R>** accepts two values of T and U types and produces a result of type R.
**LongFunction<R>** accepts a long value and produces a result of type R.
**IntToDoubleFunction** accepts an integer value and produces a double value.
**IntPredicate** accepts an integer value and returns boolean value.
**Supplier<T>** returns a value of type T.
**BiConsumer<T, U>** accepts two values of T and U types.
And others...

For details see https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Sometimes we will use generic interfaces and sometimes non-generic.

Examples
Let's consider some functional interfaces.

```
// generator accepts nothing and returns integer value 3
IntSupplier generator = () -> 3;

final int factor = 2;

// multiplier accepts an integer value and returns another one, it uses closure
IntUnaryOperator multiplier = val -> factor * val;

// predicate isEven accepts an integer value and returns true if the value is even else false
IntPredicate isEven = val -> val % 2 == 0;

// printer accepts a value and prints it in the standard out, it returns nothing
Consumer<String> printer = System.out::println;
```

As you can see, types of interfaces (left) and type of lambdas (right) has the same semantic meaning. Actually, parameters and returned value of lambda corresponds to parameters and returned value of the SAM in a functional interface.

IntSupplier has a method int getAsInt() that corresponds to lambda () -> 3 in the example above.
Also, IntPredicate has a method boolean test(int value) that corresponds to lambda val -> val % 2 == 0.
Function composition is a powerful mechanism for combining functions to build more complicated functions.

COMPOSING FUNCTIONS

In java 8, the functional interface Function<T, R> has two default methods compose(...) and andThen(...) for composing new functions. The main difference between these methods is the execution order.

Generally, f.compose(g).apply(x) is the same as f(g(x)), and f.andThen(g).apply(x) is the same as g(f(x)).

Let's see an example with two functions: adder and multiplier.
```
Function<Integer, Integer> adder = x -> x + 10;
Function<Integer, Integer> multiplier = x -> x * 5;

// compose: adder(multiplier(5))
System.out.println("result: " + adder.compose(multiplier).apply(5));

// andThen: multiplier(adder(5))
System.out.println("result: " + adder.andThen(multiplier).apply(5));
```

In this case method compose returns a composed function that first applies multiplier to its input, and then applies adder to the result. Method andThen returns a composed function that first applies adder to its input, and then applies multiplier to the result.
```
The result of this program:
result: 35
result: 75
```
COMPOSING PREDICATES

The functional interface IntPredicate (as well as other predicates) has three methods for composing new predicates: and(...), or(...) and negate(...). The meaning is clear from the names.

Let's assume we have List<Integer> numbers filled by integer numbers from 1 to 30 (inclusive).
We'd like to print only those numbers which are odd or can be divided by 3 (i.e. x % 3 == 0).

The code to do it is shown below.
```
IntPredicate isEven = x -> x % 2 == 0;
IntPredicate dividedBy3 = x -> x % 3 == 0;
IntPredicate pred = isEven.negate().or(dividedBy3);

// print all odd values and even values that can be divided by 3.
numbers.forEach(val -> {
if (pred.test(val)) System.out.print(val + " ");
});
```
The result of this program:
```
1 3 5 6 7 9 11 12 13 15 17 18 19 21 23 24 25 27 29 30
```
By this, we finish our consideration of functional interfaces and java.util.function.