package com.ediParser;

/*
 *  Copyright 2004 by BerryWorks
 *  All rights reserved.
 *
 */


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import com.berryworks.edireader.EDIReader;

public class EDItoXML {
	InputSource inputSource;
	OutputStream generatedOutput;
	ContentHandler handler;
	EDIReader parser;
	String inputFileName = null;
	String outputFileName = null;


	/**
	 *Constructor for the EDItoXML object
	 *
	 * @param  input   file containing EDI-structured data
	 * @param  output  XML file
	 */
	public EDItoXML(String input, String output) {
		inputFileName = input;
		outputFileName = output;

		// Establish output file
		if (outputFileName != null) {
			try {
				generatedOutput = new BufferedOutputStream(
						new FileOutputStream(outputFileName));
				System.out.println("Output file " + outputFileName + " opened");
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		} else {
			generatedOutput = System.out;
		}

		// Establish inputSource, a SAX InputSource
		if (inputFileName != null) {
			try {
				inputSource = new InputSource(
						new FileReader(inputFileName));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		} else {
			inputSource = new InputSource(
					new InputStreamReader(System.in));
		}
	}


	/**
	 *  Main processing method for the EDItoXML object
	 */
	public void run() {

		try {
			// Establish an XMLReader which is actually an EDIReader.
			System.setProperty("javax.xml.parsers.SAXParserFactory","com.berryworks.edireader.EDIParserFactory");
			SAXParserFactory sFactory = SAXParserFactory.newInstance();
			SAXParser sParser = sFactory.newSAXParser();
			XMLReader ediReader = sParser.getXMLReader();

			// Establish the SAXSource
			SAXSource source = new SAXSource(ediReader, inputSource);

			// Establish an XSL Transformer to generate the XML output.
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			
			// The StreamResult to capture the generated XML output.
			StreamResult result = new StreamResult(generatedOutput);
			
			// Call the XSL Transformer with no stylesheet to generate
			// XML output from the parsed input.
			transformer.transform(source, result);
			System.out.print("\nTransformation complete\n");
		} catch (SAXException e) {
			System.out.println("\nUnable to create EDIReader: " + e);
		} catch (ParserConfigurationException e) {
			System.out.println("\nUnable to create EDIReader: " + e);
		} catch (TransformerConfigurationException e) {
			System.out.println("\nUnable to create Transformer: " + e);
		} catch (TransformerException e) {
			System.out.println("\nFailure to transform: " + e);
		}
	}


	/**
	 *  Main for EDItoXML.
	 *
	 * @param  args  command line arguments
	 */
	public static void main(String args[]) {
		/*String outputFileName = null;
		String inputFileName = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-o")) {
				// -o filename
				if ((++i) >= args.length) {
					badArgs();
				}
				outputFileName = args[i];
			} else {
				inputFileName = args[i];
			}
		}*/
		
		String outputFileName = "C://Users//anuragk//Desktop//GroupEnrollemt//834.xml";
		String inputFileName = "C://Users//anuragk//Desktop//GroupEnrollemt//834.edi";

		EDItoXML theObject = new EDItoXML(inputFileName, outputFileName);
		theObject.run();
	}


	/**
	 *  Print summary of command line arguments expected.
	 */
	private static void badArgs() {
		System.out.println(
				"Usage: EDItoXML [-o outputfile] [inputfile]");
		System.exit(1);
	}

}
