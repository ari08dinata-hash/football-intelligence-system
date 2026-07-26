package id.fiss.domain.team.event

import id.fiss.domain.common.DomainEvent
import id.fiss.domain.common.EntityId

data class TeamCreatedEvent(

    val teamId: EntityId,
    val teamName: String,
    val country: String

) : DomainEvent
