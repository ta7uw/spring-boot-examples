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
    implementation(project(":data"))
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-autoconfigure")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.9")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.3")

    testApi("org.springframework.boot:spring-boot-starter-test")
}
