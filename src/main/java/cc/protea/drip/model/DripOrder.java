package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripOrder {
	
	public static enum FinancialState {
		@JsonProperty("pending") PENDING, 
		@JsonProperty("authorized") AUTHORIZED, 
		@JsonProperty("partially_paid") PARTIALLY_PAID, 
		@JsonProperty("paid") PAID, 
		@JsonProperty("partially_refunded") PARTIALLY_REFUNDED, 
		@JsonProperty("refunded") REFUNDED, 
		@JsonProperty("voided") VOIDED
	}

	public static enum FulfillmentState {
		@JsonProperty("not_fulfilled") NOT_FULFILLED, 
		@JsonProperty("partially_fulfilled") PARTIALLY_FULFILLED, 
		@JsonProperty("fulfilled") FULFILLED
	}

	public static class Address {
		public String name;
		@JsonProperty("first_name") public String firstName;
		@JsonProperty("last_name") public String lastName;
		public String company;
		@JsonProperty("address_1") public String address1;
		@JsonProperty("address_2") public String address2;
		public String city;
		public String state;
		public String zip;
		public String country;
		public String phone;
		public String email;
	}
	
	public static class Item {
		public String name;
		public Integer amount;
		public Integer price;
		public Integer tax;
		public Integer fees;
		public Integer discount;
		public Integer quantity;
		@JsonProperty("product_id") public String productId;
		@JsonProperty("upstream_id") public String upstreamId;
		@JsonProperty("upstream_product_id") public String upstreamProductId;
		@JsonProperty("upstream_product_variant_id") public String upstreamProductVariantId;
		public String sku;
		public Boolean taxable;
		public Map<String, Object> properties = new HashMap<String, Object>();
	}
	
	public String id;
	public String provider;
	public Integer amount;
	public Integer tax;
	public Integer fees;
	public Integer discount;
	public String permalink;
	@JsonProperty("currency_code") public String currencyCode;
	@JsonProperty("upstream_id") public String upstreamId;
	public String identifier;
	public Map<String, String> properties = new HashMap<String, String>();
	@JsonProperty("occurred_at") public Date occurredAt;
	@JsonProperty("closed_at") public Date closedAt;
	@JsonProperty("cancelled_at") public Date cancelledAt;
	@JsonProperty("financial_state") public FinancialState financialState;
	@JsonProperty("fulfillment_state") public FulfillmentState fulfillmentState;
	@JsonProperty("billing_address") public Address billingAddress;
	@JsonProperty("shipping_address") public Address shippingAddress;
	public List<Item> items = new ArrayList<Item>();
	public Map<String, String> links = new HashMap<String, String>();
		
}
