package com.featurebim.common.rest.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class FBLocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(JsonConstants.DATETIME_FORMAT_ISO);

	protected FBLocalDateTimeSerializer() {
		super(LocalDateTime.class);

	}

	@Override
	public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider arg2)
			throws IOException {
		if (value != null) {
			gen.writeString(value.format(formatter));
		} else {
			gen.writeString("");
		}
	}

}
