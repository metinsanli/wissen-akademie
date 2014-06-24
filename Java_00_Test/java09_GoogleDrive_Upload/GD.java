package java09_GoogleDrive_Upload;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class GD {

	private static String CLIENT_ID = "371067223164.apps.googleusercontent.com";
	private static String CLIENT_SECRET = "ghkQV2Xk6E0aaHToerrYizbl";

	private static String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";

	public GD(java.io.File dosya) throws IOException {
		HttpTransport httpTransport = new NetHttpTransport();
		JsonFactory jsonFactory = new JacksonFactory();

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
				.setAccessType("online").setApprovalPrompt("auto").build();

		String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
		JTextField txtField = new JTextField(20);

		System.out.println("Please open the following URL in your browser then type the authorization code:\n" + url);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();

		GoogleTokenResponse response = (flow.newTokenRequest(code)).setRedirectUri(REDIRECT_URI).execute();
		GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);

		// Create a new authorized API client
		Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).build();

		// Insert a file
		File body = new File();
		body.setTitle(dosya.getName());
		body.setDescription("A test document");
		body.setMimeType("text/plain");
		body.setOriginalFilename(dosya.getName());

		FileContent mediaContent = new FileContent("text/plain", dosya);

		File file = service.files().insert(body, mediaContent).execute();
		System.out.println("File ID: " + file.getId());
	}
}
