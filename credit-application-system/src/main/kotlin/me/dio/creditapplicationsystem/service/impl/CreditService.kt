package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.service.ICreditService
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository,
    private val CustormerService:CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        //Iniciando objeto credit
        credit.apply {
            credit.customer = CustormerService.findById(credit.customer?.id!!)

        }
        return this.creditRepository.save(credit)


    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }

    override fun findByCriditCode(idCustomer: Long, creditCode: UUID): Credit {
        val credit = creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit not found")

        if (credit.customer?.id != idCustomer) {
            throw RuntimeException("Contat admin")
        }
        return credit



    }


}