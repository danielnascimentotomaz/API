package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "tb_customer")
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable= false)
    var firstName: String ="",

    @Column(nullable= false)
    var lastName: String = "",

    @Column(nullable= false,unique=true)
    val cpf: String,

    @Column(nullable= false,unique=true)
    var email: String,

    @Column(nullable= false)
    var password: String = "",

    @Column(nullable= false)
    var income: BigDecimal,

    @Column(nullable= false)
    @Embedded
    var address:Address = Address(),

    @Column(nullable= false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE],mappedBy= "customer")
    var credits: List<Credit> = mutableListOf()

)



