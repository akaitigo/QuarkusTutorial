package org.acme

import io.quarkus.example.Greeter
import io.quarkus.example.HelloReply
import io.quarkus.example.HelloRequest
import io.quarkus.grpc.GrpcService
import io.smallrye.mutiny.Uni

@GrpcService
class HelloService : Greeter {

    override fun sayHello(request: HelloRequest): Uni<HelloReply> {
        return Uni.createFrom().item(HelloReply.newBuilder().setMessage("Hello ${request.name}").build())
    }
}
