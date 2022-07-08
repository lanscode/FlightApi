package com.koria.api.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.koria.api.reservation.models.Reservation;

@Component
@Lazy 
public class PDFGenerator {
	public void generateItinerary(Reservation reservation, String path) {
		Document doc = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));
			doc.open();
			
			doc.addAuthor("Koria");
			doc.addCreationDate();
			doc.addTitle("Flight booking info");
			
			doc.add(generateTable(reservation));
			
			doc.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	public Element generateTable(Reservation reservation) {
		PdfPTable tab = new PdfPTable(2);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Flight itinerary"));
		cell.setColspan(2);
		tab.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight details"));
		cell.setColspan(2);
		tab.addCell(cell);
		
		tab.addCell("Airlines");
		tab.addCell(reservation.getFlight().getOperatingAirlines());
		tab.addCell("Departure City");
		tab.addCell(reservation.getFlight().getDepartureCity());
		tab.addCell("Arrival City");
		tab.addCell(reservation.getFlight().getArrivalCity());
		tab.addCell("Flight Number");
		tab.addCell(reservation.getFlight().getFlightNumber());
		tab.addCell("Departure Date");
		tab.addCell(""+reservation.getFlight().getDateOfDeparture());
		tab.addCell("Departure Time");
		tab.addCell(""+reservation.getFlight().getEstimatedDepartureTime());
		cell = new PdfPCell(new Phrase("Passenger details"));
		cell.setColspan(2);
		tab.addCell(cell);
		tab.addCell("First Name");
		tab.addCell(reservation.getPassenger().getFirstName());
		tab.addCell("Last Name");
		tab.addCell(reservation.getPassenger().getLastName());
		tab.addCell("Email");
		tab.addCell(reservation.getPassenger().getEmail());
		tab.addCell("Phone");
		tab.addCell(reservation.getPassenger().getPhone());
		return tab;
	}
}
