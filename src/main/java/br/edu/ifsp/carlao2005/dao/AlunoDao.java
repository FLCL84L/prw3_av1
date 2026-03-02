package br.edu.ifsp.carlao2005.dao;

import br.edu.ifsp.carlao2005.modelo.Aluno;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AlunoDao {
    private EntityManager em;

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Aluno aluno) {
        this.em.persist(aluno);
    }

    public Aluno buscarPorId(Long id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> buscarTodos() {
        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql, Aluno.class).getResultList();
    }
}
