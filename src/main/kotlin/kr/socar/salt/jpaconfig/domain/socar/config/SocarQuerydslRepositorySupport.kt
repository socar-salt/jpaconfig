package kr.socar.bond.domain.socar.config

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import kotlin.reflect.KClass

class SocarQuerydslRepositorySupport(entity: KClass<*>) : QuerydslRepositorySupport(entity.java) {
    @PersistenceContext(unitName = "socar")
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }
}
