package com.vivek.xml;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLUtility {
	
	
	public static String marshallAsXML(final Object object) throws JAXBException  {
		
		System.out.println("GenericMarshaller > marshallAsXML : object");
		
		final JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
		final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		final StringWriter stringWriter = new StringWriter();
		jaxbMarshaller.marshal(object, stringWriter);
		final String xml = stringWriter.toString();
		
		//System.out.printf("Generated XML...",xml);
		
		return xml;
	}

	public static Object unMarshallAsObject(final String xml, final Class objClass) throws JAXBException {
		
		System.out.println("GenericMarshaller > unMarshallAsObject > xml");
		
		Object obj = null;
		JAXBContext jc = JAXBContext.newInstance(objClass);
        Reader reader = new StringReader(xml);
        XMLInputFactory factory = XMLInputFactory.newInstance(); // Or newFactory()
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        try {
        	System.out.println("GenericMarshaller > 1");
        	
			XMLStreamReader xmlReader = factory.createXMLStreamReader(reader);
			System.out.println("GenericMarshaller > 2");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			System.out.println("GenericMarshaller > 3");
			obj = unmarshaller.unmarshal(xmlReader);
			System.out.println("GenericMarshaller > unMarshallAsObject > success");
		} catch (XMLStreamException e) {
			System.out.println(e);
			throw new JAXBException(e.getMessage());
		} catch(UnmarshalException e) {
			System.out.println(e);
			throw new JAXBException(e.getMessage());
		}
        
        return obj;
	}

}
