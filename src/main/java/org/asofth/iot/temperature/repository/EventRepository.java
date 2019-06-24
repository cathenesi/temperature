package org.asofth.iot.temperature.repository;

import org.asofth.iot.temperature.dto.MeasureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	public void save(MeasureDTO event) {
		this.redisTemplate.opsForValue().set(MeasureDTO.class.toString(), event.toString());
	}
	
	public MeasureDTO findLast() throws Exception {
		String last = (String) this.redisTemplate.opsForValue().get(MeasureDTO.class.toString());
		return MeasureDTO.fromJson(last);
	}
	
}
