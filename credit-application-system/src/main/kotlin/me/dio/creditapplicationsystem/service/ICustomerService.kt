package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import java.util.*

interface ICustomerService {
   fun save(customer: Customer):Customer

   fun findById(id:Long):Customer

   fun delete(id:Long)
}