package kr.socar.salt.jpaconfig.domain.socarlog.domain

import org.springframework.data.jpa.repository.JpaRepository

interface BondSmsLogRepository : JpaRepository<BondSmsLog, Long>
