package id.fiss.application.team

import id.fiss.domain.common.EntityId
import id.fiss.domain.team.Team
import id.fiss.domain.team.vo.TeamName
import id.fiss.domain.team.TeamRepository

class DefaultCreateTeamUseCase(

    private val repository: TeamRepository

) : CreateTeamUseCase {

    override fun execute(
        command: CreateTeamCommand
    ) {

        val team = Team.create(
            name = TeamName(command.name),
            country = command.country
        )

        repository.save(team)
    }
}
