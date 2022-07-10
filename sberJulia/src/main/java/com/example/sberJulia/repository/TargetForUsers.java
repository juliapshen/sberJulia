package com.example.sberJulia.repository;

import com.example.sberJulia.model.ModelContent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TargetForUsers implements TargetForUsersImlp {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ModelContent> getTargetForUsers(String user) {

        String queryStr = "select c.data data, t.priority priority, t.start_date loadDate from content as c \n" +
                "inner join target as t on t.content_guid = c.guid \n" +
                "where t.user_guid= ?1 ORDER BY t.priority DESC;";
        try {
            Query query = entityManager.createNativeQuery(queryStr);
            query.setParameter(1, user);
            List<Object[]> objects = query.getResultList();
            List<ModelContent> list = new ArrayList<>(objects.size());
            for (Object[] object : objects) {
                list.add(new ModelContent((String) object[0], (Date) object[2], (int) object[1]));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}