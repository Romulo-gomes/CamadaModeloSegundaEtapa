/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author romulo
 */
public class TesteExcluirEspecialidade {

    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        Especialidade esp = em.find(Especialidade.class, 3);
        
        em.getTransaction().begin();
        em.remove(esp);
        em.getTransaction().commit();
    }
    
}
