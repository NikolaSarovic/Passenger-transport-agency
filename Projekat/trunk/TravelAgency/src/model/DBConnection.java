/***********************************************************************
 * Module:  DBConnection.java
 * Author:  Nikola
 * Purpose: Defines the Class DBConnection
 ***********************************************************************/

package model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class DBConnection {

   private static DBConnection instance = null;
   private static Connection connection = null;
   public static String dbURL;
   public static String username;
   public static String password;
   
   
   public static DBConnection getInstance() {
	   
	   if(instance == null)
		   instance = new DBConnection();
	   
	   return instance;
   }
   
   public static Connection getConnection(){    
	   try {
		if(connection == null)
		{
			XMLModel xmlModel = new XMLModel(new ConnectionDataStrategy());
			xmlModel.executeStrategy();
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Konekcija uspješna");
		}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problem s konekcijom na bazu. " + e.getMessage(), "Agencija za prevoz putnika",
					JOptionPane.ERROR_MESSAGE);
		}
	   
	   return connection;
   }
   
//   public static void getConnectionData() throws SAXException, IOException
//   {
//	   String filepath = "xml/connection_data.xml";
//	   
//	   
//	try {
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		Document document = builder.parse(new File(filepath));
//		String address = document.getElementsByTagName("address").item(0).getTextContent();
//		String port = document.getElementsByTagName("port").item(0).getTextContent();
//		String database = document.getElementsByTagName("database").item(0).getTextContent();
//		String schema = document.getElementsByTagName("schema").item(0).getTextContent();
//
//		dbURL= String.format("jdbc:sqlserver://%s:%s;databaseName=%s", address, port, database);;
//		username = document.getElementsByTagName("username").item(0).getTextContent();
//		password = document.getElementsByTagName("password").item(0).getTextContent();
//	} catch (ParserConfigurationException e) {
//		e.printStackTrace();
//	}
//	   
//
//   }

}