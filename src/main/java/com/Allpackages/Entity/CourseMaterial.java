package com.Allpackages.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@ToString(exclude = "course")
public class CourseMaterial {
	@Id
	@SequenceGenerator(
			name="course_sequence_material",
			sequenceName = "course_sequence_material",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence_material"
			)
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
//	Cascade in JPA is a feature that allows us to propagate the state transition from a parent entity to a child entity. 
//	For example, if we persist or remove a parent entity, we can also persist or remove the related child entities
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
			)
	private Course course;
	
	
}

//With LAZY loading, associated entities are not loaded immediately when the main entity is fetched from the database.
//only current entity will be get as output .but not other entity also which are connected with current.
//With EAGER loading, associated entities are loaded immediately along with the main entity when it is fetched from the database.
//it will get all entity data that along with current and other entity also.