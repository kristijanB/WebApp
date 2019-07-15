package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.GetDBConnection;
import com.data.GetHnbData;

/**
 * Servlet implementation class GetCurrency
 */
public class GetCurrency extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCurrency() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetDBConnection connection = new GetDBConnection();

		GetHnbData data = new GetHnbData();

		String string = "<option value=" + "HRK" + ">HRK</option>";

		try {
			if (connection.getCurrency() == null) {
				connection.insert(data.jsonGetRequest());

			} else {
				connection.updateCurrData(data.jsonGetRequest());
			}
			for (String s : connection.getCurrency()) {
				string += "<option value=" + s + ">" + s + "</option>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNow = new Date();
		String date = "<input type=\"date\" value=" + format.format(dateNow) + ">";
		request.setAttribute("value", string);
		request.setAttribute("date", date);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);

		// dispatcher = request.getRequestDispatcher("/index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String amountCurr = request.getParameter("val1");
		String amountCurr2 = request.getParameter("val2");
		double amountVal = 0;
		double count = 0;
		if (amountCurr.contentEquals("HRK")) {
			if (amountCurr2.contentEquals("HRK")) {
				request.setAttribute("iznos", count + 1);
				doGet(request, response);
			}

		} else {
			if (request.getParameter("amount").isEmpty()) {
				amountVal = 1;
			} else {
				amountVal = Double.parseDouble(request.getParameter("amount"));
			}

			GetDBConnection connection = new GetDBConnection();
			try {
				if (!amountCurr2.contentEquals("HRK")) {
					String[] format = connection.getKupovni(amountCurr);

					double convert = Double.parseDouble(format[0].replace(",", "."));
					count = amountVal * convert;

					String[] format2 = connection.getKupovni(amountCurr2);
					double convert2 = Double.parseDouble(format2[0].replace(",", "."));
					if (format[1].contentEquals("100")) {
						double count2 = (count / convert2) / Double.parseDouble(format[1]);
						request.setAttribute("iznos", count2);
						doGet(request, response);
					} else {
						double count2 = (count / convert2) * Double.parseDouble(format2[1]);
						request.setAttribute("iznos", count2);
						doGet(request, response);
					}

				} else {
					String[] format = connection.getKupovni(amountCurr);

					double convert = Double.parseDouble(format[0].replace(",", "."));
					if (format[1].contentEquals("100")) {
						count = (convert * amountVal) / Double.parseDouble(format[1]);
					} else {
						count = convert * amountVal;
					}

					request.setAttribute("iznos", count);

					doGet(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
