package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripCustomFieldsResponse extends DripResponse {

	@JsonProperty("custom_field_identifiers") public List<String> customFieldIdentifiers = new ArrayList<String>();
}
