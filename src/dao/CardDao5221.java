package dao;

import com.CardEO5221;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ys
 * @version 1.0.0
 */
public class CardDao5221 implements CardService5221 {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("study2PU");

    /**
     * 将学生卡信息保存到数据库
     */

    public static void save(CardEO5221 card) {
        EntityManager em = emf.createEntityManager();
        /**
         * 开始一个事务
         */
        em.getTransaction().begin();
        //持久化操作
        em.persist(card);
        //提交事务
        em.getTransaction().commit();
        //关闭EntityManager
        em.close();
    }

    /**
     * 更新实体
     *
     * @param detachedInstance
     */
    public static void update(CardEO5221 detachedInstance) {
        //更新实体
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(detachedInstance);
        em.getTransaction().commit();
        //关闭EntityManager
        em.close();
    }

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */

    public static CardEO5221 findById(int id) {
        //根据主键查找实体
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CardEO5221 instance = em.find(CardEO5221.class, id);
        return instance;
    }

    /**
     * 查找所有的实体
     *
     * @return
     */
    public static List<CardEO5221> findAll() {
        EntityManager em = emf.createEntityManager();
        //查询EQL
        String sq1 = "SELECT c From CardEO5221 c";
        em.getTransaction().begin();
        Query query = em.createQuery(sq1);
        em.getTransaction().commit();

        return query.getResultList();
    }

    @Override
    public void delete(int id) {
        //删除实体
        CardEO5221 instance = findById(new Integer(1));
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(instance);
        em.getTransaction().commit();
        em.close();
    }
}
