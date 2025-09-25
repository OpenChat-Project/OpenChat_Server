package com.open.chatapp.domain;

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
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dept_id;
	
	private String dept_name;
	
	@OneToOne
	private Department parent_id;
	
	@CreationTimestamp
	private LocalDateTime create_at;
	
	@OneToMany(mappedBy = "department")
	private List<UserDepartment> user;
}
