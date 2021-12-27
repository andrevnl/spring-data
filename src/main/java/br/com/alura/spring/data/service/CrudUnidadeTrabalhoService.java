package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private final UnidadeTrabalhoRepository UnidadeTrabalhoRepository;
    private Boolean system = true;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository UnidadeTrabalhoRepository) {
        this.UnidadeTrabalhoRepository = UnidadeTrabalhoRepository;
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
        System.out.println("Descrição do Unidade Trabalho:");

        String descricao = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao("aaa");
        unidadeTrabalho.setEndereco("bbb");
        UnidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id do registro na tabela:");
        int id = scanner.nextInt();
        System.out.println("Nova descrição:");
        String descricao = scanner.next();
        System.out.println("Novo endereço:");
        String endereco = scanner.next();

        UnidadeTrabalho UnidadeTrabalho = UnidadeTrabalhoRepository.findById(id).get();
        UnidadeTrabalho.setDescricao(descricao);
        UnidadeTrabalho.setEndereco(endereco);

        UnidadeTrabalhoRepository.save(UnidadeTrabalho);
    }

    private void visualizar() {
        UnidadeTrabalhoRepository.findAll().forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id do que deseja remover:");

        int id = scanner.nextInt();

        UnidadeTrabalhoRepository.deleteById(id);

        System.out.println("Deletado");
    }
}
