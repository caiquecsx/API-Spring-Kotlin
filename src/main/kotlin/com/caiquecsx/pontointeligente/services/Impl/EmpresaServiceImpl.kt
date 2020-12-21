package com.caiquecsx.pontointeligente.services.Impl

import com.caiquecsx.pontointeligente.documents.Empresa
import com.caiquecsx.pontointeligente.repositories.EmpresaRepository
import org.springframework.stereotype.Service
import com.caiquecsx.pontointeligente.services.EmpresaService

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)

}