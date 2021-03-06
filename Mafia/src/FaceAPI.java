import java.io.File;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FaceAPI
{
	 public static void main(String[] args)
	    {
	        CloseableHttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder uriBuilder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect");

	            uriBuilder.setParameter("returnFaceId", "true");
	            uriBuilder.setParameter("returnFaceLandmarks", "false");
	            uriBuilder.setParameter("returnFaceAttributes", "age");

	            URI uri = uriBuilder.build();
	            HttpPost request = new HttpPost(uri);

	            // Request headers. Replace the example key below with your valid subscription key.
	            request.setHeader("Content-Type", "application/octet-stream");
	            request.setHeader("Ocp-Apim-Subscription-Key", "1444d72afeec4039a2f2ce3339ffa605");



	            // Request body


	            File file = new File("/Users/anamikapaul/Downloads/anamika.jpg");

	            FileEntity reqEntity = new FileEntity(file, ContentType.APPLICATION_OCTET_STREAM);
	            request.setEntity(reqEntity);

	            HttpResponse response = httpclient.execute(request);
	            HttpEntity entity = response.getEntity();
	            System.out.println(response.getStatusLine());

	            if (entity != null)
	            {
	                System.out.println(EntityUtils.toString(entity));

	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	}