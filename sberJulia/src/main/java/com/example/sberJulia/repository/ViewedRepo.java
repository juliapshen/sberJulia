package com.example.sberJulia.repository;

import com.example.sberJulia.model.ModelViewed;
import com.example.sberJulia.model.ModelViewers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewedRepo implements ViewedForAMSImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public ModelViewers getViewedForAms() {

        String queryStr = "select * from viewed";
        try {
            Query query = entityManager.createNativeQuery(queryStr);
            List<Object[]> objects = query.getResultList();
            List<ModelViewed> list = new ArrayList<>(objects.size());
            for (Object[] object : objects) {
                list.add(new ModelViewed((String) object[0], (String) object[1]));
            }
            ModelViewers modelViewers = new ModelViewers(list);
            return modelViewers;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
