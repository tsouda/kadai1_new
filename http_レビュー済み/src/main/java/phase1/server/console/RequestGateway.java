package phase1.server.console;

import org.springframework.integration.annotation.Gateway;

public interface RequestGateway {

	@Gateway
	String File_send(Object object);
}