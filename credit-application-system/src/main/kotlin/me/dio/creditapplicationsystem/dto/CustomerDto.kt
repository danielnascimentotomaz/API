package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerDto(


    val firstName: String ,
    val lastName: String ,
    val cpf: String,
    val email: String,
    val password: String ,
    val income: BigDecimal,
    val zipCode: String,
    val street: String,


    ){

    fun toEntity(): Customer {
        return Customer(
            firstName = firstName,
            lastName = lastName,
            cpf = cpf,
            email = email,
            password = password,
            income = income,
            address = Address(
                zipCode = zipCode,
                street = street
            )
        )


    }
}
