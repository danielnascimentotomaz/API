package me.dio.creditapplicationsystem.dto.credit

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer

import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message= "credidValue invalido")
    val creditValue: BigDecimal,
    @field:Future(message= "Data tem que tá no futuro")
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
