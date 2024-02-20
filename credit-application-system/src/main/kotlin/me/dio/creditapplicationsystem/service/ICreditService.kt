package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Credit

import java.util.*

interface ICreditService {
    fun save(credit: Credit):Credit
    fun findAllByCustomer(customerId:Long):List<Credit>

    fun findByCriditCode(creditCode: UUID):Credit


}