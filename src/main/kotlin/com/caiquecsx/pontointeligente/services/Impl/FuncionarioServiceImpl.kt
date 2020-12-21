package com.caiquecsx.pontointeligente.services.Impl

import com.caiquecsx.pontointeligente.documents.Funcionario
import com.caiquecsx.pontointeligente.repositories.FuncionarioRepository
import com.caiquecsx.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)

    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)

    override fun buscarPorId(id: String): Funcionario? {
        TODO("Not yet implemented")
    }

}