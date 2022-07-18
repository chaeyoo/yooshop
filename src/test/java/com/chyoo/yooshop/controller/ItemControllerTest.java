package com.chyoo.yooshop.controller;

import com.chyoo.yooshop.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(controllers = ItemController.class)
@DisplayName("ItemController 테스트")
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllItemsTest() throws Exception {
        // given

        // when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/items")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertEquals(response.getStatus(),HttpStatus.OK.value());
    }
}