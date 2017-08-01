package pl.kwi.springboot.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pl.kwi.springboot.commands.OutputCommand;
import pl.kwi.springboot.services.NameService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputControllerTest {
	
	@Autowired
    private OutputController controller;
	
	@Mock
	private OutputCommand command;
	
	@MockBean
	private NameService nameService;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

	@Test
	public void displayPage() {
		when(nameService.load()).thenReturn("Chris");
		assertThat(controller.displayPage(command)).isEqualTo("output");
		verify(command).setName("Chris");
	}
	
	@Test
    public void handleButtonOk() {
    	assertThat(controller.handleButtonBack()).isEqualTo("redirect:/input");
    }

}
