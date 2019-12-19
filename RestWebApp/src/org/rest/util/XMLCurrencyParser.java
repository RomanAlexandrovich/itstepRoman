package org.rest.util;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.rest.ws.model.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLCurrencyParser 

	{
		 
		  public static final String CURRENCY_URL = AppSettings.getInstance().getProperty("URL_NBRB");
		  public static final String NAME = AppSettings.getInstance().getProperty("NAME");
		  public static final String NUMCODE = AppSettings.getInstance().getProperty("NUMCODE");
		  public static final String SCALE = AppSettings.getInstance().getProperty("SCALE");
		  public static final String CHARCODE = AppSettings.getInstance().getProperty("CHARCODE");
		  public static final String RATE = AppSettings.getInstance().getProperty("RATE");
//		  
		  
		  
		  
		  
//		  private static String CURRENCY_URL = "http://www.nbrb.by/Services/XmlExRates.aspx";
		  private static List<Currency> currencies = new ArrayList<Currency>();
		  private static Document doc=null;
		  public XMLCurrencyParser() {}
		  static {
			  while (doc==null) {
				  try {
				  Thread.sleep(1000);
				  }catch(InterruptedException e){
					  e.printStackTrace();
				  }
				  refresh(); //получение документа
			  }
			   
		  }
		  /*
		   * Load по требованию
		   */
		  public static void refresh() {
			  doc = loadDocument(CURRENCY_URL);
			  if(doc != null) {
		          System.out.println("The Document is loaded!");
		      }
			  
		  }
		  private static Document loadDocument(String url) {
		    Document doc = null;
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    factory.setNamespaceAware(true);
		    try {
		      doc = factory.newDocumentBuilder().parse(new java.net.URL(url).openStream());
		    } catch (java.net.ConnectException e) {
		      System.err.print(" Oops! Something goes wrong! This is Belarus, baby! \nConnection timed out. ");
		      System.err.print(CURRENCY_URL + " is not responsible. Please, try again later");
		    } catch (MalformedURLException e) {
		      e.printStackTrace();
		    } catch (SAXException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (ParserConfigurationException e) {
		      e.printStackTrace();
		    }
		    return doc;
		  }
		 public static String getCurrency(String currencyCode)
		  {
		    boolean isCurrencyCodeNext = false;
		    Document doc = loadDocument(CURRENCY_URL);
		    
		    if (doc != null) {
		      NodeList nodes = doc.getFirstChild().getChildNodes();//загрузка п структуре документа XML 1Chaild-listCurrecn
		      

		      for (int i = 0; i < nodes.getLength(); i++) {
		        Node parent = nodes.item(i);
		        
		        if (parent.getNodeType() == 1) {
		          NodeList childs = parent.getChildNodes();
		          
		          for (int ii = 0; ii < childs.getLength(); ii++) {
		            Node child = childs.item(ii);
		            if (child.hasChildNodes()) {
		              if ((child.getNodeName().trim().equalsIgnoreCase(RATE)) && (isCurrencyCodeNext)) {
		                isCurrencyCodeNext = false;
		                return child.getFirstChild().getTextContent();
		              }
		              
		              if (child.getFirstChild().getTextContent().trim().equalsIgnoreCase(currencyCode)) {
		                isCurrencyCodeNext = true;
		              }
		            }
		          }
		        }
		      }
		    }
		    return "0.0";
		  }
		 public static List<Currency> getCurrencies() {
			 NodeList nodes = doc.getFirstChild().getChildNodes();//загрузка п структуре документа XML 1Chaild-listCurrecn
			 Currency cur = new Currency();
			 for (int i = 0; i < nodes.getLength(); i++) {
			        Node parent = nodes.item(i);
			        if (parent.getNodeType() == Node.ELEMENT_NODE) {
			          NodeList childs = parent.getChildNodes();
			          
			          for (int j = 0; j < childs.getLength(); j++) {
			        	  Node child = childs.item(j);
			        	  String Key=child.getNodeName().trim();
			        	  
			        	  if(child.hasChildNodes()) {

			        		  if (child.getNodeName().trim().equalsIgnoreCase(NUMCODE)){ 
			        		  cur.setNumCode(child.getFirstChild().getTextContent());
			        		}
			        		  if (child.getNodeName().trim().equalsIgnoreCase(CHARCODE)){ 
			        		  cur.setCharCode(child.getFirstChild().getTextContent());
			        		 }
			        		  if (child.getNodeName().trim().equalsIgnoreCase(SCALE)){ 
			        		  cur.setScale(Integer.parseInt(child.getFirstChild().getTextContent()));
			        		  }
			        		  if (child.getNodeName().trim().equalsIgnoreCase(NAME)){ 
			        		  cur.setName(child.getFirstChild().getTextContent());
			        		  }
			        		  if (child.getNodeName().trim().equalsIgnoreCase(RATE)){ 
			        			  cur.setRate(Double.parseDouble(child.getFirstChild().getTextContent()));
			        		  }
			        		  }			        	  
			        	  }
			          currencies.add(cur);
			          }
			        }
			 return currencies;
			 }
			 
		 
		 public static Currency getCurrencyObject(String currencyCode)
		  {
			 Currency cur = new Currency();
			 boolean isCurrencyCodeNext = false;
		    
		    if (doc != null) {
		      NodeList nodes = doc.getFirstChild().getChildNodes();//загрузка п структуре документа XML 1Chaild-listCurrecn

		      for (int i = 0; i < nodes.getLength(); i++) {
		        Node parent = nodes.item(i);
		        
		        if (parent.getNodeType() == 1) {
		          NodeList childs = parent.getChildNodes();
		          
		          for (int ii = 0; ii < childs.getLength(); ii++) {
		            Node child = childs.item(ii);
		            if (child.hasChildNodes()) {
		              if ((child.getNodeName().trim().equalsIgnoreCase("Rate")) && (isCurrencyCodeNext)) {
		                isCurrencyCodeNext = false;
		                return cur;
		              }
		              
		              if (child.getFirstChild().getTextContent().trim().equalsIgnoreCase(currencyCode)) {
		                isCurrencyCodeNext = true;
		              }
		            }
		          }
		        }
		      }
		    }
		    return cur;
		  }
public static void main(String[] args) {
System.out.println(getCurrency("840"));
getCurrencies();
}
	}


