package me.dio.creditapplicationsystem.controller

import me.dio.creditapplicationsystem.dto.credit.CreditDto
import me.dio.creditapplicationsystem.dto.credit.CreditView
import me.dio.creditapplicationsystem.dto.credit.CreditViewList
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping()
    fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
       val credit = this.creditService.save(creditDto.toEntity())
       return ResponseEntity.ok("Credit ${credit.creditCode} created successfully")


    }

    @GetMapping("/{idCustomer}/{creditCode}")
    fun findByCreditCode(@PathVariable idCustomer:Long,@PathVariable creditCode: UUID):ResponseEntity<CreditView>{

        val creditBD = this.creditService.findByCreditCode(idCustomer,creditCode)

        return ResponseEntity.status(HttpStatus.OK).body(CreditView(creditBD))


    }


    @GetMapping()
    fun findAllByCustomer(@RequestParam(value= "customerId") id: Long):ResponseEntity<List<CreditViewList>?>{

        val creditViewList :List<CreditViewList> = this.creditService.
        findAllByCustomer(id).
        stream().map{ credit: Credit -> CreditViewList(credit)}.collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)



    }







}
