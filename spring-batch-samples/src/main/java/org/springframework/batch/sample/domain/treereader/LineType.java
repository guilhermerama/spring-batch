package org.springframework.batch.sample.domain.treereader;

/**
 * Possible values for the type of the lines on a treeFile;
 * 
 * @author guilherme
 *
 */
public enum LineType {
	
	FILE_HEADER(0), ENTERPRISE_HEADER(1), DEPARTMENT_HEADER(2), WORKER(3),
	DEPARTMENT_TRAILER(4), ENTERPRISE_TRAILER(5), FILE_TRAILER(6)
	;

	private int value;
	
	private LineType(int value){
		this.value = value;
	}
	
	public static LineType fromValue(int value){
		for(LineType type: LineType.values()){
			if(type.getValue() == value){
				return type;
			}
		}
		return null;
	}
	
	public int getValue(){
		return this.value;
	}
	
}
