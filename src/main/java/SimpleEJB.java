import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Stateless
public class SimpleEJB {
    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    DataSource datasource;

    @PersistenceContext
    EntityManager entityManager;

    public void doTest() throws SQLException {
        System.out.println("doTest called");
        Connection connection = datasource.getConnection();
        entityManager.persist(new TestEntity());
        connection.close();
        System.out.println("doTest done");
    }
}
