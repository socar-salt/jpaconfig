package kr.socar.bond.common.jpa.enums

import kr.socar.salt.jpaconfig.domain.socarlog.domain.base.BaseCodeEnumConverter
import javax.persistence.Converter

@Converter
class BondInfoTypeConverter : BaseCodeEnumConverter<BondInfoType, String>(BondInfoType::class)
