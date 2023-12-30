package com.rhonda.vegasrestserver.dto

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Schema(description = "Информация о пользователе")
data class UserDto(
    @Schema(description = "Идентификатор")
    @Min(1)
    @Max(9999999999)
    val id: Int,

    @Schema(description = "Имя")
    @NotBlank
    @Size(min = 1, max = 100)
    var name: String,

    @Schema(description = "Фамилия")
    @NotBlank
    @Size(min = 1, max = 100)
    val surname: String,

    @Schema(description = "Номер телефона (без префикса \"+\")")
    @NotBlank
    @Size(min = 0, max = 11)
    val phoneNumber: String,
)