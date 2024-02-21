package me.dio.creditapplicationsystem.controller

import me.dio.creditapplicationsystem.dto.customer.CustomerDto
import me.dio.creditapplicationsystem.dto.customer.CustomerUpdateDto
import me.dio.creditapplicationsystem.dto.customer.CustomerView
import me.dio.creditapplicationsystem.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/controller")
class CustomerController(
    private val customerService: CustomerService
) {



    @PostMapping()
    fun createCustomer(@RequestBody customerDto: CustomerDto):ResponseEntity<String>{
        val savedCustomer = customerService.save(customerDto.toEntity())

        //return "Customer ${savedCustomer.firstName} saved"
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.firstName} saved")

    }


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {

        val customer = customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<String> {
        customerService.delete(id)
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted")
    }


    @PatchMapping()
    fun updateCustomer(@RequestParam(value= "customerId") id :Long,@RequestBody customerUpdateDto: CustomerUpdateDto):ResponseEntity<CustomerView>{
        //buscando
        val customer = customerService.findById(id)
        //atualizando
        val updatedCustomer = customerUpdateDto.toEntity(customer)
        //salvando
        val savedCustomer = customerService.save(updatedCustomer)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(savedCustomer))

    }



}