package com.futurebim.common.model.edo;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futurebim.common.crypt.FBTextCryption;
import com.futurebim.common.rest.json.JsonConstants;
import com.futurebim.common.rest.xml.LocalDateTimeAdapter;

/**
 * The persistent class for the users database table.
 *
 */
public class EncryptedContentEdo {

	private String encryptedContent;

	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	@JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
	private LocalDateTime created = LocalDateTime.now();

	public EncryptedContentEdo() {
	}

	public String getEncryptedContent() {
		return encryptedContent;
	}

	private String getDecryptedContent() throws Exception {
		return FBTextCryption.decrypt(Base64.getDecoder().decode(encryptedContent));
	}

	public <T> T getObjectContent(final Class<T> valueType, final ObjectMapper mapper) throws Exception {

		final String decContent = getDecryptedContent();
		final T t = mapper.readValue(decContent, valueType);

		return t;
	}

	public <T> T getObjectContent(final TypeReference<T> valueType, final ObjectMapper mapper) throws Exception {

		final String decContent = getDecryptedContent();
		final T t = mapper.readValue(decContent, valueType);

		return t;
	}

	public void setContent(final String content) throws Exception {

		setEncryptedContent(Base64.getEncoder().encodeToString(FBTextCryption.encrypt(content)));
	}

	public void setContentObject(final Object contentObject, final ObjectMapper mapper) throws Exception {

		setContent(mapper.writeValueAsString(contentObject));
	}

	public void setEncryptedContent(final String encryptedContent) {
		this.encryptedContent = encryptedContent;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

}
