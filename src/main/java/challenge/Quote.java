package challenge;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

	String quote;
	String actor;

	@JsonProperty("actor")
	public String getActor() {
		return this.actor;
	}
	@JsonProperty("quote")
	public String getQuote() {
		return this.quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String toJsonQuote(){
		return "{\"quote\":\""+this.getQuote()+"\"}";
	}

	public String toJsonActor(String actor){
		return "{\"actor\":\""+this.getActor()+"\","+"\"quote\":\""+this.getQuote()+"\"}";
	}


}
