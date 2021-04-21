package com.caiquecsx.pontointeligente.controllers

import com.caiquecsx.pontointeligente.dtos.CadastroPJDto
import com.caiquecsx.pontointeligente.services.EmpresaService
import com.caiquecsx.pontointeligente.services.FuncionarioService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping
class CadastroPjController(
    val empresaService: EmpresaService,
    val funcionarioService: FuncionarioService
) {

    @PostMapping
    fun cadastrar(@Valid @RequestBody cadastroPJDto: CadastroPJDto){ }

}