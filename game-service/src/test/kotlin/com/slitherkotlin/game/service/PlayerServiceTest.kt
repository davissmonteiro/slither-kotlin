package com.slitherkotlin.game.service

import com.slitherkotlin.game.model.Player
import com.slitherkotlin.game.repository.PlayerRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

class PlayerServiceTest {
    private val repository = mock<PlayerRepository>()
    private val service = PlayerService(repository)

    @Test
    fun `should sava player`() {
        val player = Player(id = null, nickname = "test", score = 0)
        whenever(repository.save(any())).thenReturn(Mono.just(player))

        StepVerifier.create(service.save(player))
            .expectNext(player)
            .verifyComplete()
    }
}