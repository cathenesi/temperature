package org.asofth.iot.temperature.service;

import org.asofth.iot.temperature.dto.MeasureDTO;
import org.asofth.iot.temperature.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {

	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private EventRepository repository;
	
	public void start() throws Exception {
		this.publish(repository.findLast());
	}

	public void publish(MeasureDTO event) {
		
		if (event == null) {
			return;
		}

		this.template.convertAndSend("/topic", event.toString());
		repository.save(event);
	}

}