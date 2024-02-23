package me.dio.creditapplicationsystem.exception

data class BusinessException(val mensagem:String):RuntimeException(mensagem)
