package id.fiss.domain.team

import id.fiss.domain.common.AggregateRoot
import id.fiss.domain.common.EntityId
import id.fiss.domain.team.vo.TeamName
import id.fiss.domain.team.event.TeamCreatedEvent

class Team private constructor(

    override val id: EntityId,

    var name: TeamName,

    var country: String

) : AggregateRoot(id) {

    fun rename(newName: TeamName) {
        name = newName
    }

    companion object {

        fun create(
            name: TeamName,
            country: String
        ): Team {

            val team = Team(
                id = EntityId.generate(),
                name = name,
                country = country
            )

            team.registerEvent(
                TeamCreatedEvent(
                    teamId = team.id,
                    teamName = team.name.value,
                    country = team.country
                )
            )

            return team
        }

        fun restore(
            id: EntityId,
            name: TeamName,
            country: String
        ): Team {

            return Team(
                id = id,
                name = name,
                country = country
            )
        }
    }
}