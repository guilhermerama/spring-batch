package org.springframework.batch.sample.domain.treereader;

/**
 * Domain class representing a worker from a department inside an enterprise.
 * 
 * @author guilherme
 *
 */
public class Worker {

	private Integer id;
	
	private String name;

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
	
	
}
