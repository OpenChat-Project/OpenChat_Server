package com.open.chatapp.domain;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendance_id;
	
	private Date attn_date;
	
	private LocalDateTime start_time;
	
	private LocalDateTime end_time;
	
	private int status;
	
	@ManyToOne
	private User user_id;
}
