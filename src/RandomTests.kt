import java.time.Instant.now

fun main() {
    test1()
}
fun test1(): String {
    loop@ while (true) {
        println("1")
        return when (now().toEpochMilli()) {
            5L -> "hello"
            6L -> "nono"
            else -> {
                println("Hello")
                continue@loop
            }
        }
    }
}