package com.github.tobycapapps.fileexplorerservice

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.context.ApplicationContext
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.ServerProperties
import java.util.concurrent.CountDownLatch

/**
 * waits for a client to connect to the spring boot application, serves a
 * request from the client and then shuts down.
 */
@SpringBootApplication
open class OneshotHelloSpringBootApplication
{
    companion object
    {
        @JvmStatic
        fun main(args:Array<String>)
        {
            SpringApplication.run(OneshotHelloSpringBootApplication::class.java,*args)
        }
    }

    @Bean
    open fun commandLineRunner(ctx:ApplicationContext):CommandLineRunner
    {
        return CommandLineRunner()
        {
            println("print all the beans provided by Spring Boot:")
            ctx.beanDefinitionNames
                .asSequence()
                .sorted()
                .forEach()
                {
                    println("    - $it")
                }

            println()
            println("waiting for any client to visit localhost:${ctx.serverProperties.port}")
            ctx.helloController.unblockOnFirstHit.await()

            // request received, wait for spring boot to finish responding
            // before shutting down the sprig boot application.
            // fixme: there's probably a better way to wait for the spring boot application to finish serving the client other than sleeping
            Thread.sleep(500)
        }
    }

    private val ApplicationContext.serverProperties:ServerProperties
        get() = getBean(ServerProperties::class.java)

    private val ApplicationContext.helloController:HelloController
        get() = getBean(HelloController::class.java)

    @RestController
    private class HelloController
    {
        val unblockOnFirstHit = CountDownLatch(1)

        @RequestMapping("/")
        fun index():String
        {
            unblockOnFirstHit.countDown()
            return "Hello from Spring Boot!"
        }
    }
}
