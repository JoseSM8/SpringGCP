package cl.ejercicio.model.dto;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Students")
@EntityListeners(AuditingEntityListener.class)
public class StudentsDTO {

	@Id
	@NotEmpty
	@Size(min=9,max=10)
	@Pattern(regexp="^[1-9]{7,8}\\-[a-zA-Z0-9]$", message = "Invalid rut")
	private String rut;
	private String name;
	private String lastName;
	@Min(18)
	private Integer age;
	private String course;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
