package E01_Streams;

/**
 * java.io.File sinifi dosya veya klasor ile ilgili islemleri yapabilen hazir methodlari barindirir.
 * 
 * getName()		: Dosya adini String olarak verir.
 * isFile()			: Dosya mi? degil mi ? Boolean turunde deger uretir.
 * isDirectory()	: Klasor mu? degil mi? Boolean turunde deger uretir.
 * isAbsolute()		: Long turunde 
 * lastModified() 	:
 * length()			:
 * getPath()		:
 * getAbsolutePath():
 * getParent()		: Bulundugu klasor
 * 
 */

import java.io.File;
import java.util.Scanner;

public class FileDemonstration {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("for exmple file :\t./src/E01_Streams/JavaAbout.txt");
		System.out.printf("\nEnter a file or folder name > ");
		analyzePath(input.nextLine());
		input.close();
	} // end main()

	public static void analyzePath(String path) {
		File name = new File(path);

		if (name.exists()) {
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", name.getName(), " exists", (name.isFile() ? "is a file" : "is not a file"),
					(name.isDirectory() ? "is a directory" : "is not a directory"), (name.isAbsolute() ? "is absolute path" : "is nor absolute path"), "Last modified: ",
					name.lastModified(), "Length: ", name.length(), "Path\t\t: ", name.getPath(), "Absolute Path\t: ", name.getAbsolutePath(), "Parent\t\t: ", name.getParent());

			if (name.isDirectory()) {
				String[] directory = name.list();
				System.out.println("\n\nDirestory contents:\n");
				for (String directoryName : directory)
					System.out.println(directoryName);
			}

		} else {
			System.out.printf("%s %s", path, "does not exists.");
		}

	} // end method analyzePath()

} // end class