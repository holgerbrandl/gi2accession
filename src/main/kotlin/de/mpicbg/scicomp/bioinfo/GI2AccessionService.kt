package de.mpicbg.scicomp.bioinfo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import org.springframework.data.rest.core.annotation.RepositoryRestResource as Resource


/**
 * @author Holger Brandl
 */

data class Greeting(val id: Long, val content: String)


@RestController
class IdConversionController {

    // http://localhost:8080/gi2acc?gi=123
    @RequestMapping("/gi2acc")
    fun mapGI(@RequestParam(value="gi") giNumbers : String) : String {
        val queryGis = giNumbers.split(',', ';').map(String::toInt).toList()

        return queryGis.first().toString()
    }

}

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

