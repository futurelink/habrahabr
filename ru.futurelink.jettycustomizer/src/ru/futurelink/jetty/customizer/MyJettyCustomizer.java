package ru.futurelink.jetty.customizer;

import java.util.Dictionary;

import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.equinox.http.jetty.JettyCustomizer;

import ru.futurelink.jetty.ws.MyServletContextListener;

import com.sun.xml.ws.transport.http.servlet.WSServlet;

public class MyJettyCustomizer extends JettyCustomizer {
	@Override
	public Object customizeContext(Object context,
			Dictionary<String, ?> settings) {

		ErrorHandler errorHandler = new MyJettyErrorHandler();
		errorHandler.setShowStacks(true);
		
		ServletContextHandler c = (ServletContextHandler) context;
		c.setResourceBase("/tmp");
		c.setErrorHandler(errorHandler);

		c.getServletHandler().addServletWithMapping(MyFileServlet.class, "/files/*");		
		c.getServletHandler().addServletWithMapping(WSServlet.class, "/service/mobile");

		// Добавляем веб-сервисы
		MyServletContextListener listener = new MyServletContextListener();
		c.getServletContext().getContextHandler().addEventListener(listener);

		return c;	
	}

}
