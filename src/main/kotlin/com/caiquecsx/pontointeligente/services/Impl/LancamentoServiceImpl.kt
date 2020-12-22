package com.caiquecsx.pontointeligente.services.Impl

import com.caiquecsx.pontointeligente.documents.Lancamento
import com.caiquecsx.pontointeligente.repositories.LancamentoRepository
import com.caiquecsx.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {

    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> =
        lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String): Lancamento? =
        lancamentoRepository.findByIdOrNull(id)

    override fun persistir(lancamento: Lancamento): Lancamento =
        lancamentoRepository.save(lancamento)

    override fun remover(id: String) = lancamentoRepository.deleteById(id)

}