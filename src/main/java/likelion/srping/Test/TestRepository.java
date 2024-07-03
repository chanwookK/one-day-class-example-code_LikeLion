package likelion.srping.Test;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(TestEntity te) {
        em.persist(te);
        return te.getId();
    }

    public TestEntity find(Long id) {
        return em.find(TestEntity.class, id);
    }

}
