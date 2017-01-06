// DEPS com.beust:klaxon:0.24, com.github.kittinunf.fuel:fuel:1.3.1

// kotlinc -cp $(expandcp.kts com.beust:klaxon:0.24 com.github.kittinunf.fuel:fuel:1.3.1)

import com.beust.klaxon.*
import com.github.kittinunf.fuel.httpGet

// define list of query GIs
val gis = listOf(23, 5353, 34)

val queryURL = "http://bioinfo.mpi-cbg.de:7050/gi2acc?gi=${gis.joinToString(",")}"

val json = String(queryURL.httpGet().response().second.data)

// use fuel library to call the service (see https://github.com/kittinunf/Fuel)
val jsonArray = Parser().parse(json.byteInputStream())!! as JsonArray<*>

// use klaxon library to parse the json result (see https://github.com/cbeust/klaxon)
val idMap = jsonArray.map { (it as JsonObject) }.map { it.int("gi") to it.string("accession") }

// print conversion table
idMap.forEach { println(it) }


