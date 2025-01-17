package org.acme.rabbitmq.producer

import org.acme.rabbitmq.model.Quote

import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import java.util.*
import io.smallrye.mutiny.Multi
import jakarta.ws.rs.GET

@Path("/quotes")
class QuotesResource {
    @Channel("quote-requests")
    var quoteRequestEmitter: Emitter<String>? = null

    /**
     * Endpoint to generate a new quote request id and send it to "quote-requests" channel (which
     * maps to the "quote-requests" RabbitMQ exchange) using the emitter.
     */
    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    fun createRequest(): String {
        val uuid = UUID.randomUUID()
        quoteRequestEmitter!!.send(uuid.toString())
        return uuid.toString()
    }

    @Channel("quotes")
    var quotes:Multi<Quote>? = null

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS) 
    fun stream():Multi<Quote>?  {
        return quotes
    }
}