package sample.data.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import sample.data.jpa.SampleDataJpaApplication;

@WebAppConfiguration
@ContextConfiguration(classes = { SampleDataJpaApplication.class })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({ "classpath:application.properties" })
public class IntegrationTest {

    @PersistenceContext
    EntityManager em;
    
}
