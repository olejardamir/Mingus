package dao;

/**
 * Created by damir on 19/08/17.
 */

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import models.Actions;
import models.Contacts;
import models.History;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class dbDao {

        @Inject
        private
        Provider<EntityManager> entityManagerProvider;


    @PersistenceContext
    @Transactional
    public List<Contacts> getContacts() {
            EntityManager entityManager = entityManagerProvider.get();
            String s = "SELECT x FROM Contacts x ";
            TypedQuery<Contacts> q = entityManager.createQuery(s, Contacts.class);
            entityManager.clear();
            return q.getResultList();
    }


    @PersistenceContext
    @Transactional
    public List<History> getHistory() {
        EntityManager entityManager = entityManagerProvider.get();
        String s = "SELECT x FROM History x ";
        TypedQuery<History> q = entityManager.createQuery(s, History.class);
        entityManager.clear();
        return q.getResultList();
    }


    @PersistenceContext
    @Transactional
    public void setNewAction(Long fk) {
        Actions a = new Actions();
        a.setContactid(fk);
        EntityManager entityManager = entityManagerProvider.get();
        entityManager.clear();
        entityManager.persist(a);
    }

}
