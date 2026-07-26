package id.fiss.domain.team.vo

@JvmInline
value class TeamName(
    val value: String
) {

    init {
        require(value.isNotBlank()) {
            "Team name must not be blank."
        }
    }

    override fun toString(): String =
        value
}
