package id.fiss.infrastructure.persistence.team.mapper

import id.fiss.domain.team.Team
import id.fiss.infrastructure.persistence.team.model.TeamRecord
import id.fiss.domain.team.vo.TeamName

object TeamPersistenceMapper {

    fun toRecord(team: Team): TeamRecord =
        TeamRecord(
            id = team.id,
            name = team.name.value,
            country = team.country
        )
    fun toDomain(record: TeamRecord): Team =
        Team.restore(
            id = record.id,
            name = TeamName(record.name),
            country = record.country
        )
}
