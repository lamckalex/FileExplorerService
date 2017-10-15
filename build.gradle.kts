group = "com.github.tobycatapps"
version = "1.0.0"

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${Version.SPRING}")
	}
}

plugins {
	kotlin("jvm")
	application
	id("org.springframework.boot").version(Version.SPRING)
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
	compile(kotlin("stdlib"))
	compile(kotlin("reflect"))
	compile("org.springframework.boot:spring-boot-starter-web") {
		exclude(module = "spring-boot-starter-tomcat")
	}
	compile("org.springframework.boot:spring-boot-starter-jetty")
	compile("org.springframework.boot:spring-boot-starter-actuator")

	testCompile(kotlin("test"))
	testCompile("junit:junit:4.12")
	testCompile("org.mockito:mockito-all:2.0.2-beta")
}
