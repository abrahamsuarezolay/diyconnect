package com.diyconnect;

import com.diyconnect.message.Message;
import com.diyconnect.message.MessageService;
import com.diyconnect.message.MessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DiyconnectApplicationTests {

	@Autowired
	private MessageServiceImpl messageService;

	@Test
	void contextLoads() {
	}

	@Test
	public void MessageService_ObtainAllMessages_ReturnsListOfMessages() {
		List<Message> messages = (List<Message>) messageService.findAll();

		System.out.println(messages.get(0).getMessage() + " " + messages.get(0).getSender().getUsername() + " " + messages.get(0).getReceiver().getUsername());

	}

}
