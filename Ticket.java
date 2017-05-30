package model;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import view.Observer;
import view.Subject;

public class Ticket implements Subject{
	private String id;
	private String match;
    private String data;
    private String category;
    private String quantity;
    private String price;
    
    private List<Observer> listOfObservers=new ArrayList<Observer>();
    private boolean available;
    
    public Ticket(String id,String match,String data,String category,String quantity,String price)
    {
    	this.id=id;
    	this.match=match;
    	this.data=data;
    	this.category=category;
    	this.quantity=quantity;
    	this.price=price;
    }
    
    public Ticket()
    {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmatch() {
		return match;
	}

	public void setmatch(String match) {
		this.match = match;
	}

	public String getdata() {
		return data;
	}

	public void setdata(String data) {
		this.data = data;
	}

	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public void read()
	{
		try{
			
			File fXmlFile = new File("ticket.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	
			NodeList nList = doc.getElementsByTagName("ticket");

	
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					System.out.println("Ticket id : " + eElement.getAttribute("id"));
					System.out.println("match : " + eElement.getElementsByTagName("match").item(0).getTextContent());
					System.out.println("data : " + eElement.getElementsByTagName("data").item(0).getTextContent());
					System.out.println("category : " + eElement.getElementsByTagName("category").item(0).getTextContent());
					System.out.println("Quantity : " + eElement.getElementsByTagName("quantity").item(0).getTextContent());
					System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
				}
			}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }
	public void insertTicket()
	{
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("ticket.xml");
		       
		       //root 
		       Element root=document.getDocumentElement();
		       
    		   Element newElement = document.createElement("ticket");
    		   root.appendChild(newElement);
    		   
    		   newElement.setAttribute("id",this.getId());
    		   
    		   Element match = document.createElement("match");
    		   match.setTextContent(this.getmatch());
    		   
    		   Element data = document.createElement("data");
    		   data.setTextContent(this.getdata());
    		   
    		   Element category = document.createElement("category");
    		   category.setTextContent(this.getcategory());
    		   
    		   Element quantity = document.createElement("quantity");
    		   quantity.setTextContent(this.getQuantity());
    		   
    		   Element price= document.createElement("price");
    		   price.setTextContent(this.getPrice());
		    		   
    		   newElement.appendChild(match);	
    		   newElement.appendChild(data);	
    		   newElement.appendChild(category);
    		   newElement.appendChild(quantity);
    		   newElement.appendChild(price);
		  	       
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("ticket.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
	public static void deleteTicket(String match) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("ticket.xml");
		       NodeList nList = document.getElementsByTagName("ticket");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("match").item(0).getTextContent().equals(match))
						{
							eElement.getParentNode().removeChild(eElement);
						}
					}
		       }   
		  
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("ticket.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
}
	public static void updateTicket(String match,String quantity,String price)
	{
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("ticket.xml");
		       
		       
		       NodeList nList = document.getElementsByTagName("ticket");
		
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("match").item(0).getTextContent().equals(match))
						{
							 eElement.getElementsByTagName("quantity").item(0).setTextContent((quantity));
							 eElement.getElementsByTagName("price").item(0).setTextContent((price));
						}
					}
		       }
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("ticket.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}
	
	public static boolean isThere(String match) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("ticket.xml");
		       NodeList nList = document.getElementsByTagName("ticket");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("match").item(0).getTextContent().equals(match))
						{
							return true;
						}
					}
		       }   
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		return false;
}
	public static void sellTicket(String match,int nr )
	{
		try
		{
			   Ticket b=Ticket.searchByMatch(match);
			   if(Integer.parseInt(b.getQuantity())>=nr)
				   {b.setQuantity(Integer.toString((Integer.parseInt(b.getQuantity())-nr)));
				   	Ticket.updateTicket(b.getmatch(),b.getQuantity() , b.getPrice());
				   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			       DocumentBuilder db = dbf.newDocumentBuilder();
			       Document document = db.parse("selling.xml");
			       
			       //root 
			       Element root=document.getDocumentElement();
			       
	    		   Element newElement = document.createElement("ticket");
	    		   root.appendChild(newElement);
	    		   
	    		   newElement.setAttribute("id",b.getId()+nr);
	    		   
	    		   Element match1 = document.createElement("match");
	    		   match1.setTextContent(b.getmatch());
	    		   
	    		   Element data = document.createElement("data");
	    		   data.setTextContent(b.getdata());
	    		   
	    		   Element category = document.createElement("category");
	    		   category.setTextContent(b.getcategory());
	    		   
	    		   Element quantity = document.createElement("copy_numbers");
	    		   quantity.setTextContent(Integer.toString(nr));
	    		   
	    		   Element price= document.createElement("price");
	    		   price.setTextContent(b.getPrice());
	    		   
	    		   Element total_price= document.createElement("total_price");
	    		   total_price.setTextContent(Integer.toString(Integer.parseInt(b.getPrice())*nr));
			    		   
	    		   newElement.appendChild(match1);	
	    		   newElement.appendChild(data);	
	    		   newElement.appendChild(category);
	    		   newElement.appendChild(quantity);
	    		   newElement.appendChild(price);
	    		   newElement.appendChild(total_price);
			  	       
			       TransformerFactory tff  = TransformerFactory.newInstance();
			       Transformer transformer = tff.newTransformer();
			       
			       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
			       
			       DOMSource xmlSource = new DOMSource(document);
			       StreamResult outputTarget = new StreamResult("selling.xml");
			       
			       transformer.transform(xmlSource, outputTarget);  
			   
				   }
			   else JOptionPane.showMessageDialog(null, "Insufficient number of Tickets");
				}
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
	   }
	
	public static String[] searchByQuantity()
	{
		try{
			String[] result=new String[100];
			int i=0;
			File fXmlFile = new File("ticket.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("ticket");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Ticket id");
	        model.addColumn("match");
	        model.addColumn("data");
	        model.addColumn("category");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	       
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("quantity").item(0).getTextContent().equals("0"))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("match").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("data").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("category").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  result[i]="The ticket "+st[1]+" written by "+st[2]+" is out of stock.";
						  i++;
						}
				}
			}
			return result;
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return null;
}
	public static void searchByCategory(String category)
	{
		try{
			
			File fXmlFile = new File("ticket.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("ticket");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ticket id");
	        model.addColumn("match");
	        model.addColumn("data");
	        model.addColumn("category");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	        JTable table = new JTable(model);
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("category").item(0).getTextContent().equals(category))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("match").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("data").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("category").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  ((DefaultTableModel) table.getModel()).addRow(new Object[]{st[0], st[1], st[2], st[3],st[4],st[5]});	
						}
				}
			}
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			 JOptionPane.showMessageDialog(null, new JScrollPane(table));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
}
	
	public static String[][] searchCsv()
	{
		try{
			String[][] result=new String[20][100];
			int i=0;
			File fXmlFile = new File("ticket.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("ticket");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ticket id");
	        model.addColumn("match");
	        model.addColumn("data");
	        model.addColumn("category");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	       
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("quantity").item(0).getTextContent().equals("0"))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("match").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("data").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("category").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  result[i][0]=st[0];
						  result[i][1]=st[1];
						  result[i][2]=st[2];
						  result[i][3]=st[3];
						  result[i][4]=st[4];
						  i++;
						}
				}
			}
			return result;
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return null;
}
	
	public static void searchByData(String data)
	{
		try{
			
			File fXmlFile = new File("ticket.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("ticket");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ticket id");
	        model.addColumn("match");
	        model.addColumn("data");
	        model.addColumn("category");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	        JTable table = new JTable(model);
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("data").item(0).getTextContent().equals(data))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("match").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("data").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("category").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  ((DefaultTableModel) table.getModel()).addRow(new Object[]{st[0], st[1], st[2], st[3],st[4],st[5]});	
						}
				}
			}
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			 JOptionPane.showMessageDialog(null, new JScrollPane(table));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
}
	
	public static Ticket searchByMatch(String match)
	{
		try{
			
			File fXmlFile = new File("ticket.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("ticket");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ticket id");
	        model.addColumn("match");
	        model.addColumn("data");
	        model.addColumn("category");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	        JTable table = new JTable(model);
	        Ticket b=new Ticket();
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("match").item(0).getTextContent().equals(match))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("match").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("data").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("category").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  ((DefaultTableModel) table.getModel()).addRow(new Object[]{st[0], st[1], st[2], st[3],st[4],st[5]});
						  b=new Ticket(st[0],st[1],st[2],st[3],st[4],st[5]);
						}
				}
			}
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			 JOptionPane.showMessageDialog(null, new JScrollPane(table));
			 return b;
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return null;
}

	
	
	public List<Observer> getListOfObservers() {
		return listOfObservers;
	}

	public void setListOfObservers(List<Observer> listOfObservers) {
		this.listOfObservers = listOfObservers;
	}

	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
		if (available==true){
			notifyObservers();
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		listOfObservers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		listOfObservers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		System.out.println("Notifying all registeres users,when ticket become available");

		for (Observer observer : listOfObservers){
		observer.update(match);
		}
		
	}
	
}
