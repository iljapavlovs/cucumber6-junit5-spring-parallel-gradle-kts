

### Resources:

* [Support for Junit 5 Issue Github](https://github.com/cucumber/cucumber-jvm/issues/1149#issuecomment-611716745)
  
* Docs:
  * [Cucumber Junit5, however still not in official phase](https://github.com/cucumber/cucumber-jvm/tree/main/junit-platform-engine#cucumber-junit-platform-engine)
* Examples:
    * [Spring Boot + Junit 5 + Parallel](https://github.com/mpkorstanje/cucumber-spring-boot-parallel)
    * [Junit 5](https://github.com/cucumber/cucumber-jvm/tree/main/examples/java-calculator-junit5)
    * [Spring](https://github.com/cucumber/cucumber-jvm/tree/main/examples/spring-txn)
    * [Working example with Junit5- CRONN](https://github.com/cronn/cucumber-junit5-example)
  

* issues:
  * [Afterall and beforeall hooks](https://github.com/cucumber/cucumber-jvm/pull/1876)
  


### Parallel execution
_For JUnit 5 we'll be using the JUnit platform which supports parallel execution. The way it's implemented allows scenarios to be executed in parallel. This will be an improvement over JUnit 4 which only allows features to be executed in parallel._




This seems to be a common point of confusion. It is worth reading the introduction of the documentation for JUnit 5.

But in brief Cucumber implements the TestEngine interface provided by the JUnit Platform. On the other hand @ExtendWith is a JUnit Jupiter annotation. These are two different parts of JUnit 5.

If you want to use JUnit 5 with Cucumber you can find all information you need here:

https://github.com/cucumber/cucumber-jvm/tree/master/junit-platform-engine

You will not find JUnit 5 advertised in other documentation yet. The tooling support for Junit Platform hasn't quite reached the point yet where I'd be comfortable changing that. And given that Cucumber JUnit works perfectly fine in combination with JUnit Vintage I see no reason too rush the upgrade either.

Internally Surefire and Gradle assume the old class based execution model. This means that Cucumber works less then stellar with these integrations. So I'm currently waiting for a few issues to be resolved here:

https://issues.apache.org/jira/browse/SUREFIRE-1724
gradle/gradle#4773
With respect to IDEA, there is no good way to use the JUnit Platform to run individual scenarios and so I'm waiting for:

https://youtrack.jetbrains.com/issue/IDEA-227508
junit-team/junit5#2146