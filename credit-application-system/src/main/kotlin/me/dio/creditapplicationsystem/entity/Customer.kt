package me.dio.creditapplicationsystem.entity

import java.math.BigDecimal

data class Customer(
    var id: Long? = null,
    var firstName: String ="",
    var lastName: String = "",
    val cpf: String,
    var email: String,
    var password: String = "",
    var income: BigDecimal,

    var address:Address = Address(),


    var credits: List<Credit> = mutableListOf()

)



