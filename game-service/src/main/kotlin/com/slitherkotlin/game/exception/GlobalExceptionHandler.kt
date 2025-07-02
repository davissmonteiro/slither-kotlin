package com.slitherkotlin.game.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(e: IllegalArgumentException, exchange): Mono<Map<String, String>> {
        exchange.response.statusCode = HttpStatus.BAD_REQUEST
        return Mono.just(mapOf("error" to (e.message ?: "Validation error")))
    }
}