package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.framework.implementacao.crud.SimpleJdbcClassImplement;

@Component
@Transactional
public interface InterfaceCrud<T>  extends Serializable {

	//Salva os dados
	void save(T obj)  throws Exception;
	
	void persist(T obj) throws Exception;
	
	//Salva ou atualiza
	void saveOrUpdate(T obj) throws Exception;
	
	//Realiza o update/atualização dos dados
	void update(T obj) throws Exception;
	
	//Realiza o delete de dados
	void delete(T obj) throws Exception;
	
	//Salva ou atualiza e retorna  o objeto em estado persistente 
	T merge(T obj) throws Exception;
	
	//Carrega a lista de dados de determinada classe
	List<T> findList(Class<T> objs) throws Exception;
	
	Object findById(Class<T> entidade, Long id) throws Exception;
	
	T findPorId(Class<T> entidade, Long id) throws Exception;
	
	List<T> findListByQueryDinamica(String s) throws Exception;
	
	//Executar update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	//Executar update com SQL puro
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	//Limpa a sessão do hibernate
	void clearSession() throws Exception;
	
	//Retira um objeto da sessão do hibernate
	void evict (Object objs) throws Exception;
	
	//Método que retorna a sessão do hibernate
	Session getSession() throws Exception;
	
	//Executa uma SQLDinamica e um conj. de resultados de dados
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	//JDBC do Spring
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	//Para saber quantos registros têm em determinada tabela
	Long totalRegistro(String table) throws Exception;
	
	Query<?> obterQuery(String query) throws Exception;
	
	//Usado para fazer um carregamento por demanda - Carregamento dinamico com JSF e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;

	SimpleJdbcClassImplement getSimpleJdbcClassImplement();
	
	
	
}
