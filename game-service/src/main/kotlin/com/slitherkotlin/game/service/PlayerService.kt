package com.slitherkotlin.game.service

import com.slitherkotlin.game.model.Player
import com.slitherkotlin.game.repository.PlayerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlayerService(private val repository: PlayerRepository) {
    fun findAll(): Flux<Player> = repository.findAll()
    fun findById(id: String): Mono<Player> = repository.findById(id)

    fun save(player: Player): Mono<Player> = 
        repository.findAll()
            .filter { it.nickname == player.nickname }
            .hasElements()
            .flatMap { exists -> 
                if (exists) Mono.error(IllegalArgumentException("Nickname já existe"))
                else repository.save(player)    
            }
    fun deleteById(id: String): Mono<Void> = repository.deleteById(id)
}