package com.featurebim.common.rest.json;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class FBLocalDateDeserializer extends StdDeserializer<LocalDate> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(JsonConstants.DATE_FORMAT_ISO);

	protected FBLocalDateDeserializer() {
		super(LocalDate.class);

	}

	@Override
	public LocalDate deserialize(final JsonParser jsonparser, final DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		final String date = jsonparser.getText();

		return date == null ? null : LocalDate.parse(date, formatter);
	}

}
