package br.edu.ifsp.carlao2005;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Aluno aluno1 = new Aluno();
        aluno1.setNome("João");
        aluno1.setRa("SC10001");
        aluno1.setNota1(new BigDecimal("6"));
        aluno1.setNota2(new BigDecimal("7"));
        aluno1.setNota3(new BigDecimal("8"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escola");

        EntityManager em = factory.createEntityManager();

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