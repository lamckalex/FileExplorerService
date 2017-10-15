package com.github.tobycapapps.fileexplorerservice

import org.junit.Test
import org.springframework.util.SocketUtils

class OneshotHelloSpringBootApplicationTest
{
    @Test
    fun spin_up_spring_app()
    {
        OneshotHelloSpringBootApplication.main(
            arrayOf("--server.port=${SocketUtils.findAvailableTcpPort()}"))
    }
}
