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
}
