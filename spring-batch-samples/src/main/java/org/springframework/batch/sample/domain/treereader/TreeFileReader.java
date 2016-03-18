package org.springframework.batch.sample.domain.treereader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Toy Reader example to show approach for reading well-formed tree structured files. Example file with tabulation helping visualization:
 * 
 * FILE HEADER
    ENTERPISE1 HEADER
        DEPARTMENT1 HEADER
            WORKER1
            WORKER2
        DEPARTMENT1 FOOTER
        DEPARTMENT2 HEADER
            WORKER3
        DEPARTMENT2 FOOTER
    ENTERPRISE1 FOOTER  
    ENTERPRISE2 HEADER
        DEPARTMENT3 HEADER
            WORKER4
        DEPARTMENT3 FOOTER
    ENTERPRISE2 FOOTER
 * 
 * 
 * @author guilherme
 *
 */
public class TreeFileReader implements ItemReader<Enterprise>{

	ItemReader<Line> delegate;

	
	@Override
	public Enterprise read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		// init temp variables
		Enterprise enterprise = null;
		Department currentDepartment = null;
		
		Line line = delegate.read();
		
		while(line != null){
			
			switch(line.getType()){
				
			case ENTERPRISE_HEADER:
				enterprise = (Enterprise) line.getContent();
				break;
				
			case DEPARTMENT_HEADER:
				currentDepartment = (Department) line.getContent();
				enterprise.addDepartment(currentDepartment);
				break;
			
			case WORKER:
				Worker currentWorker = (Worker) line.getContent();
				currentDepartment.addWorker(currentWorker);
				break;
				
			default:
				// Explicit ignore other types
				break;
			
			}
		}
		
		return enterprise;
	}
	
}