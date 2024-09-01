package com.Allpackages.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//main aim is to represent both student class and guardian class in one table in database.(in Single entity class i will access another class properties)
//i want to represent Guardian class properties in student class so we use   @Embeddable  .so that we can Embedded it in our student class using @Embedded


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


//use case.
//for Example your table is already defined in database that has all properties or columns that represented in both class.
//if for Example think a scenario that the properties names that present in Guardian class and column names present in databases is different then we have to map it.

//we can map it by using 

@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column = @Column(name="guardian_name")
			),
	@AttributeOverride(
			name = "email",
			column = @Column(name="guardian_email")
			),
	@AttributeOverride(
			name="mobile",
			column = @Column(name="guardian_mobile")
			)
})

public class Guardian {
	private String name;
	private String email;
	private String mobile;
}
