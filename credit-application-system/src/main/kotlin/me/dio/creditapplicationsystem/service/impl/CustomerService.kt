package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.ICustomerService
import java.util.*

class CustomerService(
    private val customerRepository: CustomerRepository


) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow{
        RuntimeException("Customer not found")
    }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)
}