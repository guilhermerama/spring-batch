package org.springframework.batch.sample.domain.treereader;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class EnterpriseFieldSetMapper implements FieldSetMapper<Line> {

	@Override
	public Line mapFieldSet(FieldSet fieldSet) throws BindException {
		Line line = new Line();
		line.setType(LineType.fromValue(fieldSet.readInt("type")));
		
		Enterprise enterprise = new Enterprise();
		enterprise.setName(fieldSet.readString("name"));
		
		line.setContent(enterprise);
		
		return line;
	}

}
