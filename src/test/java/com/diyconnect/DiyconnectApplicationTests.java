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

}
