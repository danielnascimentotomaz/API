package me.dio.creditapplicationsystem.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime


@RestControllerAdvice
class RestExceptionHandle {


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex:MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {

        val erros: MutableMap<String, String?> = mutableMapOf()

        ex.bindingResult.allErrors.stream().forEach { erro: ObjectError ->

            val fielName: String = (erro as FieldError).field


            val mensagemError: String? = erro.defaultMessage

            erros[fielName] = mensagemError


        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.objectName,//ex.javaClass.toString
                details = erros)
        )


    }





    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex:BusinessException): ResponseEntity<ExceptionDetails>{

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)


            )



        )

    }


    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex:DataAccessException): ResponseEntity<ExceptionDetails>{

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptionDetails(
                title = "CONFLICT! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)


            )



        )

    }


   ///IllegalArgumentException

    @ExceptionHandler(IllegalArgumentException::class)
    fun handlerValidException(ex:IllegalArgumentException): ResponseEntity<ExceptionDetails>{

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptionDetails(
                title = "CONFLICT! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)


            )



        )

    }


}