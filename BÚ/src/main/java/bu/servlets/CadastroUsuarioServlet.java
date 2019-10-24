package bu.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bu.modelo.Usuario;
import bu.dao.UsuarioDAO;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = { "/cadastroUsuario" })
public class CadastroUsuarioServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		String nome = req.getParameter("nome");
		usuario.setNome(nome);
		
		String email = req.getParameter("email");
		usuario.setEmail(email);
		
		String cidade = req.getParameter("cidade");
		usuario.setCidade(cidade);
		
		String estado = req.getParameter("estado");
		usuario.setEstado(estado);
		
		String pais = req.getParameter("pais");
		usuario.setPais(pais);
		
		
		String senha = req.getParameter("senha");
		usuario.setSenha(senha);
		
		String telefone = req.getParameter("telefone");
		usuario.setTelefone(telefone);
		
		
		String experiencia = req.getParameter("experiencia");
		usuario.setExperiencia(experiencia);
		
		boolean cadastroRealizado = new UsuarioDAO().Cadastrar(usuario);
		
		
	}
}
