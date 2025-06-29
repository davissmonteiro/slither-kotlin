package com.slitherkotlin.game.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("player")
data class Player(
    @Id 
    val id: String?,
    val nickname: String,
    val score: Int = 0
)