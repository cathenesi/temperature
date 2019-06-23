package org.asofth.iot.temperature.service;

import org.asofth.iot.temperature.dto.MeasureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {

	@Autowired
	private SimpMessagingTemplate template;

	public void publish(MeasureDTO event) {

		this.template.convertAndSend("/topic", event.toString());
	}

}