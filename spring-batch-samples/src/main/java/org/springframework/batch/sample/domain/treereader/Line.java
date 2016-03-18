package org.springframework.batch.sample.domain.treereader;



/**
 * Helper to wrapper an register and the corresponding type read from a line from a file;
 * 
 * @author guilherme
 *
 */
public class Line {

	private LineType type;
	
	private Object content;

	public LineType getType() {
		return type;
	}

	public void setType(LineType type) {
		this.type = type;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
