package System;

import javax.swing.JOptionPane;

public class Prop {

	public final static String[] command = { "java.class.path", "java.home", "java.library.path", "java.specification.name", "java.net.preferIPv4Stack",
			"java.specification.vendor", "java.vendor", "java.vendor.url", "java.specification.version", "java.version", "java.class.version", "java.compiler",
			"java.ext.dirs", "java.use.policy", "java.vm.info", "java.vm.name", "java.vm.specification.name", "java.vm.specification.vendor", "java.vm.specification.version",
			"java.vm.vendor", "java.vm.version", "os.arch", "os.name", "os.version", "file.separator", "file.encoding", "file.encoding.pkg", "path.separator",
			"line.separator", "user.timezone", "user.region", "user.language", "user.dir", "user.home", "user.name" };

	public static void main(String[] args) {
		String info = "";
		for (String tmp : command)
			info += (System.getProperty(tmp) != null ? (tmp + " : " + System.getProperty(tmp) + "\n") : "");
		JOptionPane.showMessageDialog(null, info, "System Property", 1);
	} // end main()

} // END CLASS