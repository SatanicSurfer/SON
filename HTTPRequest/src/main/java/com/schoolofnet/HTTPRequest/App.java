package com.schoolofnet.HTTPRequest;

import java.util.concurrent.Future;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws UnirestException {
		Future<HttpResponse<JsonNode>> asyncRes = Unirest.get("http://httpbin/get")
				.asJsonAsync(new Callback<JsonNode>() {

					public void failed(UnirestException arg0) {
						System.out.println("Request Failed.");
					}

					public void completed(HttpResponse<JsonNode> response) {
						System.out.println(response.getBody());
					}

					public void cancelled() {
						System.out.println("Request Canelled.");

					}
				});
		// HttpResponse<JsonNode> response =
		// Unirest.post("http://httpbin.org/post")
		// .queryString("Key","SomeValue")
		// .field("field1", "value1")
		// .field("field2", "value2")
		// .asJson();
		System.out.println("Finish");
	}
}
