package kr.socar.salt.jpaconfig.domain.socarlog.domain

import kr.socar.salt.jpaconfig.domain.socarlog.domain.base.BaseBondSmsEntity
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
class BondSmsLog(
        baseBondSmsEntity: BaseBondSmsEntity,
        val smsId: Long,
        val smsAgent: String
) : BaseBondSmsEntity(
    infoType = baseBondSmsEntity.infoType,
    infoKey = baseBondSmsEntity.infoKey,
    memberId = baseBondSmsEntity.memberId,
    senderNumber = baseBondSmsEntity.senderNumber,
    recipientNumber = baseBondSmsEntity.recipientNumber,
    smsContent = baseBondSmsEntity.smsContent,
    createdAt = baseBondSmsEntity.createdAt
) {

    val sentAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun newOf(baseBondSmsEntity: BaseBondSmsEntity, smsId: Long = 0, smsAgent: String = ""): BondSmsLog {
            return BondSmsLog(
                baseBondSmsEntity = baseBondSmsEntity,
                smsId = smsId,
                smsAgent = smsAgent
            )
        }
    }
}
