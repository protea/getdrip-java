package cc.protea.drip;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

class DripJsonConfiguration {

	ObjectMapper objectMapper;
	ObjectMapper parsingObjectMapper;

	DripJsonConfiguration() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		@SuppressWarnings("deprecation")
		Version version = new Version(1, 0, 0, "SNAPSHOT");
		SimpleModule module = new SimpleModule("DeserializationModule", version)
			.addDeserializer(Boolean.class, new BooleanClassDeserializer())
			.addDeserializer(Boolean.TYPE, new BooleanTypeDeserializer())
			.addDeserializer(String.class, new StringClassDeserializer());
		this.objectMapper = new ObjectMapper()
			.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
			.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
			.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
//			.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false)
			.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false)
			.setDateFormat(dateFormat)
			.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
	//		.setSerializationInclusion(Include.NON_EMPTY)
			.setSerializationInclusion(Include.NON_NULL);
		this.parsingObjectMapper = new ObjectMapper()
			.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
			.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
			.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
			.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false)
			.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false)
			.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
			.registerModule(module);
	}

	public ObjectMapper getParser() {
		return this.parsingObjectMapper;
	}

	public ObjectMapper getContext(final Class<?> type) {
		return objectMapper;
	}

	class StringClassDeserializer extends JsonDeserializer<String> {

		@Override
		public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
			JsonToken t = jp.getCurrentToken();
			if (t == JsonToken.VALUE_STRING) {
				String text = jp.getText().trim();
				if (text.length() == 0) {
					return null;
				}
				return text;
			}
			throw ctxt.mappingException(String.class);
		}


	}

	class BooleanClassDeserializer extends JsonDeserializer<Boolean> {

		@Override
		public Boolean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
			JsonToken t = jp.getCurrentToken();
			if (t == JsonToken.VALUE_TRUE) {
				return true;
			}
			if (t == JsonToken.VALUE_FALSE) {
				return false;
			}
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return (jp.getIntValue() != 0);
			}
			if (t == JsonToken.VALUE_STRING) {
				String text = jp.getText().trim();
				if ("true".equalsIgnoreCase(text)) {
					return true;
				}
				if ("false".equalsIgnoreCase(text) || text.length() == 0) {
					return Boolean.FALSE;
				}
				if ("N".equalsIgnoreCase(text) || text.length() == 0) {
					return Boolean.FALSE;
				}
				if ("Y".equalsIgnoreCase(text)) {
					return Boolean.TRUE;
				}
				throw ctxt.weirdStringException(text, Boolean.class, "Only \"true\" or \"false\" recognized");
			}
			// Otherwise, no can do:
			throw ctxt.mappingException(Boolean.class);
		}

	}

	class BooleanTypeDeserializer extends BooleanClassDeserializer {
		@Override
		public Boolean getNullValue(DeserializationContext ctxt) {
			return Boolean.FALSE;
		}
	}


}
