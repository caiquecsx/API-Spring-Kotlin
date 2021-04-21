package com.caiquecsx.pontointeligente

import com.caiquecsx.pontointeligente.documents.Empresa
import com.caiquecsx.pontointeligente.documents.Funcionario
import com.caiquecsx.pontointeligente.enums.PerfilEnum
import com.caiquecsx.pontointeligente.repositories.EmpresaRepository
import com.caiquecsx.pontointeligente.repositories.FuncionarioRepository
import com.caiquecsx.pontointeligente.repositories.LancamentoRepository
import com.caiquecsx.pontointeligente.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
class PontointeligenteApplication(val empresaRepository: EmpresaRepository,
								  val funcionarioRepository: FuncionarioRepository,
								  val lancamentoRepository: LancamentoRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()
		lancamentoRepository.deleteAll()

		val empresa = Empresa("Empresa", "10443887000146")
		empresaRepository.save(empresa)

		val admin = Funcionario("Admin", "admin@empresa.com",
				SenhaUtils().gerarBcrypt("123456"), "25708317000",
				PerfilEnum.ROLE_ADMIN, empresa.id!!)
		funcionarioRepository.save(admin)

		val funcionario = Funcionario("Funcionario", "funcionario@empresa.com",
		SenhaUtils().gerarBcrypt("123456"), "44325441557", PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionarioRepository.save(funcionario)

		println("Empresa ID: " + empresa.id)
		println("Admin ID: " + admin.id)
		println("Funcionario ID: " + funcionario.id)
	}

}

fun main(args: Array<String>) {
	runApplication<PontointeligenteApplication>(*args)
}
