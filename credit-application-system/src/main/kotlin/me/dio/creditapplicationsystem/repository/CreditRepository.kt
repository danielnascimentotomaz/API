package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

    fun findByCreditCode(creditCode: UUID): Credit?

    //Usando native query para buscar todos os créditos de um cliente específico.
    @Query(value ="SELECT * FROM CREDIT WHERE customer_id =?1",nativeQuery = true)
    fun findAllByCustomer(customerId: Long):List<Credit>




}