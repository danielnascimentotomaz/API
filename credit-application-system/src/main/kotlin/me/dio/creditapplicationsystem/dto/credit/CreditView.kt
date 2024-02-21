package me.dio.creditapplicationsystem.dto.credit

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.enumerate.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment:Int,
    val status: Status,
    val emailCustormer: String?,
    val incomeCustormer: BigDecimal?


) {
    constructor(credit: Credit):this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment,
        status = credit.status,
        emailCustormer = credit.customer?.email,
        incomeCustormer = credit.customer?.income

    )


}