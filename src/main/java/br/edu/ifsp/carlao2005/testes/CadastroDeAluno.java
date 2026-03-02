package br.edu.ifsp.carlao2005.testes;

import br.edu.ifsp.carlao2005.dao.AlunoDao;
import br.edu.ifsp.carlao2005.modelo.Aluno;
import br.edu.ifsp.carlao2005.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CadastroDeAluno {
    public static void main(String[] args) {


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