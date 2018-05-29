package net.dilwit.test.integration;

import net.dilwit.test.model.Move;
import net.dilwit.test.repo.MoveRepository;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

	// 
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	MoveRepository repo;
	
	@Before
	public void setUp() {		
		// add initial data
	}
	
	@After
	public void cleanUp() {
		// remove initial data
	}
	
	@Test
	public void readMove_shouldReturnMoveDetails() {
		// given initial data
		int id = 0;
		
		// when
		ResponseEntity<Move> response = testRestTemplate.exchange("/move/?", HttpMethod.GET, null, Move.class, id);
		
		// then
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	public void addMove_shouldAddMoveSuccessfully() {
		// given
		Move move = new Move();
		
		// when
		ResponseEntity<Move> response = testRestTemplate.exchange("/move", HttpMethod.POST, new HttpEntity<Move>(move), Move.class);
		
		// then
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	public void updateMove_shouldUpdateMoveSuccessfully() {
		// given initial data
		Move move = new Move();
		
		// when
		ResponseEntity<Move> response = testRestTemplate.exchange("/move", HttpMethod.PUT, new HttpEntity<Move>(move), Move.class);
		
		// then
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	public void removeMove_shouldDeleteMoveSuccessfully() {
		// given initial data
		int id = 0;
		
		// when
		ResponseEntity<Move> response = testRestTemplate.exchange("/move", HttpMethod.DELETE, null, Move.class, id);
		
		// then
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}	
}
