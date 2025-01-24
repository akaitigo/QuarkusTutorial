import com.google.cloud.storage.Storage

import jakarta.inject.Inject;
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/storage")
class StorageResource {
    @Inject
    var storage: Storage? = null // Inject Storage

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun storage(): String {
        val bucket = storage!!["test-nakayama"] // Get the bucket
        val blob = bucket["hello.txt"] // Get the object
        return String(blob.getContent()) // Return its content
    }
}