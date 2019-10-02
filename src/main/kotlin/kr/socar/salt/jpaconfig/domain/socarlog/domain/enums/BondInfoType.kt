package kr.socar.bond.common.jpa.enums

import kr.socar.salt.jpaconfig.domain.socarlog.domain.base.BaseCodeEnum

enum class BondInfoType(
    override val code: String,
    override val description: String
) : BaseCodeEnum<String> {
    RESERVATION("reservation_info", "예약"),
    CAR_ACCIDENT("car_accident_info", "사고"),
    FINE("fine_info", "과태료");

    fun makePaymentMessage(): String {
        return when (this) {
            RESERVATION -> "예약 미수금 자동결제"
            FINE -> "과태료 미수금 자동결제"
            CAR_ACCIDENT -> "사고 미수금 자동결제"
        }
    }
}
