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
		//resp.setContentType("application/json;charset=UTF-8");
		
		//StringBuffer parametro = new StringBuffer();
		//String line = null;
		
		//BufferedReader reader = req.getReader();
		//while ((line = reader.readLine()) != null)
			//parametro.append(line.trim());
		
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
		
		String cd_postal = req.getParameter("cd_postal");
		usuario.setCd_postal(cd_postal);
		
		String senha = req.getParameter("senha");
		usuario.setSenha(senha);
		
		String num_telefone = req.getParameter("num_telefone");
		usuario.setNum_telefone(num_telefone);
		
		String form_escolar = req.getParameter("form_escolar");
		usuario.setNum_telefone(form_escolar);
		
		String exp_trabalho = req.getParameter("exp_trabalho");
		usuario.setNum_telefone(exp_trabalho);
		
		boolean cadastroRealizado = new UsuarioDAO().Cadastrar(usuario);
		
		//Falta mensagem
		
	}
}
