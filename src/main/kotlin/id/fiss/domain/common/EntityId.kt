package id.fiss.domain.common

import java.util.UUID

@JvmInline
value class EntityId(
    val value: UUID
) {

    companion object {

        fun generate(): EntityId =
            EntityId(UUID.randomUUID())

        fun from(value: String): EntityId =
            EntityId(UUID.fromString(value))
    }

    override fun toString(): String =
        value.toString()
}
