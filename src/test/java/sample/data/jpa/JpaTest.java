package sample.data.jpa;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import sample.data.jpa.model.Question;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.utils.Utils;
 

@WebAppConfiguration
@ContextConfiguration(classes = { SampleDataJpaApplication.class })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@PropertySource({ "classpath:application.properties" })
public class JpaTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    QuestionService questionService;

    @Autowired 
    private WebApplicationContext ctx;
    
    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    private MockMvc mockMvc;
    
    @Test
    public void dump() {
    }


    @Test
    public void shouldSaveDataToDataBase() {
        // given
        Question quest = new Question();
        quest.setContent("Glupie pytanie");
        // when
        questionService.addQuestion(quest);
        // Question questFromDB = questionService.getOneQuestion(quest.getId());
        Question questFromDB = (Question) em.createQuery("select c from Question c where c.content = 'Glupie pytanie'").getSingleResult();
        // then
        assertTrue("Pobrano odpowiednie dane",
                quest.getContent().equals(questFromDB.getContent()));
    }

    @Test
    public void shouldGetOneRowWithPropertlyData() throws InterruptedException {
        // given
        Question quest;
        // when
        quest = questionService.getOneQuestion(4L);
        // then
        assertTrue("Pobrano odpowiednie dane",
                quest.getContent().equals("asd"));
    }
  @Test
  public void shouldSaveToDBNewQuestion() throws Exception {
      // given
      Question quest = new Question(); // FIXME zrobić buildery
      quest.setContent("Pytanie");

      // then
      mockMvc.perform(post("/quest/create")
              .content(Utils.convertObjectToJsonBytes(quest)))

              .andExpect(status().isOk())
              .andExpect(jsonPath("$[0].content", is("Proste pytanie")));

  }

}
