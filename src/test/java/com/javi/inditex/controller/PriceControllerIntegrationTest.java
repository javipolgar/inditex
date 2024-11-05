package com.javi.inditex.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class PriceControllerIntegrationTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	private final static String URL = "/api/price";
	
	@BeforeEach
	public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testGetPriceAt10AMOnJune14() throws Exception {
		mockMvc.perform(get(URL)
						.param("brandId", "1")
						.param("productId", "35455")
						.param("applicationDate", "2020-06-14T10:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	public void testGetPriceAt4PMOnJune14() throws Exception {
		mockMvc.perform(get(URL)
						.param("brandId", "1")
						.param("productId", "35455")
						.param("applicationDate", "2020-06-14T16:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(25.45));
	}

	@Test
	public void testGetPriceAt9PMOnJune14() throws Exception {
		mockMvc.perform(get(URL)
						.param("brandId", "1")
						.param("productId", "35455")
						.param("applicationDate", "2020-06-14T21:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	public void testGetPriceAt10AMOnJune15() throws Exception {
		mockMvc.perform(get(URL)
						.param("brandId", "1")
						.param("productId", "35455")
						.param("applicationDate", "2020-06-15T10:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(30.50));
	}

	@Test
	public void testGetPriceAt9PMOnJune16() throws Exception {
		mockMvc.perform(get(URL)
						.param("brandId", "1")
						.param("productId", "35455")
						.param("applicationDate", "2020-06-16T21:00:00"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(38.95));
	}

	@Test
	public void testGetPriceAndReturnNotFound() throws Exception{
		mockMvc.perform(get(URL)
						.param("brandId", "33")
						.param("productId", "35455")
						.param("applicationDate", "2020-06-16T21:00:00"))
				.andExpect(status().isNotFound());
	}

}