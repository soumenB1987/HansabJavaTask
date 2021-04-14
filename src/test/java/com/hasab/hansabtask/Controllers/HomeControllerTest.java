package com.hasab.hansabtask.Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HomeController.class)
class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllCustomers() throws Exception {

        String sampleTestData = "[{\"id\":1,\"name\":\"Teet JÃ¤rvekÃ¼la\"},{\"id\":2,\"name\":\"Pille Purk\"}}]";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users")).andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assert.hasText(sampleTestData, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getCustomer() throws Exception {

        String sampleTestData = "{\"id\":1,\"name\":\"Teet JÃ¤rvekÃ¼la\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1")).andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(sampleTestData, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getCars() throws Exception {

        String carData = "{\"id\":1,\"make\":\"Lada\",\"model\":\"2101\",\"numberplate\":\"123ASD\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/cars")).andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assert.hasText(carData, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getAllCars() throws Exception {

        String sampleCarData = "{\"id\":2,\"make\":\"Kia\",\"model\":\"Sorento\",\"numberplate\":\"534TTT\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cars")).andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assert.hasText(sampleCarData, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getCarById() throws Exception {

        String sampleCarData = "{\"id\":2,\"make\":\"Kia\",\"model\":\"Sorento\",\"numberplate\":\"534TTT\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cars/1")).andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(sampleCarData, mvcResult.getResponse().getContentAsString());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void sortUser() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user?find=Teet&sort=name:asc")).andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
