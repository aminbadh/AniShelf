package aminbadh.anishelf

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform