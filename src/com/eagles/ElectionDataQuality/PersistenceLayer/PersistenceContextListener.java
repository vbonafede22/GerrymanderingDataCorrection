package com.eagles.ElectionDataQuality.PersistenceLayer;

import javax.persistence.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceContextListener implements ServletContextListener {
    @PersistenceUnit(unitName = "devPU")
    private EntityManagerFactory entityManagerFactory;
    private static ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        entityManagerFactory = Persistence.createEntityManagerFactory("devPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        context.setAttribute("em", entityManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        entityManagerFactory.close();
    }

    public static ServletContext getApplicationContext(){
        return context;
    }
}
