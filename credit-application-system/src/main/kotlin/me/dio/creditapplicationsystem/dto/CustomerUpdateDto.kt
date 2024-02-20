package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income : BigDecimal


) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        return customer
    }
}