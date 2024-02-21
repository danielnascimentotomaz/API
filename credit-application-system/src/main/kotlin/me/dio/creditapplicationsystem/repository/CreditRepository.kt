package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

    fun findByCreditCode(creditCode: UUID): Credit?

    //Usando native query para buscar todos os cr�ditos de um cliente espec�fico.
    @Query(value = "SELECT * FROM TB_CREDIT  WHERE CUSTOMER_ID = ?", nativeQuery = true)
    fun findAllByCustomer(customerId:Long) :List<Credit>






}