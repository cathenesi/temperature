package org.asofth.iot.temperature.ws;

import org.asofth.iot.temperature.dto.MeasureDTO;
import org.asofth.iot.temperature.service.EventPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(value = "IOT Collector")
@RequestMapping("/listener")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class TemperatureController {

	@Autowired
	private EventPublisherService service;

//	long temp = 30;
//	@Scheduled(fixedDelay = 1000)
//	public void testCollecting() {
//		if (temp == 30) {
//			temp = 31;
//		} else {
//			temp = 30;
//		}
//		this.collect(new MeasureDTO(BigDecimal.valueOf(temp), BigDecimal.valueOf(70L), new Date()));
//	}

	@PostMapping
	public void collect(@RequestBody(required = true) MeasureDTO sample) {

		log.info(">> measured value: " + sample.toString());
		service.publish(sample);
	}
}
