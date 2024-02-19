package me.dio.creditapplicationsystem.entity

import me.dio.creditapplicationsystem.enumerate.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class Credit(
    var id : Long? = null,
    val creditCode: UUID= UUID.randomUUID(),
    val creditValue: BigDecimal=BigDecimal.ZERO,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int = 0,
    val status: Status = Status.IN_PROGRESS,
    val customer: Customer? = null


)