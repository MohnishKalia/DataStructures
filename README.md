
# Welcome to the repository of code for Data Structures at Marquette University

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

---

# Personal IDEs

My main code editor has been [Visual Studio Code w/ Java Extension Pack](https://code.visualstudio.com/docs/languages/java).

For more structured classwork (and for working with the professor's code examples), I use [Eclipse IDE](https://www.eclipse.org/downloads/).

# Code Tips

## Use Streams

Those familiar to more modern or back-end driven languages may be accustomed to functional programming by way of [lambdas](https://en.wikipedia.org/wiki/Anonymous_function). Unfortunately, few people know that Java also carries this same programming style by way of streams.

Here is an implementation of an iteration, filter, and collect program in the imperative programming paradigm:

```[java]
ArrayList<Student> result = new ArrayList<>();

for (Student temp : col)
    if (temp.getName().length() >= minLength)
        result.add(temp);
```

Here is an example code snippet of a [stream](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/stream/package-summary.html) that does the same thing:

```[java]
col.stream()
   .filter(e -> e.getName().length() >= minLength)
   .collect(Collectors.toCollection(ArrayList<Student>::new));
```
