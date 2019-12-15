import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks {
    "jar"(Jar::class) {
        enabled = true
    }

    "bootJar"(BootJar::class) {
        enabled = false
    }
}

dependencies {
    api("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0")
    runtimeOnly("mysql:mysql-connector-java:8.0.16")
}
