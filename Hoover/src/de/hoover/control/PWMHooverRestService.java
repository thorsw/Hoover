package de.hoover.control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.hoover.HooverFactory;
import de.hoover.PWMHoover;

public class PWMHooverRestService {

	private static PWMHoover hoover;

	private static PWMHoover getHoover() {
		if (hoover == null) {
			hoover = HooverFactory.createPWMHoover();
		}
		return hoover;
	}

	@GET
	@Path("left/{value}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String left(@PathParam("value") String value) {
		System.out.println("Left: " + value);
		getHoover().left(Integer.valueOf(value));
		return "left: " + value;
	}

	@GET
	@Path("right/{value}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String right(@PathParam("value") String value) {
		System.out.println("Right: " + value);
		getHoover().right(Integer.valueOf(value));
		return "right: " + value;
	}

	@GET
	@Path("stop/")
	@Produces({ MediaType.TEXT_PLAIN })
	public String stop() {
		System.out.println("Stop");
		getHoover().stop();
		return "stop";
	}

}
