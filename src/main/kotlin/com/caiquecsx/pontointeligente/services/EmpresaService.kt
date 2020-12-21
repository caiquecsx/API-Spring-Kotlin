package com.caiquecsx.pontointeligente.services

import com.caiquecsx.pontointeligente.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa

}