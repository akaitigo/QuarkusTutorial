package org.acme

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import jakarta.persistence.Entity

@Entity
class Greeting : PanacheEntity() {
    lateinit var name: String

    companion object : PanacheCompanion<Greeting>
}
