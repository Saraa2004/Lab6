import org.gradle.kotlin.dsl.registering

plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.24.0"
}

repositories {
    mavenCentral()
}

val runPerformance by tasks.registering(JavaExec::class) {
    mainClass.set("it.unibo.collections.TestPerformance")
    classpath(sourceSets.main.get().runtimeClasspath)
}

tasks.run.get().dependsOn(runPerformance)

application {
    mainClass.set("it.unibo.collections.UseListsAndMaps")
}

spotbugs {
    omitVisitors.set(listOf("MethodReturnCheck"))
}
