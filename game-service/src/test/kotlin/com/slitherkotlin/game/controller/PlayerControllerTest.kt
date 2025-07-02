package com.slitherkotlin.game.controller

import com.slitherkotlin.game.model.Player
import com.slitherkotlin.game.repository.PlayerRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux

@WebFluxTest(PlayerController::class)
class PlayerControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var repository: PlayerRepository

    @Test
    fun `should return all players`() {
        val players = listOf(Player("1", "Alice", 10), Player("2", "Bob", 20))
        whenever(repository.findAll()).thenReturn(Flux.fromIterable(players))

        webTestClient.get().uri("/players")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(Player::class.java)
            .hasSize(2)
    }
}
