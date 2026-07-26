package id.fiss.application.team

interface CreateTeamUseCase {

    fun execute(
        command: CreateTeamCommand
    )
}
