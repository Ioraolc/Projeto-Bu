package bu.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import bu.modelo.Usuario;

public class UsuarioDAO {
	public boolean Cadastrar(Usuario usuario) {
		if (!this.ExisteUsuario(usuario.getEmail())) {
			Key chavePrimaria = KeyFactory.createKey("Usuario", usuario.getEmail()); 
			
			Entity entidadeUsuario = new Entity(chavePrimaria);
			entidadeUsuario.setProperty("nome", usuario.getNome());
			entidadeUsuario.setProperty("email", usuario.getEmail());
			entidadeUsuario.setProperty("cidade", usuario.getCidade());
			entidadeUsuario.setProperty("estado", usuario.getEstado());
			entidadeUsuario.setProperty("pais", usuario.getPais());
<<<<<<< HEAD
			entidadeUsuario.setProperty("senha",usuario.getSenha());
			entidadeUsuario.setProperty("telefone", usuario.getTelefone());
			entidadeUsuario.setProperty("txperiencia", usuario.getExp_trabalho());
			
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(entidadeUsuario);
			
			return true;
		}
		
		return false;
			
	}
	private boolean ExisteUsuario(String email) {
=======
			entidadeUsuario.setProperty("cd_postal", usuario.getCd_postal());
			entidadeUsuario.setProperty("senha",usuario.getSenha());
			entidadeUsuario.setProperty("num_telefone", usuario.getNum_telefone());
			entidadeUsuario.setProperty("form_escolar", usuario.getForm_escolar());
			entidadeUsuario.setProperty("exp_trabalho", usuario.getExp_trabalho());
			
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(entidadeUsuario);
			
			return true;
		}
		
		return false;
			
	}
	private boolean ExisteUsuario(String email) {
		// TODO Auto-generated method stub
>>>>>>> branch 'master' of http://github.com/Ioraolc/Projeto-Bu.git
		return false;
	}
	public boolean existeUsuario(String email) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Usuario");
		Filter filtro = new FilterPredicate("email", FilterOperator.EQUAL, email);
		query.setFilter(filtro);
		
		PreparedQuery pq = datastore.prepare(query);
		if (pq.asSingleEntity() == null) {
			return false;
		}
		return true;
		
	}
		
}

