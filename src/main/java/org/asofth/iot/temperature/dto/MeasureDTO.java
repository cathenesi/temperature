package org.asofth.iot.temperature.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "A measured temperature register")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasureDTO {

	@ApiModelProperty(position = 1, value = "Temperature in Celsius Degrees")
	@JsonProperty("temperature")
	private BigDecimal temperatureInCelsius;

	@ApiModelProperty(position = 2, value = "Relative humidity")
	@JsonProperty("humidity")
	private BigDecimal humidity;

	private Date date = new Date();

	public static MeasureDTO fromJson(String asJson) throws Exception {

		return new ObjectMapper().readValue(asJson, MeasureDTO.class);
	}

	@Override
	public String toString() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			log.error("Error serializing to Json", e);
		}
		return null;
	}

}
