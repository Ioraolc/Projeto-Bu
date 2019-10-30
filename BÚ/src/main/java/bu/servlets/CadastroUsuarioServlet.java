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
<<<<<<< HEAD
=======
<<<<<<< HEAD
		
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
		
=======
		//resp.setContentType("application/json;charset=UTF-8");
		
		//StringBuffer parametro = new StringBuffer();
		//String line = null;
		
		//BufferedReader reader = req.getReader();
		//while ((line = reader.readLine()) != null)
			//parametro.append(line.trim());
>>>>>>> branch 'master' of https://github.com/Ioraolc/Projeto-Bu.git
		
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
		
<<<<<<< HEAD
=======
		//Falta mensagem
>>>>>>> branch 'master' of http://github.com/Ioraolc/Projeto-Bu.git
>>>>>>> branch 'master' of https://github.com/Ioraolc/Projeto-Bu.git
		
	}
}
