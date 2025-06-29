package com.slitherkotlin.game.repository

import com.slitherkotlin.game.model.Player
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PlayerRepository : ReactiveCrudRepository<Player, String>