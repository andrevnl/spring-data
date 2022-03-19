package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final RelatoriosService relatoriosService;
	private final CrudFuncionarioService funcionarioService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	private final Boolean system = true;

	public SpringDataApplication(CrudCargoService crudCargoService, RelatoriosService relatoriosService, CrudFuncionarioService funcionarioService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = crudCargoService;
		this.relatoriosService = relatoriosService;
		this.funcionarioService = funcionarioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual ação vc quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Relatorios");
			System.out.println("3 - Funcionarios");
			System.out.println("4 - Relatorio funcionario dinamico");

			int action = scanner.nextInt();

			switch (action) {
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					relatoriosService.inicial(scanner);
					break;
				case 3:
					funcionarioService.inicial(scanner);
					break;
				case 4:
					relatorioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					break;
			}

		}

	}
}
