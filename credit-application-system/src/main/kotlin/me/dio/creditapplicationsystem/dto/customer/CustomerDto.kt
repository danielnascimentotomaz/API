package me.dio.creditapplicationsystem.dto.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF

import java.math.BigDecimal

data class CustomerDto(

    @field:NotEmpty(message = "Invalid firstName")
    val firstName: String ,

    @field:NotEmpty(message = "Invalid lastName")
    val lastName: String ,

    @field:CPF(message = "this invalid CPF")
    val cpf: String,

    @field:Email(message = "Invalid email")
    val email: String,

    @field:NotEmpty(message = "Invalid password")
    val password: String ,

    @field:NotNull(message = "Invalid income")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid zipCode")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid street")
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
