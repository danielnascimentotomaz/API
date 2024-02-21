package me.dio.creditapplicationsystem.dto.credit

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer

import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment:Int,
    val customerId:Long

){
  fun toEntity() = Credit(
      creditValue = this.creditValue,
      dayFirstInstallment = this.dayFirstInstallment,
      numberOfInstallment = this.numberOfInstallment,
      customer = Customer(id = this.customerId)



  )
}
