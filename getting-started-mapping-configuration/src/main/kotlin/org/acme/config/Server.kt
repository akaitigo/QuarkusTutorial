
import io.smallrye.config.ConfigMapping
import io.smallrye.config.WithName

@ConfigMapping(prefix = "server")
interface Server {
    @WithName("name")
    fun host(): String?

    fun port(): Int

    fun log(): Log?

    interface Log {
        fun enabled(): Boolean

        fun suffix(): String?

        fun rotate(): Boolean
    }
}