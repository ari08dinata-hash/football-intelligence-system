package id.fiss.domain.team

import id.fiss.domain.common.EntityId
import id.fiss.domain.team.vo.TeamName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import id.fiss.domain.team.event.TeamCreatedEvent
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class TeamTest {

    @Test
    fun `should rename team`() {

        val team = Team.create(
            name = TeamName("Barcelona"),
            country = "Spain"
        )

        team.rename(TeamName("Real Madrid"))

        assertEquals(
            TeamName("Real Madrid"),
            team.name
        )
    }

    @Test
    fun `should reject blank team name`() {

        assertThrows<IllegalArgumentException> {
            Team.create(
                name = TeamName(""),
                country = "Spain"
            )
        }
    }

    @Test
    fun `should register TeamCreatedEvent when team is created`() {

        val team = Team.create(
            name = TeamName("Barcelona"),
            country = "Spain"
        )

        val events = team.domainEvents()

        assertEquals(1, events.size)
        assertTrue(events.first() is TeamCreatedEvent)
    }
}
