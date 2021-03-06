package com.yulintu.thematic.example.provider;

import com.yulintu.thematic.data.hibernate.ProviderPersistence;
import com.yulintu.thematic.example.test.User;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfiguration.class)
public class TestProvider {

    @Autowired
    private ProviderPersistence provider;

    private static final ThreadLocal<ProviderPersistence> tl = new ThreadLocal<>();

    @Test
    public void testCommonQuery() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ProviderPersistence provider = ac.getBean(ProviderPersistence.class);
        ProviderPersistence provider1 = ac.getBean(ProviderPersistence.class);
        ProviderPersistence provider2 = ac.getBean(ProviderPersistence.class);

        provider = tl.get();
        if (provider == null) {
            tl.set(provider = ac.getBean(ProviderPersistence.class));
        }

        provider = tl.get();

        provider.openConnection();

        List list0 = provider.getCurrentSession().createSQLQuery("select * from SecurityObject")
                    .addEntity("SecurityObject", User.class)
                    .setFirstResult(1)
                    .setMaxResults(3)
                    .list();

        List<User> list1 = list0;

        provider.closeConnection();
    }

    @Test
    public void testQueryNew() {

        Object obj = provider.getCurrentSession()
                .createSQLQuery("select * from SecurityObject")
                .addEntity("SecurityObject", User.class)
                .setFirstResult(1)
                .setMaxResults(3)
                .list();
    }

    @Test
    public void testAddNew() {

        Session session = provider.getCurrentSession();


            for (int i = 0; i < 1000; i++) {

                User user = new User();
                user.setName("HIDE");
                session.save(user);

                if (i % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }

        System.out.println(1000);
    }


    @Test
    public void testDeleteNew() {

        Object obj = provider.getCurrentSession()
                .createQuery("delete from User user where user.name = :name ")
                .setParameter("name", "HIDE")
                .executeUpdate();

        System.out.println(obj);
    }

    @Test
    public void testUpdateInTransaction() {

        Object obj = provider.getCurrentSession()
                .createQuery("update  User user set user.properties = :p where user.name = :name ")
                .setParameter("name", "HIDE")
                .setParameter("p", "hahahah")
                .executeUpdate();

        System.out.println(obj);
    }

    @Test
    public void tesCountInTransaction() {

        Object obj = provider.getCurrentSession()
                .createQuery("select count(0) from User where name <> :name")
                .setParameter("name", "HIDE")
                .uniqueResult();

        System.out.println(obj);
    }
}
