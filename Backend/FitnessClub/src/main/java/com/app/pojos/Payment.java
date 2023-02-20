package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Payment extends BaseEntity
{
	@Column(name="amount")
	private double amount;

	@CreationTimestamp
	@Column(name="Date")
	private LocalDateTime paymentDate;
	
	@ManyToOne
	@JoinColumn(name="mmeber")
	private Member member;
	
	@OneToOne
	@JoinColumn(name="package")
	private Packages packages;
	
	
}
