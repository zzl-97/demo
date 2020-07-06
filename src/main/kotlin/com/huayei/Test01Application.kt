package com.huayei

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication

@EnableJpaAuditing
class Test01Application

fun main(){
    runApplication<Test01Application>()
}


