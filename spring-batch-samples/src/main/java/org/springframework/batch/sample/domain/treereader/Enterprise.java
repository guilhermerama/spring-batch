package org.springframework.batch.sample.domain.treereader;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain class representing an enterprise.
 * 
 * @author guilherme
 *
 */
public class Enterprise {


	private Integer id;
	
	private String name;
	
	private List<Department> departments = new ArrayList<Department>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addDepartment(Department department) {
		this.departments.add(department);
		
	}

	public List<Department> getDepartments() {
		return departments;
	}
	
}
