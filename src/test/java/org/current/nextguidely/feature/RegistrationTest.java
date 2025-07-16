package org.current.nextguidely.feature;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.current.nextguidely.model.dto.CreateUserDTO;
import org.current.nextguidely.persistence.entity.Gender;
import org.current.nextguidely.response.RegisterSuccessResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegistrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		// Optionally reset test DB
	}
	
	@Test
	void testRegister_Successful() throws Exception {
		CreateUserDTO createUserDTO = new CreateUserDTO();
//
		createUserDTO.setId(1L);
		createUserDTO.setName("John Doe");
		createUserDTO.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-15"));
		createUserDTO.setEmail("john.doe@example.com");
		createUserDTO.setGender(Gender.MALE);
		
		
		mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/api/users")
								.accept(MediaType.APPLICATION_JSON)
				)
				.andDo(print())
				.andExpect(status().is(200))
				.andExpect(jsonPath("$.message").value("success"));
		
		mockMvc
				.perform(MockMvcRequestBuilders.get("/api/users/1"))
//				.andDo(print())
				.andDo(result -> {
					String content = result.getResponse()
					                       .getContentAsString();
					
					RegisterSuccessResponse registerSuccessResponse = objectMapper.readValue(content, RegisterSuccessResponse.class);
					Map<Object, Object> newUser = (Map<Object, Object>) registerSuccessResponse.data;
					Map<Object, Object> user = (Map<Object, Object>) newUser.get("user");
					System.out.println("------------------------------");
					System.out.println("------------------------------");
					user.forEach((key, value) -> {
						System.out.println(key + " : "+ value);
					});
					System.out.println("------------------------------");
					System.out.println("------------------------------");
				});
		
	}
}