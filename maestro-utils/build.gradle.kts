import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("maven-publish")
    id("kotlin")
    id("idea")
    id("com.vanniktech.maven.publish")
}

dependencies {
    api(libs.square.okio)

    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.google.truth)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_1_8
    }
}

plugins.withId("com.vanniktech.maven.publish") {
    mavenPublish {
        sonatypeHost = SonatypeHost.S01
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
