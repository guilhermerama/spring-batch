package org.springframework.batch.sample.domain.treereader;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class WorkerFieldSetMapper implements FieldSetMapper<Line> {

	@Override
	public Line mapFieldSet(FieldSet fieldSet) throws BindException {
		Line line = new Line();
		line.setType(LineType.fromValue(fieldSet.readInt("type")));
		
		Worker worker= new Worker();
		worker.setName(fieldSet.readString("name"));
		
		line.setContent(worker);
		
		return line;
	}

}
