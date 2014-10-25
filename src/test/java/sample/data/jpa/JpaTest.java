package sample.data.jpa;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import sample.data.jpa.model.Question;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.utils.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
 

public class JpaTest extends IntegrationTest {

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
  public void shouldSaveObjectToDB() throws Exception {
      // given
      Question quest = new Question(); // FIXME zrobić buildery
      quest.setContent("Pytanie");

      // then
      MvcResult result = mockMvc.perform(post("/quest/create")
              .content(new ObjectMapper().writeValueAsString(quest))
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andReturn();
      
      Question questFromDB = (Question) em.createQuery("select c from Question c where c.content = 'Pytanie'").getSingleResult();
      
      assertTrue(questFromDB.getContent().equals("Pytanie"));
  }
  

  @Test(expected = NoResultException.class)
  public void shouldDeleteObjectFromDB() throws Exception {
      // given
      Question questFromDB = (Question) em.createQuery("select c from Question c where c.id = 4").getSingleResult();
      // then
      MvcResult result = mockMvc.perform(delete("/quest/delete/4")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andReturn();
      
      assertTrue(questFromDB != null);
      
      questFromDB = (Question) em.createQuery("select c from Question c where c.id = 4").getSingleResult();
  }
  
  @Test
  public void shouldAddPointsForQuestion() {
  }
  

}
