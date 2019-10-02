package kr.socar.salt.jpaconfig.domain.socarlog.domain.base

interface BaseCodeEnum<CT> {
    val code: CT
    val description: String
}
