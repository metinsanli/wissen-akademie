import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;

/**
 * Uygulamanin calismasi icin "pdfbox-app-1.8.4.jar" isimli PDF kutuphanesine ihtiyac vardir. <br>
 * http://pdfbox.apache.org/ adresinden temin edilebilir.
 */

public class PDFTest {

	public static void main(String[] args) {
		PDDocument pd;
		BufferedWriter wr;
		try {
			// The PDF file from where you would like to extract
			File input = new File("./src/Invoice.pdf");
			// The text file where you are going to store the extracted data
			File output = new File("./src/SampleText.txt");
			pd = PDDocument.load(input);
			System.out.println(pd.getNumberOfPages());
			System.out.println(pd.isEncrypted());
			pd.save("CopyOfInvoice.pdf"); // Creates a copy called
			// "CopyOfInvoice.pdf"
			PDFTextStripper stripper = new PDFTextStripper();
			wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
			stripper.writeText(pd, wr);
			if (pd != null) {
				pd.close();
			}
			// I use close() to flush the stream.
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}