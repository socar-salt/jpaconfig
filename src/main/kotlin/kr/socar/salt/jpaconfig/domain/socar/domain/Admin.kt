package kr.socar.bond.domain.socar.domain.admin


import kr.socar.salt.jpaconfig.domain.socar.domain.base.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "admin_info")
class Admin : BaseEntity() {
    var name: String = ""
    var phone: String = ""
}
