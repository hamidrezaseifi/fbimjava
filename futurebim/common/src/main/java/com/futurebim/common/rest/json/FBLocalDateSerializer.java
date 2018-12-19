package com.futurebim.common.rest.json;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class FBLocalDateSerializer extends StdSerializer<LocalDate> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(JsonConstants.DATE_FORMAT_ISO);

	protected FBLocalDateSerializer() {
		super(LocalDate.class);

	}

	@Override
	public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider arg2)
			throws IOException {
		if (value != null) {
			gen.writeString(value.format(formatter));
		} else {
			gen.writeString("");
		}
	}

}
