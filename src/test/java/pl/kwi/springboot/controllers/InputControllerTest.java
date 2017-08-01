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

import pl.kwi.springboot.commands.InputCommand;
import pl.kwi.springboot.services.NameService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputControllerTest {

	@Autowired
    private InputController controller;
	
	@Mock
	private InputCommand command;
	
	@MockBean
	private NameService nameService;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    
    @Test
    public void displayPage() {
    	assertThat(controller.displayPage()).isEqualTo("input");
    }
    
    @Test
    public void handleButtonOk() {
    	when(command.getName()).thenReturn("Chris");
    	assertThat(controller.handleButtonOk(command)).isEqualTo("redirect:/output");
    	verify(nameService).save("Chris");
    }

}
