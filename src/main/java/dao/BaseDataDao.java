package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import constant.QueueStatusConstant;
import entities.BaseData;
import ninja.jpa.UnitOfWork;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Singleton
public class BaseDataDao {
    @Inject
    private Provider<EntityManager> entityManagerProvider;

    @UnitOfWork
    public Long count() {
        EntityManager entityManager = entityManagerProvider.get();

        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(BaseData.class)));

        return entityManager.createQuery(cq).getSingleResult();
    }

    @Transactional
    public void createData(int MAX_DATA_COUNT) {
        EntityManager entityManager = entityManagerProvider.get();

        for (int index = 1; index <= MAX_DATA_COUNT; index++) {
            BaseData baseData = new BaseData();
            baseData.setData(index);
            baseData.setQueueStatus(QueueStatusConstant.DEQUEUED);

            entityManager.persist(baseData);
        }
    }
}
