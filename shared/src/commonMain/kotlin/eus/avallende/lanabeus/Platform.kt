package eus.avallende.lanabeus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform