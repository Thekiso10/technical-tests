package com.mca.infrastructure.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class VideoGameEvent {
	private Long stock_id;

	private boolean availability;

	private Timestamp time_update;


}
