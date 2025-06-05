package br.com.elvisfarias.main.modules.company.controllers;

import br.com.elvisfarias.main.modules.company.dto.CreateJobDTO;
import br.com.elvisfarias.main.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreatJobControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void sholdBeAbleToCreateNewJob() throws Exception {
        var createJobDTO = CreateJobDTO.builder()
                .benefits("Benefits_teste")
                .level("Level_teste")
                .description("Description_teste")
                .build();

        var token = TestUtils.generateToken(
                UUID.fromString("10c10416-89f8-48d8-805e-d3c5978ba034"),
                "Javagas.@123456#!"
        );

        var result = mvc.perform(MockMvcRequestBuilders.post("/company/job") // sem barra no final
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(createJobDTO))
                .header("Authorization", token)
        ).andExpect(status().isOk());

        System.out.println(result);
    }

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
