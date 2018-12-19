package com.futurebim.common.rest.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class FBLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(JsonConstants.DATETIME_FORMAT_ISO);

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected FBLocalDateTimeDeserializer() {
		super(LocalDateTime.class);

	}

	@Override
	public LocalDateTime deserialize(final JsonParser jsonparser, final DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		final String date = jsonparser.getText();

		return date == null ? null : LocalDateTime.parse(date, formatter);
	}

}
