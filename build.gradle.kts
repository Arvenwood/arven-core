import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.31"
    kotlin("kapt") version "1.3.31"

    id("com.github.johnrengelman.shadow") version "4.0.4"
}

val implementation by project.configurations
implementation.isCanBeResolved = true

group = "arven"
version = "0.3.0"

repositories {
    mavenCentral()
    jcenter()
    maven {
        setUrl("https://jitpack.io")
    }
    maven {
        setUrl("https://repo.spongepowered.org/maven")
    }
    maven {
        setUrl("https://kotlin.bintray.com/kotlinx")
    }
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.2.1")

    // Sponge
    kapt("org.spongepowered:spongeapi:7.1.0")
    compileOnly("org.spongepowered:spongeapi:7.1.0")

    // Config System
    implementation("com.github.TheFrontier:SKD:094ab59a02")

    // Sponge Platform extension methods
    implementation("com.github.TheFrontier:SKE:0.3.0")

    // Feature System
    implementation("com.github.TheFrontier:SKF:0.3.0")

    // Command Tree System
    implementation("com.github.TheFrontier:SKPC:0.3.0")

    // Database ORM
    implementation("org.jetbrains.exposed:exposed:0.13.6")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<ShadowJar> {
    this.classifier = "dist"
    this.configurations = listOf(implementation)

    dependencies {
        exclude(dependency("org.slf4j:slf4j-api:.*"))
        exclude(dependency("com.h2database:h2:.*"))
    }
}