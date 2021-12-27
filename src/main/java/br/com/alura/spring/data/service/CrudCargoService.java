package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;
    private Boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual acao deseja executar: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                case 4:
                    deletar(scanner);
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo:");

        String descricao = scanner.next();

        Cargo cargo = new Cargo(descricao);
        cargoRepository.save(cargo);

        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id do registro na tabela:");
        int id = scanner.nextInt();
        System.out.println("Nova descrição:");
        String descricao = scanner.next();

        Cargo cargo = cargoRepository.findById(id).get();
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
    }
    
    private void visualizar() {
        cargoRepository.findAll().forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id do que deseja remover:");

        int id = scanner.nextInt();

        cargoRepository.deleteById(id);

        System.out.println("Deletado");
    }
}
