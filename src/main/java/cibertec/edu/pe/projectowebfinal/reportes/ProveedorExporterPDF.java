package cibertec.edu.pe.projectowebfinal.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import cibertec.edu.pe.projectowebfinal.model.Proveedor;
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

public class ProveedorExporterPDF {

	private List<Proveedor> listaProveedor;

	public ProveedorExporterPDF(List<Proveedor> listaProveedor) {
		super();
		this.listaProveedor = listaProveedor;
	}
	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("ID", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Nombre", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Dirección", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Teléfono", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("RUC", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Razon Social", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Pais", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Ciudad", fuente));
		tabla.addCell(celda);
	}
	
	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Proveedor proveedor : listaProveedor) {
			tabla.addCell(String.valueOf(proveedor.getIdprov()));
			tabla.addCell(proveedor.getNombre());
			tabla.addCell(proveedor.getDireccion());
			tabla.addCell(proveedor.getTelefono());
			tabla.addCell(proveedor.getRuc());
			tabla.addCell(proveedor.getRazonsocial());
			tabla.addCell(proveedor.getPais());
			tabla.addCell(proveedor.getCiudad());
		}
	}
	
	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de Proveedor", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(8);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 2.3f, 2.3f, 6f, 2.9f, 3.5f, 2f, 2.2f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
}
