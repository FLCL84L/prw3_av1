package br.edu.ifsp.carlao2005.testes;

import br.edu.ifsp.carlao2005.dao.AlunoDao;
import br.edu.ifsp.carlao2005.modelo.Aluno;
import br.edu.ifsp.carlao2005.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CadastroDeAluno {
    public static void main(String[] args) {

        // desligar mensagens do hibernate
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);


        // Entity Manager e Aluno Dao
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao dao = new AlunoDao(em);

        // Leitor
        Scanner leitorTeclado = new Scanner(System.in);

        // menu
        int opcao = 0;
        while(opcao != 6) {
            System.out.println("\n** CADASTRO DE ALUNOS **\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Excluir aluno");
            System.out.println("3 - Alterar aluno");
            System.out.println("4 - Buscar aluno pelo nome");
            System.out.println("5 - Listar alunos (com status de aprovação)");
            System.out.println("6 - FIM");
            System.out.print("\nDigite a opção desejada: ");

            opcao = leitorTeclado.nextInt();

            if(opcao == 1){
                System.out.println("\nCADASTRO DE ALUNO:");
                // leitura para consumir o new line do int opcao:
                leitorTeclado.nextLine();
                System.out.print("Digite o nome: ");
                String nome = leitorTeclado.nextLine();
                System.out.print("Digite o RA: ");
                String ra = leitorTeclado.nextLine();
                System.out.print("Digite o email: ");
                String email = leitorTeclado.nextLine();
                System.out.print("Digite a nota 1: ");
                BigDecimal nota1 = leitorTeclado.nextBigDecimal();
                System.out.print("Digite a nota 2: ");
                BigDecimal nota2 = leitorTeclado.nextBigDecimal();
                System.out.print("Digite a nota 3: ");
                BigDecimal nota3 = leitorTeclado.nextBigDecimal();

                Aluno a = new Aluno(nome, ra, email, nota1, nota2, nota3);

                em.getTransaction().begin();

                em.persist(a);

                em.getTransaction().commit();

            } else if(opcao == 2) {
                System.out.println("\nEXCLUIR ALUNO:");
                // leitura para consumir o new line do int opcao:
                leitorTeclado.nextLine();
                System.out.print("Digite o nome: ");
                String nome = leitorTeclado.nextLine();

                try {
                    Aluno a = dao.buscarUnicoPorNome(nome);

                    em.getTransaction().begin();

                    em.remove(a);

                    em.getTransaction().commit();

                    System.out.println("\nAluno removido com sucesso!");

                } catch (NoResultException e) {
                    System.out.println("\nAluno não encontrado!");
                }

            }else if(opcao == 3) {
                System.out.println("\nALTERAR ALUNO:");
                // leitura para consumir o new line do int opcao:
                leitorTeclado.nextLine();
                System.out.print("Digite o nome: ");
                String nome = leitorTeclado.nextLine();

                try {
                    Aluno a = dao.buscarUnicoPorNome(nome);

                    System.out.println("Dados do aluno: ");
                    System.out.println("Nome: "+a.getNome());
                    System.out.println("Email: "+a.getEmail());
                    System.out.println("RA: "+a.getRa());
                    System.out.println("Notas: "+a.getNota1()+" - "+a.getNota2()+" - "+a.getNota3());

                    System.out.println("\nNOVOS DADOS: ");
                    System.out.print("Digite o nome: ");
                    String nomeNovo = leitorTeclado.nextLine();
                    System.out.print("Digite o RA: ");
                    String ra = leitorTeclado.nextLine();
                    System.out.print("Digite o email: ");
                    String email = leitorTeclado.nextLine();
                    System.out.print("Digite a nota 1: ");
                    BigDecimal nota1 = leitorTeclado.nextBigDecimal();
                    System.out.print("Digite a nota 2: ");
                    BigDecimal nota2 = leitorTeclado.nextBigDecimal();
                    System.out.print("Digite a nota 3: ");
                    BigDecimal nota3 = leitorTeclado.nextBigDecimal();

                    em.getTransaction().begin();

                    a.setNome(nomeNovo);
                    a.setRa(ra);
                    a.setEmail(email);
                    a.setNota1(nota1);
                    a.setNota2(nota2);
                    a.setNota3(nota3);

                    em.getTransaction().commit();

                    System.out.println("\nAluno alterado com sucesso!");

                } catch (NoResultException e) {
                    System.out.println("\nAluno não encontrado!");
                }

            }else if(opcao == 4) {
                System.out.println("\nCONSULTAR ALUNO:");
                // leitura para consumir o new line do int opcao:
                leitorTeclado.nextLine();
                System.out.print("Digite o nome: ");
                String nome = leitorTeclado.nextLine();

                try {
                    Aluno a = dao.buscarUnicoPorNome(nome);

                    System.out.println("Dados do aluno: ");
                    System.out.println("Nome: "+a.getNome());
                    System.out.println("Email: "+a.getEmail());
                    System.out.println("RA: "+a.getRa());
                    System.out.println("Notas: "+a.getNota1()+" - "+a.getNota2()+" - "+a.getNota3());

                } catch (NoResultException e) {
                    System.out.println("\nAluno não encontrado!");
                }

            }else if(opcao == 5) {
                List<Aluno> todos = dao.buscarTodos();

                if(todos.isEmpty()){
                    System.out.println("Nenhum aluno cadastrado!");

                } else {
                    System.out.println("Exibindo todos os alunos:");

                    for(Aluno a : todos) {
                        System.out.println("\nNome: "+a.getNome());
                        System.out.println("Email: "+a.getEmail());
                        System.out.println("RA: "+a.getRa());
                        System.out.println("Notas: "+a.getNota1()+" - "+a.getNota2()+" - "+a.getNota3());
                        System.out.printf("Media: %.2f\n", a.getMedia());
                        System.out.println("Situação: "+a.getAprovacao());
                    }
                }

            }else if(opcao == 6) {
                System.out.println("\nEncerrando Programa...");

                em.close();
            }else {
                System.out.println("\nOPÇÃO INVÁLIDA!");
            }
        }
    }
}