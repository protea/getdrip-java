package cc.protea.drip;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

class DripJsonUtils {

	static ObjectMapper objectMapper = new DripJsonConfiguration().getContext(Void.class);
	static ObjectMapper parser = new DripJsonConfiguration().getParser();

	static <T> T fromJson(final byte[] content, final Class<T> valueType) {
		if (content == null || content.length == 0) {
			return null;
		}
		try {
			return DripJsonUtils.parser.readValue(content, valueType);
		} catch (IOException e) {
			return null;
		}
	}

	static <T> T fromJson(final String content, final Class<T> valueType) {
		try {
			return DripJsonUtils.parser.readValue(content, valueType);
		} catch (IOException e) {
			throw new RuntimeException(e);
//			return null;
		}
	}

	static <T> T fromJson(final String content, final TypeReference<T> valueType) {
		try {
			return DripJsonUtils.parser.readValue(content, valueType);
		} catch (IOException e) {
			return null;
		}
	}

	static <T> T fromJson(final Reader reader, final Class<T> valueType) {
		if (reader == null) {
			return null;
		}
		try {
			return DripJsonUtils.parser.readValue(reader, valueType);
		} catch (IOException e) {
			return null;
		}
	}

	static String toJson(final Object object) {
		if (object == null) {
			return null;
		}
		try {
			return DripJsonUtils.objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
