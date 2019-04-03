package challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/v1/quote/*")
public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Quote quote;
			String pathInfo = req.getPathInfo();
			QuoteDao quoteDao = new QuoteDao();
			if (pathInfo == null || pathInfo.equals("/")) {

				quote = quoteDao.getQuote();

				PrintWriter out = resp.getWriter();
				out.print(quote.toJsonQuote());
				out.flush();

			} else {
				String actor = pathInfo.split("/")[1];
				quote = quoteDao.getQuoteByActor(actor);

			//	String json = new ObjectMapper().writeValueAsString(quote);
				PrintWriter out = resp.getWriter();
				out.print(quote.toJsonActor(actor));
				out.flush();
			}
			resp.setStatus(HttpServletResponse.SC_FOUND);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
