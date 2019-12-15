rootProject.name = "spring-boot-examples"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        jcenter()
    }
}

include("api")
include("batch")
include("common")
include("data")
