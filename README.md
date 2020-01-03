
# Data Structures

## Welcome to the repository of code for Data Structures at Marquette University

In plain terms, this repo contains the work I have done for the DS course @ MU

Inside of this repo, you will find...

- Code *Samples*
- Book Files
- Unit Tests
- Assignments

## For those that navigated here

A secondary welcome to you all.

This page contains some of the **base files** inside of the repository.

However, the majority of this page is devoted to my learning experience throughout the course.

Tips and good coding habits are paramount, and I hope to share some tricks that may benefit others in the long run.

# Personal IDEs

My main code editor has been [Visual Studio Code w/ Java Extension Pack](https://code.visualstudio.com/docs/languages/java).

For more structured classwork (and for working with the professor's code examples), I use [Eclipse IDE](https://www.eclipse.org/downloads/).

# Code Tips

## Use Streams

Those familiar to more modern or back-end driven languages may be accustomed to functional programming by way of [lambdas](https://en.wikipedia.org/wiki/Anonymous_function). Unfortunately, few people know that Java also carries this same programming style by way of streams.

Here is an implementation of an iteration, filter, and collect program in the imperative programming paradigm:

```[java]
List<Student> result = new ArrayList<>();

for (Student temp : col)
    if (temp.getName().length() >= minLength)
        result.add(temp);
```

Here is an example code snippet of a [stream](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/stream/package-summary.html) that does the same thing:

```[java]
List<Student> result = col.stream()
                          .filter(e -> e.getName().length() >= minLength)
                          .collect(Collectors.toCollection(ArrayList<Student>::new));
```

Streams do not modify the source in any way, are lazily evaluated, and have hidden boosts to efficiency. Most importantly, they are much cleaner to write and can be self-documenting when written correctly. Just use streams please!

## Make Tests

Regardless of whether or not you are being asked to write code for a CS teacher or a multi-billion dollar company, you **will** be asked to write tests.

Unfortunately, many people do not know how to write unit tests, so for this demonstration I will use [JUnit 5](https://junit.org/junit5/), available on Maven Central or Eclipse.

When writing a test, the method must have a return type of `void`, take no parameters, and be preceded with the `@Test` annotation. This tells JUnit that you are creating a test method.

Naming conventions for the test method vary between organizations, but I personally use a templated style when writing my tests.

```[java]
@Test
void testMethodName_TestCase() {
    // code to test goes here
}
```

What goes inside your method depends on your specific use case, but I will go over some of the most common test methods or *assertations* that are used.
Note: In order to use these methods, you must first statically import the Assertions library.

```[java]
import static org.junit.jupiter.api.Assertions.*;
```

- `assertEquals(Object expected, Object actual)` will check if 2 objects are equal using their `.equals()` method
- `assertThrows​(Class<T> expectedType, Executable executable)` will check if an error is thrown within a block of code
- `assertTrue​(boolean condition)` will check if the supplied boolean expression evaluates to true
- `assertNotNull​(Object actual)` will check if the supplied object is not null

While the other assertations are rather straightforward, `assertThrows` is slightly different but still extremely useful in checking if exceptions are thrown. In order to get the desired effect, there is a syntax involving the class reflection API and the function API.

```[java]
@Test
public void testRemoveLast_Empty() {
    assertThrows(QueueUnderflowException.class, () -> {
        empty.removeLast();
    });
}
```

Here is an example of a test case used in one of my assignments.

```[java]
@Test
public void testEqBal_OneMatch() {
    Map<String, BankAccount> accountMap = new HashMap<>();

    accountMap.put("101", new BankAccount(1000));
    accountMap.put("102", new BankAccount(2500));
    accountMap.put("103", new BankAccount(1000));
    accountMap.put("104", new BankAccount(3000));

    assertEquals("Account numbers [101, 103] with equal balance of 1000",
            displayAccountsWithEqualBalances(accountMap));
}
```

Whenever possible, please write the test **before you start writing the program**. Doing so will allow you to check progress without going too far beyond the scope of the assignment.
