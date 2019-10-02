package kr.socar.salt.jpaconfig.domain.socarlog.domain.base

import kr.socar.bond.common.jpa.enums.BondInfoType
import kr.socar.bond.common.jpa.enums.BondInfoTypeConverter
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Convert
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseBondSmsEntity(
    @Convert(converter = BondInfoTypeConverter::class)
    val infoType: BondInfoType,
    val infoKey: Long,
    val memberId: Long,
    val senderNumber: String,
    val recipientNumber: String,
    @Lob
    val smsContent: String,
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseBondSmsEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
