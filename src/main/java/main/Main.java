package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;
import servlets.AllRequestsServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        final org.eclipse.jetty.util.log.Logger LOG = Log.getLogger(Main.class);
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        LOG.info("Server started");
        server.join();
    }
}
