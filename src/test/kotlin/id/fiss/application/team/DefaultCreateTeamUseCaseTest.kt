package id.fiss.application.team

import id.fiss.infrastructure.persistence.team.InMemoryTeamRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class DefaultCreateTeamUseCaseTest {

    @Test
    fun `should create team`() {

        val repository = InMemoryTeamRepository()

        val useCase = DefaultCreateTeamUseCase(repository)

        val command = CreateTeamCommand(
            name = "Barcelona",
            country = "Spain"
        )

        useCase.execute(command)

        val savedTeam = repository.findByName("Barcelona")

        assertNotNull(savedTeam)
    }
}
