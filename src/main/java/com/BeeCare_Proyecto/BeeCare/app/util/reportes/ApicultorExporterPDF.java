package com.BeeCare_Proyecto.BeeCare.app.util.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.BeeCare_Proyecto.BeeCare.app.entidad.Apicultor;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ApicultorExporterPDF {

	private List<Apicultor> listaApicultores;

	public ApicultorExporterPDF(List<Apicultor> listaApicultores) {
		super();
		this.listaApicultores = listaApicultores;

	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.YELLOW);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.BLACK);

		celda.setPhrase(new Phrase("Cédula", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Primer Nombre", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Segundo Nombre", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Primer Apellido", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Segundo Apellido", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Correo", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Celular", fuente));
		tabla.addCell(celda);

	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Apicultor apicultor : listaApicultores) {
			tabla.addCell(String.valueOf(apicultor.getCedula()));
			tabla.addCell(apicultor.getNombre1());
			tabla.addCell(apicultor.getNombre2());
			tabla.addCell(apicultor.getApellido1());
			tabla.addCell(apicultor.getApellido2());
			tabla.addCell(apicultor.getCorreo());
			tabla.addCell(apicultor.getCelular());
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLACK);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de Apicultores", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(7);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 2.3f, 2.6f, 2.6f, 6f, 3.5f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}

}
