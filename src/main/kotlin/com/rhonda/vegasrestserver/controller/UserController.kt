package com.rhonda.vegasrestserver.controller

import com.rhonda.vegasrestserver.dto.UserDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
@Tag(
    name = "Пользователи",
    description = "Все методы для работы с пользователями системы",
)
class UserController {

    var users = mutableListOf<UserDto>(
        UserDto(1, "Иван", "Иванов", "01"),
        UserDto(2, "Петр", "Петров", "02"),
        UserDto(3, "Василий", "Васильев", "03"),
    )

    @GetMapping("/list")
    @Operation(summary = "Получить список всех пользователей")
    fun getAllUsers(): List<UserDto> {
        return users
    }


    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя через @PathVariable")
    fun getUserPathVariable(
        @Parameter(description = "id пользователя")
        @PathVariable("id") id: Int,

        ): UserDto {

        var user = UserDto(0, "", "", "")

        for (item in users) {
            if (item.id == id) {
                return item
            }
        }

        return user
    }

    @GetMapping("/")
    @Operation(summary = "Получить пользователя через @RequestParam")
    fun getUserRequestParam(
        @Parameter(description = "id пользователя")
        @RequestParam("id") id: Int,

        ): UserDto {

        var user = UserDto(0, "", "", "")

        if (id == 0) {
            return UserDto(0, "Алексей", "Козлов", "09")
        } else {
            for (item in users) {
                if (item.id == id) {
                    return item
                }
            }
        }

        return user
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователе по его id")
    fun deleteProfile(
        @Parameter(description = "id пользователя")
        @PathVariable("id") id: Int,

        ) {

    }

    @PutMapping("/update")
    @Operation(summary = "Изменить данные пользователя по его id")
    fun update( @RequestBody dto: UserDto) : UserDto {

        for(user in users) {
            if (user.id == dto.id) {
                user.name = dto.name
                break
            }
        }

        return UserDto(dto.id, dto.name, dto.surname, dto.phoneNumber)
    }

}