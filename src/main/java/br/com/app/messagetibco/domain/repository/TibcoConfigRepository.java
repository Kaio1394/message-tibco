package br.com.app.messagetibco.domain.repository;

import br.com.app.messagetibco.domain.model.TibcoConfigSender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TibcoConfigRepository {
    private final EntityManager em;

    public TibcoConfigRepository(EntityManager em) {
        this.em = em;
    }

    public void save(TibcoConfigSender entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
    public List<TibcoConfigSender> getListTibcoConfig(){
        return em.createQuery("FROM TibcoConfigSender", TibcoConfigSender.class).getResultList();
    }

    public boolean existsByTag(String tag) {
        Long count = em.createQuery(
                        "SELECT COUNT(t) FROM TibcoConfigSender t WHERE t.tag = :tag",
                        Long.class
                )
                .setParameter("tag", tag)
                .getSingleResult();

        return count > 0;
    }
}
