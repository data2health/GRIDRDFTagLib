package edu.uiowa.slis.GRIDRDF.utility;

import java.io.File;
import java.io.IOException;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.Syntax;
import org.apache.jena.tdb.TDBFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;

import edu.uiowa.slis.GRIDRDF.TagLibSupport;

public class Indexer {
    protected static Logger logger = Logger.getLogger(Indexer.class);
    static TagLibSupport theTag = new TagLibSupport();
    
    static boolean useSPARQL = false;
    static Dataset dataset = null;
    static String tripleStore = null;
    static String endpoint = null;

    static String dataPath = "/usr/local/RAID/";
    static String lucenePath = "/usr/local/RAID/lucene/grid/address";
    static String prefix = 
	    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	    + " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
	    + " PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
	    + " PREFIX mads: <http://www.loc.gov/mads/rdf/v1#> "
	    + " PREFIX skos: <http://www.w3.org/2004/02/skos/core#> "
	    + " PREFIX bib: <http://bib.ld4l.org/ontology/> ";


    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws CorruptIndexException, LockObtainFailedException, IOException {
	PropertyConfigurator.configure("log4j.info");

	tripleStore = dataPath + args[0];
	endpoint = "http://services.ld4l.org/fuseki/" + args[0] + "/sparql";

	if (args.length > 0 && args[1].equals("address"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("archive"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("company"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("education"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("facility"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("government"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("healthcare"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("nonprofit"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];
	if (args.length > 0 && args[1].equals("other"))
	    lucenePath = "/usr/local/RAID/lucene/" + "grid" + "/" + args[1];

	IndexWriter theWriter = new IndexWriter(FSDirectory.open(new File(lucenePath)), new StandardAnalyzer(org.apache.lucene.util.Version.LUCENE_30), true, IndexWriter.MaxFieldLength.UNLIMITED);

	if (args.length > 0 && args[1].equals("address"))
	    indexAddresses(theWriter);
	if (args.length > 0 && args[1].equals("archive"))
	    indexArchives(theWriter);
	if (args.length > 0 && args[1].equals("company"))
	    indexCompanies(theWriter);
	if (args.length > 0 && args[1].equals("education"))
	    indexEducations(theWriter);
	if (args.length > 0 && args[1].equals("facility"))
	    indexFacilities(theWriter);
	if (args.length > 0 && args[1].equals("government"))
	    indexGovernments(theWriter);
	if (args.length > 0 && args[1].equals("healthcare"))
	    indexHealthcares(theWriter);
	if (args.length > 0 && args[1].equals("nonprofit"))
	    indexNonprofits(theWriter);
	if (args.length > 0 && args[1].equals("other"))
	    indexOthers(theWriter);

	logger.info("optimizing index...");
	theWriter.optimize();
	theWriter.close();
    }
    
    static void indexAddresses(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?address ?title WHERE { "
		+ "?address rdf:type <http://www.grid.ac/ontology/Address> . "
		+ "?address <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String address = sol.get("?address").toString();
	    String title = sol.get("?title").toString();
	    logger.debug("address: " + address + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", address, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }
    
    static void indexArchives(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?archive ?title WHERE { "
		+ "?archive rdf:type <http://www.grid.ac/ontology/Archive> . "
		+ "?archive <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String archive = sol.get("?archive").toString();
	    String title = sol.get("?title").toString();
	    logger.info("archive: " + archive + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", archive, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }
    
    static void indexCompanies(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?company ?title WHERE { "
		+ "?company rdf:type <http://www.grid.ac/ontology/Company> . "
		+ "?company <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String company = sol.get("?company").toString();
	    String title = sol.get("?title").toString();
	    logger.info("company: " + company + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", company, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }
    
    static void indexEducations(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?education ?title WHERE { "
		+ "?education rdf:type <http://www.grid.ac/ontology/Education> . "
		+ "?education <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String education = sol.get("?education").toString();
	    String title = sol.get("?title").toString();
	    logger.info("education: " + education + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", education, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }
    
    static void indexFacilities(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?facility ?title WHERE { "
		+ "?facility rdf:type <http://www.grid.ac/ontology/Facility> . "
		+ "?facility <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String facility = sol.get("?facility").toString();
	    String title = sol.get("?title").toString();
	    logger.info("facility: " + facility + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", facility, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }
    
    static void indexGovernments(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?government ?title WHERE { "
		+ "?government rdf:type <http://www.grid.ac/ontology/Government> . "
		+ "?government <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String government = sol.get("?government").toString();
	    String title = sol.get("?title").asLiteral().getString();
	    logger.info("government" + government + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", government, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }

    static void indexHealthcares(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?healthcare ?title WHERE { "
		+ "?healthcare rdf:type <http://www.grid.ac/ontology/Healthcare> . "
		+ "?healthcare <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String healthcare = sol.get("?healthcare").toString();
	    String title = sol.get("?title").asLiteral().getString();
	    logger.info("healthcare: " + healthcare + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", healthcare, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }

    static void indexNonprofits(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?nonprofit ?title WHERE { "
		+ "?nonprofit rdf:type <http://www.grid.ac/ontology/Nonprofit> . "
		+ "?nonprofit <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String nonprofit = sol.get("?nonprofit").toString();
	    String title = sol.get("?title").asLiteral().getString();
	    logger.info("nonprofit: " + nonprofit + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", nonprofit, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }

    static void indexOthers(IndexWriter theWriter) throws CorruptIndexException, IOException {
	int count = 0;
	String query =
		"SELECT DISTINCT ?other ?title WHERE { "
		+ "?other rdf:type <http://www.grid.ac/ontology/Other> . "
		+ "?other <http://www.w3.org/2000/01/rdf-schema#label> ?title . "
    		+ "}";
	ResultSet rs = getResultSet(prefix + query);
	while (rs.hasNext()) {
	    QuerySolution sol = rs.nextSolution();
	    String other = sol.get("?other").toString();
	    String title = sol.get("?title").asLiteral().getString();
	    logger.info("other: " + other + "\ttitle: " + title);
	    
	    Document theDocument = new Document();
	    theDocument.add(new Field("uri", other, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("title", title, Field.Store.YES, Field.Index.NOT_ANALYZED));
	    theDocument.add(new Field("content", title, Field.Store.NO, Field.Index.ANALYZED));
	    theWriter.addDocument(theDocument);
	    count++;
	    if (count % 10000 == 0)
		logger.info("count: " + count);
	}
	logger.info("total titles: " + count);
    }

    static public ResultSet getResultSet(String queryString) {
	if (useSPARQL) {
	    Query theClassQuery = QueryFactory.create(queryString, Syntax.syntaxARQ);
	    QueryExecution theClassExecution = QueryExecutionFactory.sparqlService(endpoint, theClassQuery);
	    return theClassExecution.execSelect();
	} else {
	    dataset = TDBFactory.createDataset(tripleStore);
	    Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
	    QueryExecution qexec = QueryExecutionFactory.create(query, dataset);
	    return qexec.execSelect();
	}
    }
}
