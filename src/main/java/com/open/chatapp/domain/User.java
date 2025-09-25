package com.open.chatapp.domain;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	private String name;
	
	private String employee_num;
	
	private String passsword;
	
	private String email;
	
	private String phone_num;
	
	private Date start_date;
	
	private Date end_date;
	
	@CreationTimestamp
	private LocalDateTime create_at;

	@OneToOne
	private JobGrade grade_id;
	
	@OneToMany(mappedBy = "user_id")
	private List<Notification> notifications;
	
	@OneToMany(mappedBy = "user")
	private List<UserDepartment> user_dept;
	
	@OneToMany(mappedBy = "user_id")
	private List<Attendance> attendance;
}
