package utilities;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;

public class TokenUtility {

    // Replace with your API URL and required parameters
    private static final String API_URL = "https://api.testdataservices.com.au/v0001F_GetGoogleAuthCode?Email=shridhara.ramaswamy@yokogawa.com&SecretKey=QEHCNXXUA7Y76BDPEZ4PBESBE5FQ3CEO&SubscriptionKey=bksLG5nuZEeyrQr9AttIw474WbyNrsRP";

    // Disable SSL verification (for development/test purposes only)
    public static void disableSSLVerification() {
        try {
            TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null; // Can be customized to trust specific certs
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };

            // Set up SSLContext to use the custom TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // Set default HostnameVerifier (this disables host verification)
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get OTP from the API
    public static String getOTPFromAPI() {
        disableSSLVerification();  // Disable SSL verification
        try {
            // Create a URL object
            URL url = new URL(API_URL);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("GET request failed. Response Code: " + responseCode);
                return null;
            }

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Assuming the API returns a JSON response, extract the OTP from the response
            String jsonResponse = response.toString();

            // Assuming the response is something like {"ThisToken": "123456", ...}
            // You should use a JSON library like Jackson or Gson to parse the response.
            // For simplicity, assuming the token is in the "ThisToken" field:

            String otp = extractOTPFromResponse(jsonResponse);
            return otp;

        } catch (Exception e) {
            System.err.println("Failed to get OTP. Check the logs for details.");
            e.printStackTrace();
            return null;
        }
    }

    // Method to extract OTP from JSON response
    private static String extractOTPFromResponse(String response) {
        // Extract the OTP using a simple substring method (this can be replaced with a JSON parser)
        String otp = null;
        if (response.contains("\"ThisToken\":")) {
            int start = response.indexOf("\"ThisToken\":\"") + "\"ThisToken\":\"".length();
            int end = response.indexOf("\"", start);
            otp = response.substring(start, end);
        }
        return otp;
    }

    // Main method to test OTP retrieval
    
}
