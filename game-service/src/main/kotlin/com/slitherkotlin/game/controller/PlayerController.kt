package com.slitherkotlin.game.controller

import com.slitherkotlin.game.model.Player
import com.slitherkotlin.game.service.PlayerService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/players")
class PlayerController(private val service: PlayerService) {
    @GetMapping
    fun getAll(): Flux<Player> = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Mono<Player> = service.findById(id)

    @PostMapping
    fun create(@RequestBody player: Player): Mono<Player> = service.save(player)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Mono<Void> = service.deleteById(id)
}
