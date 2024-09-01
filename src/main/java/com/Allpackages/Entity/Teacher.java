package com.Allpackages.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
	@Id
	@SequenceGenerator(
			name="teacher_sequence",
			sequenceName = "teacher_sequence",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_sequence")
	private Long teacherId;
	private String Name;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
//	private List<Course> courses;

}
