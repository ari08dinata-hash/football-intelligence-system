package id.fiss.infrastructure.persistence.team

import id.fiss.domain.common.EntityId
import id.fiss.domain.team.Team
import id.fiss.domain.team.TeamRepository
import id.fiss.infrastructure.persistence.team.model.TeamRecord
import id.fiss.infrastructure.persistence.team.mapper.TeamPersistenceMapper

class InMemoryTeamRepository : TeamRepository {

    private val teams = mutableListOf<TeamRecord>()

    override fun findById(id: EntityId): Team? =
        teams
            .find { it.id == id }
            ?.let(TeamPersistenceMapper::toDomain)

    override fun findByName(name: String): Team? =
        teams
            .find { it.name == name }
            ?.let(TeamPersistenceMapper::toDomain)

    override fun save(team: Team): Team {

        val record = TeamPersistenceMapper.toRecord(team)

        teams.removeIf { it.id == record.id }

        teams.add(record)

        return team
    }

    override fun delete(id: EntityId) {
        teams.removeIf { it.id == id }
    }
}
