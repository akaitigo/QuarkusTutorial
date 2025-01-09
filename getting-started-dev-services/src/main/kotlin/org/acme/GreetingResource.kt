package org.acme

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestQuery
@Path("/hello")
class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@RestQuery name: String?): String {
        return if (name.isNullOrBlank()) {
            "Hello"
        } else {
            "Hello $name"
        }
    }

    
}