plugins {
	kotlin("jvm")
	application
}

group = "com.romangraef"
version = "1.0-SNAPSHOT"

repositories {
	jcenter()
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("com.beust", "jcommander", "_")
	implementation("net.dv8tion", "JDA", "_")
	implementation("org.reflections", "reflections", "_")

	runtimeOnly("org.slf4j", "slf4j-simple", "_")
}

application {
	mainClassName = "com.romangraef.jdacommander.StartKt"
}
