package org.acme


import io.quarkus.example.Greeter
import io.quarkus.example.HelloReply
import io.quarkus.example.HelloRequest
import io.quarkus.grpc.GrpcClient
import io.smallrye.mutiny.Uni

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType


@Path("/hello")
class GreetingResource {

    @GrpcClient
    var hello: Greeter? = null

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from Quarkus REST"

    @GET
    @Path("/{name}")
    fun hello(name: String): Uni<String> {
        return hello!!.sayHello(
            HelloRequest.newBuilder()
                .setName(name)
                .build()
        ).onItem().transform { it.message }
    }
}