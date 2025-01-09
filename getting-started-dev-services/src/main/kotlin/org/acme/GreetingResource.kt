package org.acme

import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestQuery
@Path("/hello")
class GreetingResource {

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@QueryParam("name") name: String?): String {
        var greeting = Greeting()
        greeting.name = name.toString()
        greeting.persist()
        return "Hello $name"
    }

    
}