//import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
//import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
//import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
//
//plugins {
//    java
//    idea
//}
//
//java {
//    sourceCompatibility = JavaVersion.VERSION_11
//    targetCompatibility = JavaVersion.VERSION_11
//}
//
//group = "io.iljapavlovs"
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
////    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
////    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:1.7.0'
//
//
//    testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release") {
//        because("we want to use JUnit 5")
//    }
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:latest.release") {
//        because("Cucumber relies on jupiter-engine to resolve tests")
//    }
//    testImplementation("io.cucumber:cucumber-java:6.9.1")
//    testImplementation("io.cucumber:cucumber-junit-platform-engine:6.9.1")
////    testImplementation 'io.cucumber:junit-jupiter-api:5.7.0'
////    testImplementation 'io.cucumber:junit-jupiter-api:5.7.0'
////    testImplementation 'io.cucumber:junit-jupiter-api:5.7.0'
//
//    testImplementation("org.projectlombok:lombok:1.18.10")
//    testImplementation("org.assertj:assertj-core:3.11.1")
//
//}
//
////test {
////    useJUnitPlatform()
////}
//
tasks {
////
////    withType<Test> {
////        useJUnitPlatform()
////        testLogging {
////            events = setOf(PASSED, SKIPPED, FAILED)
////        }
////    }
////
////    val consoleLauncherTest by registering(JavaExec::class) {
////        dependsOn(testClasses)
////        val reportsDir = file("$buildDir/test-results")
////        outputs.dir(reportsDir)
////        classpath = sourceSets["test"].runtimeClasspath
////        main = "org.junit.platform.console.ConsoleLauncher"
////        args("--scan-classpath")
////        args("--include-engine", "cucumber")
////        args("--reports-dir", reportsDir)
////    }
////
////    test {
////        dependsOn(consoleLauncherTest)
////        exclude("**/*")
////    }
////
////
////
    val consoleLauncherTest by registering(JavaExec::class) {
        dependsOn(testClasses)
        val reportsDir = file("$buildDir/test-results")
        outputs.dir(reportsDir)
        classpath = sourceSets["test"].runtimeClasspath
        main = "org.junit.platform.console.ConsoleLauncher"
        args("--scan-classpath")
        args("--include-engine", "cucumber")
        args("--reports-dir", reportsDir)
    }

    test {
        dependsOn(consoleLauncherTest)
        exclude("**/*")
    }
}
//
//tasks {
////    withType<Test> {
////        useJUnitPlatform()
////        testLogging {
////            events = setOf(PASSED, SKIPPED, FAILED)
////        }
////    }
//
//    test {
//        ignoreFailures = true
//        systemProperties(System.getProperties().toMap() as Map<String, Object>)
////        systemProperty("cucumber.execution.parallel.enabled", System.getProperty("test.parallel", "false"))
//        systemProperty("cucumber.plugin", "json:build/reports/cucumber.json")
//        useJUnitPlatform {
//            excludeTags("disabled")
//        }
//    }
//}


plugins {
    java
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release") {
        because("we want to use JUnit 5")
    }
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:latest.release") {
        because("Cucumber relies on jupiter-engine to resolve tests")
    }
    testImplementation("io.cucumber:cucumber-java:latest.release") {
        because("we want to use Cucumber JVM")
    }
    testImplementation("io.cucumber:cucumber-junit-platform-engine:latest.release") {
        because("we want to use Cucumber with JUnit 5")
    }
    testImplementation("io.cucumber:cucumber-picocontainer:latest.release") {
        because("we want to use dependency injection in our Cucumber tests")
    }

//    testImplementation("org.assertj:assertj-core:3.11.1")
}

//tasks {
//    test {
//        ignoreFailures = true
//        systemProperties(System.getProperties().toMap() as Map<String, Object>)
//        systemProperty("cucumber.execution.parallel.enabled", System.getProperty("test.parallel", "false"))
//        systemProperty("cucumber.plugin", "json:build/reports/cucumber.json")
//        useJUnitPlatform {
//            excludeTags("disabled")
//        }
//    }
//}
