package com.example.sberJulia;

import com.example.sberJulia.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SberJuliaApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    /**
     * тест для метода dataContentFromCMS контроллера ContentDeliveryController
     * значения которые должны быть размещены в бд присутствуют в тестах
     * contentGuid "0070c797-50fa-41c6-b62d-1d560e1a987a" data "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"
     * contentGuid "18a3f1bc-0c6a-4954-8d8c-547d7a515ad5" data "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"
     *
     * @throws Exception
     */
    @Test
    public void dataContentFromCMSTest() throws Exception {
        List<ModelPublishedContent> dataContent = new ArrayList<>();
        dataContent.add(new ModelPublishedContent("0070c797-50fa-41c6-b62d-1d560e1a987a", "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"));
        dataContent.add(new ModelPublishedContent("18a3f1bc-0c6a-4954-8d8c-547d7a515ad5", "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"));
        ModelPublishedContentList dataContentList = new ModelPublishedContentList(dataContent);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String content = objectWriter.writeValueAsString(dataContentList);

        runTest(content, "dataContentFromCMS");
    }

    /**
     * тест для метода saveViewed контроллера ContentDeliveryController
     *
     * @throws Exception
     */
    @Test
    public void saveViewedTest() throws Exception {
        List<ModelViewed> viewed = new ArrayList<>();
        viewed.add(new ModelViewed("0b198a31-ffb8-11ec-9d96-0c9d92326ce8", "0b1662a4-ffb8-11ec-9d96-0c9d92326ce8"));
        viewed.add(new ModelViewed("0b198a31-ffb8-11ec-9d96-0c9d92326ce8", "0b1662a4-ffb8-11ec-9d96-0c9d92326ce8"));
        ModelViewers viewers = new ModelViewers(viewed);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String content = objectWriter.writeValueAsString(viewers);

        runTest(content, "saveViewed");
    }

    /**
     * тест для метода  saveTargetFromAMS контроллера ContentDeliveryController
     *
     * @throws Exception
     */
    @Test
    public void saveTargetFromAMSTest() throws Exception {
        List<ModelOffersTarget> offersTargets = new ArrayList<>();
        offersTargets.add(new ModelOffersTarget("18e84d35-a469-4a5d-885a-63328b2ecd5e", 99));
        offersTargets.add(new ModelOffersTarget("86a3f1bc-0c6a-4954-8d8c-547d7a512ad1", 98));
        List<ModelTarget> target = new ArrayList<>();
        target.add(new ModelTarget("0c12f9b1-ffb8-11ec-9d96-0c9d92326ce8", offersTargets));
        target.add(new ModelTarget("0b38dcea-ffb8-11ec-9d96-0c9d92326ce8", offersTargets));
        Date dateStart = new Date();
        Date dateEnd = new Date(dateStart.getTime() + (3600 * 24 * 1000));
        ModelTargetOffers targetOffers = new ModelTargetOffers("MAIN_PAGE", dateStart, dateEnd, target);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String content = objectWriter.writeValueAsString(targetOffers);

        runTest(content, "saveTargetFromAMS");
    }

    /**
     * тест для метода getViewed контроллера ContentDeliveryController
     *
     * @throws Exception
     */

    @Test
    public void getViewedTest() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/contentDelivery/method")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.viewed").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.viewed[0].contentGuid").value("11d2eb66-ffba-11ec-9d96-0c9d92326ce8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.viewed[0].userGuid").value("0b198a31-ffb8-11ec-9d96-0c9d92326ce8"))
        ;
    }

    /**
     * тест для метода getOffers контроллера ContentDeliveryController
     *
     * @throws Exception
     */
    @Test
    public void getOffersTest() throws Exception {

        ModelTargetPage model = new ModelTargetPage("test1", "0c12f9b1-ffb8-11ec-9d96-0c9d92326ce8");

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String data = objectWriter.writeValueAsString(model);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/contentDelivery/getOffers")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(data);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.offers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.offers[0].content.data").value("'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.offers[0].content.loadDate").value("21022022"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.offers[0].content.priority").value("99"))
        ;
    }

    private void runTest(String data, String methodName) throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/contentDelivery/" + methodName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(data);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }
}
