package kr.socar.salt.jpaconfig.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/alimtalk")
class ApiController {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/send")
    fun send(): ResponseEntity<*> {
        log.info("welcome send!!!!")

        val bodyEntity = HashMap<String, String>()
        bodyEntity["code"] = "1"
        bodyEntity["msg"] = "success"
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(bodyEntity)
    }



}