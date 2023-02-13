package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Pessoa;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = new Pessoa();
		String acao = request.getParameter("botao");
		List<Pessoa> pessoas = new ArrayList<>();
		
		if (acao.equalsIgnoreCase("cadastro")) {
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setNome(request.getParameter("nome"));
			p.setDataNascimento(request.getParameter("data_nascimento"));
			
			System.out.println(p);
		}
		
		if (acao.equalsIgnoreCase("listar")) {
			Pessoa p1 = new Pessoa();
			p1.setId(1001);
			p1.setNome("Fulano");
			p1.setDataNascimento("1982-09-22");
			
			Pessoa p2 = new Pessoa();
			p2.setId(1002);
			p2.setNome("Cicrano");
			p2.setDataNascimento("1990-04-08");

			Pessoa p3 = new Pessoa();
			p3.setId(1003);
			p3.setNome("Beltrano");
			p3.setDataNascimento("1986-06-27");
			
			pessoas.add(p1);
			pessoas.add(p2);
			pessoas.add(p3);

		}
		
		request.setAttribute("pessoas", pessoas);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
