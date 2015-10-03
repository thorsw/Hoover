package de.hoover.control;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class HooverWebControl implements HooverController {

	@Override
	public void start() {
		try {
			HttpServer server = HttpServerFactory
					.create("http://localhost:8080/hoover");
			server.start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {

	}

}
