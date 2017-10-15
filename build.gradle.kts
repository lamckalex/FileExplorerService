group = "com.github.tobycatapps"
version = "1.0.0"

plugins {
    java
    application
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClassName = "fileExplorerService.Main"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    testCompile("junit:junit:4.12")
    testCompile("org.mockito:mockito-all:2.0.2-beta")
}
