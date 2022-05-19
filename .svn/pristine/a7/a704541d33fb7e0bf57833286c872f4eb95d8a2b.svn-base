package model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ConnectionDataStrategy implements XMLStrategy {
	
	public static String filepath = "xml/connection_data.xml";
	
	public ConnectionDataStrategy() {

	}
	
	@Override
	public void execute() {

		DBConnection dbConn = DBConnection.getInstance();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document;
			document = builder.parse(new File(filepath));
			String address = document.getElementsByTagName("address").item(0).getTextContent();
			String port = document.getElementsByTagName("port").item(0).getTextContent();
			String database = document.getElementsByTagName("database").item(0).getTextContent();
			String schema = document.getElementsByTagName("schema").item(0).getTextContent();

			dbConn.dbURL = String.format("jdbc:sqlserver://%s:%s;databaseName=%s", address, port, database);;
			dbConn.username = document.getElementsByTagName("username").item(0).getTextContent();
			dbConn.password = document.getElementsByTagName("password").item(0).getTextContent();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void changeFilePath(String filepath) //Metoda za izmjenu file-a iz glavnog menija aplikacije
	{
		this.filepath = filepath;
	}

}
