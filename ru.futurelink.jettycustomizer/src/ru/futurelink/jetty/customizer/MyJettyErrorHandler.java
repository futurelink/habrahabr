package ru.futurelink.jetty.customizer;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.handler.ErrorHandler;

public class MyJettyErrorHandler extends ErrorHandler {
	@Override
	protected void handleErrorPage(HttpServletRequest request,
			Writer writer, int code, String message) throws IOException {
		if (code == 404) {
			writer.write("No,no,no!!! This page does not exist!");
			return;
		}
		
		super.handleErrorPage(request, writer, code, message);
	}
	

}
