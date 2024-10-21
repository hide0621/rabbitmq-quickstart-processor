package org.acme.rabbitmq.processor

import io.smallrye.common.annotation.Blocking
import jakarta.enterprise.context.ApplicationScoped
import org.acme.rabbitmq.model.Quote
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Outgoing
import java.util.Random


@ApplicationScoped
class QuoteProcessor {

    private val random = Random()

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    @Throws(InterruptedException::class)
    fun process(quoteRequest:String): Quote {
        Thread.sleep(1000)
        return Quote(quoteRequest, random.nextInt(100))
    }
}