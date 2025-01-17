package org.acme.rabbitmq.model

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
class Quote {
    var id: String? = null
    var price: Int = 0

    constructor()

    constructor(id: String?, price: Int) {
        this.id = id
        this.price = price
    }

    override fun toString(): String {
        return "Quote{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}'
    }
}