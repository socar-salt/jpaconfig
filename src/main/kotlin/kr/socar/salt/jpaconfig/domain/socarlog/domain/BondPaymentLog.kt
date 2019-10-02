package kr.socar.salt.jpaconfig.domain.socarlog.domain

import kr.socar.salt.jpaconfig.domain.socarlog.domain.base.BaseBondPaymentEntity
import java.time.LocalDateTime
import javax.persistence.Entity

@Entity
class BondPaymentLog private constructor(
        baseBondPaymentQueue: BaseBondPaymentEntity,
        val resultCd: Int,
        val resultMessage: String,
        val creditAmount: Long,
        val cardAmount: Long,
        val bonusAmount: Long,
        val paidAmount: Long
) : BaseBondPaymentEntity(
    infoType = baseBondPaymentQueue.infoType,
    infoKey = baseBondPaymentQueue.infoKey,
    memberId = baseBondPaymentQueue.memberId,
    amount = baseBondPaymentQueue.amount,
    message = baseBondPaymentQueue.message,
    createdAt = baseBondPaymentQueue.createdAt
) {

    val paidAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun newOf(
            baseBondPaymentQueue: BaseBondPaymentEntity,
            resultCd: Int,
            resultMessage: String = "",
            creditAmount: Long = 0,
            cardAmount: Long = 0,
            bonusAmount: Long = 0,
            paidAmount: Long = 0
        ): BondPaymentLog {
            return BondPaymentLog(
                baseBondPaymentQueue = baseBondPaymentQueue,
                resultCd = resultCd,
                resultMessage = resultMessage,
                creditAmount = creditAmount,
                cardAmount = cardAmount,
                bonusAmount = bonusAmount,
                paidAmount = paidAmount
            )
        }
    }
}
