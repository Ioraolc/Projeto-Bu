package bu.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import bu.modelo.Bico;
import bu.modelo.Usuario;

public class BicoDAO {

	public List<Bico> listarItens(){
		List<Bico> itens = new ArrayList<Bico>();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query query = new Query("Bico");
		Filter filtro = new FilterPredicate("disponivel", FilterOperator.EQUAL, true);
		query.setFilter(filtro);
		
		PreparedQuery pq = datastore.prepare(query);
		
		List<Entity> entidades = pq.asList(FetchOptions.Builder.withLimit(1000));
		for (Entity entidade : entidades) {
			Bico bico = new Bico();
			bico.setDescricao((String)entidade.getProperty("descricao"));
			bico.setDetalhes((String)entidade.getProperty("detalhes"));
			bico.setDisponivel((Boolean)entidade.getProperty("disponivel"));
			
			Usuario doador = new Usuario();
			doador.setEmail((String)entidade.getProperty("doador"));
			bico.setDoador(doador);
			
			itens.add(bico);
		}
		
		return itens;
	}
	
	public boolean cadastrar(Bico bico) {
		
		if (!this.existeItemCadastrado(bico.getDescricao())) {
			Key chavePrimaria = KeyFactory.createKey("Bico", bico.getDescricao()); 
			
			Entity entidadeItem = new Entity(chavePrimaria);
			entidadeItem.setProperty("descricao", bico.getDescricao());
			entidadeItem.setProperty("detalhes", bico.getDetalhes());
			entidadeItem.setProperty("disponivel", bico.getDisponivel());
			entidadeItem.setProperty("doador", bico.getDoador().getEmail());
			
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(entidadeItem);
			
			return true;
		}
		
		return false;
	}
	
	public boolean atualizar(Bico bico) {
		
		Entity itemDB = this.getItem(bico.getDescricao());
		
		if (itemDB != null) {
			
			itemDB.setProperty("descricao", bico.getDescricao());
			itemDB.setProperty("detalhes", bico.getDetalhes());
			itemDB.setProperty("disponivel", bico.getDisponivel());
			itemDB.setProperty("doador", bico.getDoador().getEmail());
			
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(itemDB);
			
			return true;
		}
		
		return false;
	}
	
	public Entity getItem(String descricao) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query query = new Query("Bico");
		Filter filtro = new FilterPredicate("descricao", FilterOperator.EQUAL, descricao);
		query.setFilter(filtro);
		
		PreparedQuery pq = datastore.prepare(query);
		
		Entity entidade = pq.asSingleEntity();
		
		if (entidade != null) {
			return entidade;	
		}
		
		return null;
	}
	
	public boolean existeItemCadastrado(String descricao) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query query = new Query("Bico");
		Filter filtro = new FilterPredicate("descricao", FilterOperator.EQUAL, descricao);
		query.setFilter(filtro);
		
		PreparedQuery pq = datastore.prepare(query);
		if (pq.asSingleEntity() == null) {
			return false;
		}
		
		return true;
	}
	
}
