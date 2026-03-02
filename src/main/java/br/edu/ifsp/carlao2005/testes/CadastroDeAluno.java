package br.edu.ifsp.carlao2005.testes;

import br.edu.ifsp.carlao2005.dao.AlunoDao;
import br.edu.ifsp.carlao2005.modelo.Aluno;
import br.edu.ifsp.carlao2005.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CadastroDeAluno {
    public static void main(String[] args) {



        // menu projeto
        /*
        int opcao = 0;

        // Leitor
        Scanner leitorTeclado = new Scanner(System.in);
        // menu

        while(opcao != 6) {

            System.out.println("\n** CADASTRO DE ALUNOS **");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Excluir Aluno");
            System.out.println("3 - Alterar Aluno");
            System.out.println("4 - Buscar aluno pelo nome");
            System.out.println("5 - Listar alunos (com status de aprovação)");
            System.out.println("6 - FIM");
            System.out.print("\nDigite a opção desejada: ");

            opcao = leitorTeclado.nextInt();

            System.out.println("OPCAO SELECIONADA: " + opcao);

        }

         */


        // testes

        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao dao = new AlunoDao(em);

        /*
        // teste find

        Aluno a = dao.buscarPorId(3l);

        if(a == null){
            System.out.println("Aluno não encontrado!");
        } else {
            System.out.println(a.getNome());
            System.out.println(a.getRa());
            System.out.println(a.getEmail());
            System.out.println(a.getNota1());
            System.out.println(a.getNota2());
            System.out.println(a.getNota3());

            /*
            em.getTransaction().begin();
            a.setNome("Paulo");
            a.setEmail("paulo@gmail.com");
            a.setNota1(new BigDecimal("1.5"));
            a.setNota2(new BigDecimal("3.5"));
            a.setNota3(new BigDecimal("6.5"));
            a.setRa("SC10003");
            em.getTransaction().commit();

        }

        */

        // teste listar todos

        List<Aluno> todos = dao.buscarTodos();

        if(todos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado!");

        } else {
            for(Aluno a : todos) {
                System.out.println("----------------------------");
                System.out.println(a.getNome());
                System.out.println(a.getRa());
                System.out.println(a.getEmail());
                System.out.println(a.getNota1());
                System.out.println(a.getNota2());
                System.out.println(a.getNota3());
            }

        }










        /*

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Maria");
        aluno1.setRa("SC10002");
        aluno1.setNota1(new BigDecimal("8"));
        aluno1.setNota2(new BigDecimal("9"));
        aluno1.setNota3(new BigDecimal("10"));
        aluno1.setEmail("maria@gmail.com");

        EntityManager em = JPAUtil.getEntityManager();

        AlunoDao dao = new AlunoDao(em);

        em.getTransaction().begin();

        em.persist(aluno1);

        em.getTransaction().commit();

        em.close();

        */






        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}