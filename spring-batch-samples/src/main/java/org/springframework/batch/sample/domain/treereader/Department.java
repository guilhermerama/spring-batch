package org.springframework.batch.sample.domain.treereader;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain class representing a department from an enteprise.
 * 
 * @author guilherme
 *
 */
public class Department {

	private Integer id;
	
	private String name;
	
	private List<Worker> workers = new ArrayList<Worker>();

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

	public void addWorker(Worker worker) {
		this.workers.add(worker);
		
	}

	public List<Worker> getWorkers() {
		return workers;
	}
}
