package kr.socar.salt.jpaconfig.domain.socarlog.domain

import org.springframework.data.jpa.repository.JpaRepository

interface BondPaymentLogRepository : JpaRepository<BondPaymentLog, Long>
