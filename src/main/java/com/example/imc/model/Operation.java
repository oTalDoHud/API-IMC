package com.example.imc.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.imc.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Tb_Operations")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Pesos")
	private Double n1;
	
	@Column(name = "Alturas")
	private Double n2;
	
	@Column(name = "Resultados")
	private Double result;
	
	@Column(name = "Momentos")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@Column(name = "Generos")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public Operation() {

	}
	
	public Operation(Double n1, Double n2, Double result, Instant moment, Gender gender) {
		this.n1 = n1;
		this.n2 = n2;
		this.result = result;
		this.moment = moment;
		this.gender = gender;
	}
	
	public Operation(Integer id, Double n1, Double n2, Double result, Instant moment, Gender gender) {
		this.id = id;
		this.n1 = n1;
		this.n2 = n2;
		this.result = result;
		this.moment = moment;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPeso() {
		return n1;
	}

	public void setPeso(Double n1) {
		this.n1 = n1;
	}

	public Double getAltura() {
		return n2;
	}

	public void setAltura(Double n2) {
		this.n2 = n2;
	}

	public Double getResultado() {
		return result;
	}

	public void setResultado(Double result) {
		this.result = result;
	}

	public Gender getGenero() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Instant getMomento() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operation other = (Operation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
