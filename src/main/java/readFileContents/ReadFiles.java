package readFileContents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadFiles {
	
	private String filePath, fileName;
	private File file;
	private PDDocument document;
	private static DocumentBuilderFactory dbf;
	private static final List<String> list = new ArrayList<>();
	
	public ReadFiles(String filePath, String fileName) {
		this.filePath = filePath;
		this.fileName = fileName;
	}
	
	public String readPDFText() throws IOException {
		//Loading an existing document
		file = new File(filePath+fileName+".pdf");
		document = PDDocument.load(file);
		//Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		//Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		System.out.println(text);
		//Closing the document
		document.close();
		return text;
	}
	
	private void readImages() {
		
	}
	
	public List<String[]> readCSV() throws FileNotFoundException, IOException, CsvException {
		String filename = filePath+fileName+".csv";
		List<String[]> r;
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }
		return r;
	}
	
	public List<String> readXMLFile(String tagName, String[] xmlTagNames) throws ParserConfigurationException, SAXException, IOException {
		
		file = new File(filePath+fileName+".xml");
		dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
		NodeList nodeList = doc.getElementsByTagName(tagName);
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);  
			System.out.println("\nNode Name :" + node.getNodeName());  
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) node;
				list.clear();
				
				for (String tagNames:xmlTagNames) {
					String textContent = eElement.getElementsByTagName(tagNames).item(0).getTextContent();
					System.out.println(textContent);
					list.add(textContent);
				}
			}
		}
		return list;
	}
}