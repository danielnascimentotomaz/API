package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import me.dio.creditapplicationsystem.enumerate.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "tb_credit")
data class Credit(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @Column(nullable= false,unique= true)
    val creditCode: UUID= UUID.randomUUID(),

    @Column(nullable= false)
    var creditValue: BigDecimal=BigDecimal.ZERO,

    @Column(nullable= false)
    var dayFirstInstallment: LocalDate,

    @Column(nullable= false)
    var numberOfInstallment:Int = 0,

    @Enumerated
    var status: Status = Status.IN_PROGRESS,

    @ManyToOne
    @JoinColumn(name = "customer_id") //Caso eu não especifique o nome da coluna, ele vai pegar o nome da propriedade
    var customer: Customer? = null


)