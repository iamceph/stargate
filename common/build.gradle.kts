plugins {
    kotlin("jvm")
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("reflect"))

    api(gradleKotlinDsl())

}