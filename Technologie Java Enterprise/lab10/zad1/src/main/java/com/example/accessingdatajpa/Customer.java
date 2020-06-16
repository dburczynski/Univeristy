package com.example.accessingdatajpa;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@lombok.Getter(AccessLevel.PUBLIC)
	private Long id;

	@lombok.Getter(AccessLevel.PUBLIC)
	@lombok.Setter(AccessLevel.PUBLIC)
	private String firstName;

	@lombok.Getter(AccessLevel.PUBLIC)
	@lombok.Setter(AccessLevel.PUBLIC)
	private String lastName;

	@lombok.Getter(AccessLevel.PUBLIC)
	@lombok.Setter(AccessLevel.PUBLIC)
	private Double money;

	@lombok.Getter(AccessLevel.PUBLIC)
	@lombok.Setter(AccessLevel.PUBLIC)
	private Date date;



}
