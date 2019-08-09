package com.jonatan.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Integer guessNumber;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		guessNumber = (Integer) session.getAttribute("guessNumber");
		
		if (guessNumber == null) {
			Random r = new Random();
			guessNumber = Integer.valueOf(r.nextInt(100) + 1);
			System.out.println("Number to guess: " + guessNumber);
			session.setAttribute("guessNumber", guessNumber);
		}
		
		String userGuess = request.getParameter("guess");
		Integer guess = Integer.valueOf(0);
		String message = "";
		String msgClass = "failure";
		String inputClass = "";
		String buttonMsg = "Submit";
		
		if (userGuess == null || userGuess.equals("")) {
			msgClass = "hidden";
		} else {
			guess = Integer.valueOf(userGuess);
			System.out.println("Guessing: " + guess);
		}
		if (guess.equals(guessNumber)) {
			message = guessNumber + " was the number!";
			session.invalidate();
			msgClass = "success";
			inputClass = "hidden";
			buttonMsg = "Play again!";
		} else if (guess.intValue() > guessNumber.intValue()) {
			message = "Too high!";
		} else if (guess.intValue() < guessNumber.intValue()) {
			message = "Too low!";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("msgClass", msgClass);
		request.setAttribute("inputClass", inputClass);
		request.setAttribute("guessNumber", guessNumber);
		request.setAttribute("buttonLabel", buttonMsg);
		request.getRequestDispatcher("/html/Game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}
