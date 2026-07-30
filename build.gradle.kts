plugins {
    `java-library`
    id("net.fabricmc.fabric-loom") version "1.15.5"
}

group = "me.choketa"
version = "1.0-SNAPSHOT"

val minecraftVersion = "26.1.2"
val loaderVersion = "0.19.3"
val apiVersion = "0.155.2+26.1.2"

repositories {
    maven("https://maven.fabricmc.net/")
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    implementation("net.fabricmc:fabric-loader:$loaderVersion")
    implementation("net.fabricmc.fabric-api:fabric-api:$apiVersion")
}
fabricApi {
    configureDataGeneration {
        client = true
    }
}


tasks.named<Copy>("processResources") {
    val currentVersion = project.version
    inputs.property("version", currentVersion)
    filesMatching("fabric.mod.json") {
        expand(mapOf("version" to currentVersion))
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
}

configure<JavaPluginExtension> {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
    val projectName = project.name
    inputs.property("projectName", projectName)
    from("LICENSE") {
        rename { "${it}_$projectName" }
    }
}