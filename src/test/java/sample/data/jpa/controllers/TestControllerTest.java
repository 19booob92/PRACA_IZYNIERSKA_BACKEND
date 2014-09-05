package sample.data.jpa.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import sample.data.jpa.utils.IntegrationTest;
import static org.assertj.core.api.Assertions.*;


public class TestControllerTest extends IntegrationTest {

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    private MockMvc mockMvc;

    // FIXME dodać sztywny generator liczb pseudolosowych (tki żeby można go
    // było kontrolować)

    @Test
    public void shouldReturnJsonWithTest() throws Exception {
        // given
        // when
        MvcResult result = mockMvc.perform(get("/test/getTest/5"))
                .andExpect(status().isOk())
                .andReturn();
        // then
        assertThat(result.getResponse().getContentAsString())
                .isEqualTo(
                        "[{\"id\":4,\"content\":\"asd\"},{\"id\":4,\"content\":\"asd\"},{\"id\":4,\"content\":\"asd\"},{\"id\":4,\"content\":\"asd\"},{\"id\":4,\"content\":\"asd\"}]");
    }

}
