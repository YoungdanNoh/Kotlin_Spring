plugins {
    java
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm")
    kotlin("plugin.spring") version "1.3.72"
    /*
    * @RestController, @Service, @Configuration, @Validated 등이 붙은 클래스에 대해 자동으로 open 처리해준다.
    * */
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    /*
    * Spring Framework는 자바 리플렉션을 기본으로 하지만,
    * Kotlin은 자바와 다르게 nullable, default value, data class 등 자체 문법이 많습니다.
    * 이걸 Spring이 이해하려면 kotlin-reflect를 통해 Kotlin 메타정보를 읽을 수 있어야 합니다.
    * */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
