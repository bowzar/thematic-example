package com.yulintu.thematic.example.employee;

import com.yulintu.thematic.data.DbConnection;
import com.yulintu.thematic.data.DbTransaction;
import com.yulintu.thematic.data.Provider;
import com.yulintu.thematic.data.hibernate.RepositoryPersistenceImpl;
import org.hibernate.Session;

import java.util.List;

@DbConnection
public class RepositoryEmployeeImpl extends RepositoryPersistenceImpl implements RepositoryEmployee {

    public RepositoryEmployeeImpl(Provider provider) {
        super(provider);
    }

    @Override
    public String echo(String val) {
        return val + "#" + this.getClass().getName() + "#" + getProvider().getId();
    }

    @SuppressWarnings("unchecked")
    @DbTransaction
    @Override
    public List<User> all() {

//        throw new EmployeeTestException("链接未打开", new Exception("test"));

        Object val = getSession()
                        .createQuery("from User")
                        .list();

        return (List<User>) val;
    }

    @Override
    public int add(User user) {


        Session session = getSession();

                    session.save(user);
                    session.flush();
                    session.clear();

        return 1;
    }

    @Override
    public int update(String name, User user) {

        Object val = getSession().createQuery("update User user set user.properties = :p, user.createTime = :t where user.name = :name ")
                        .setParameter("name", user.getName())
                        .setParameter("p", user.getProperties())
                        .setParameter("t", user.getCreateTime())
                        .executeUpdate();

        return (int) val;
    }

    @Override
    public int delete(String name) {

        Object val = getSession().createQuery("delete from User user where user.name = :name")
                        .setParameter("name", name)
                        .executeUpdate();

        return (int) val;
    }
}
