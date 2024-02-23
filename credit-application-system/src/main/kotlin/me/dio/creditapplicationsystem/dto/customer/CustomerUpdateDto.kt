package me.dio.creditapplicationsystem.dto.customer

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid firstName")
    val firstName: String,
    @field:NotEmpty(message = "Invalid lastName")
    val lastName: String,
    @field:NotNull(message = "Invalid income")
    val income : BigDecimal


) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        return customer
    }
}