package id.fiss.domain.team

import id.fiss.domain.common.EntityId

interface TeamRepository {

    fun findById(id: EntityId): Team?

    fun findByName(name: String): Team?

    fun save(team: Team): Team

    fun delete(id: EntityId)

}
