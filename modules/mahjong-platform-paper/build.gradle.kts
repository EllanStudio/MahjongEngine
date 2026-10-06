plugins {
    `java-library`
}

val paperApiVersion = providers.gradleProperty("paperApiVersion")
    .orElse("26.3.build.157-beta")
    .get()

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
}

dependencies {
    implementation(project(":mahjong-application"))
    implementation(project(":mahjong-domain"))
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
}
