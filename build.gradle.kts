import com.github.spotbugs.SpotBugsTask

allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}

plugins {
    java
    `java-library`
    maven
    idea
    id("org.springframework.boot") version "2.1.6.RELEASE" apply false
    id("org.jetbrains.kotlin.jvm") version "1.3.40" apply false
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.40" apply false
    id("com.github.spotbugs") version "1.6.10" apply false
    id("com.google.cloud.tools.jib") version "1.3.0"
}
group = "ta7uw"
version = "1.0-SNAPSHOT"

subprojects {
    apply {
        plugin("java")
        plugin("java-library")
        plugin("maven")
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("com.github.spotbugs")
        plugin("com.google.cloud.tools.jib")
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    tasks.withType<SpotBugsTask>().configureEach {
        reports {
            xml.isEnabled = false
            html.isEnabled = true
        }
    }

    jib {
        from {
            image = "adoptopenjdk/openjdk12:alpine-slim"
            credHelper = "osxkeychain"
        }
        to {
            // DokcerHub
            // image = "spring-boot-examples-${project.name}"
            // credHelper = "osxkeychain"

            // AWS ECR
            // image = "amazonaws.com/spring-boot-examples-${project.name}"
            // credHelper = "ecr-login"

            tags = setOf("latest", "${version}")
            auth {
                //username = "USERNAME"
                //password = "PASSWORD"
            }
        }
        container {
            useCurrentTimestamp = true
            labels = mapOf("maintainer" to " ta7uw")
            jvmFlags = listOf("-Duser.timezone=GMT+08")
            ports = listOf("8080")
            // args = listOf("some args")
        }
        // false -> We must use https
        setAllowInsecureRegistries(true)
    }


    dependencies {
        // lombok
        compileOnly("org.projectlombok:lombok:1.18.4")
        annotationProcessor("org.projectlombok:lombok:1.18.4")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.4")
        testCompileOnly("org.projectlombok:lombok:1.18.4")

        // spotbugs
        implementation("net.jcip:jcip-annotations:1.0")
        implementation("com.github.spotbugs:spotbugs-annotations:3.1.3")

        //elasticsearch
        implementation("org.elasticsearch.client:elasticsearch-rest-high-level-client:6.7.0")

        testImplementation("org.assertj:assertj-core:3.12.2")
        testImplementation("org.mockito:mockito-core:3.0.0")

        // Kotlin
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.40")
    }
}
