package id.fiss.infrastructure.persistence.team.model

import id.fiss.domain.common.EntityId

data class TeamRecord(
    val id: EntityId,
    val name: String,
    val country: String
)
