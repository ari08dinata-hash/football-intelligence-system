package id.fiss.domain.common

abstract class AggregateRoot(

    open val id: EntityId

) {

    private val domainEvents = mutableListOf<DomainEvent>()

    protected fun registerEvent(event: DomainEvent) {
        domainEvents.add(event)
    }

    fun domainEvents(): List<DomainEvent> =
        domainEvents.toList()

    fun clearEvents() {
        domainEvents.clear()
    }
}
