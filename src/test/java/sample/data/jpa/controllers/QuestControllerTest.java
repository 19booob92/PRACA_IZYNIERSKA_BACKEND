package sample.data.jpa.controllers;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import sample.data.jpa.model.Question;


public class QuestControllerTest {

    @Test
    public void shouldReturnAllQuests() {

        // given
        List<Question> listOfAllQuestions;
        // then
        // assertThat(listOfAllQuestions).contains()
        assertFalse(1 == 1);
    }

    @Test
    public void shouldDeleteQuestion() {
        // given
        List<Question> listOfAllQuestions;
        // then
        assertFalse(1 == 1);
    }
}
