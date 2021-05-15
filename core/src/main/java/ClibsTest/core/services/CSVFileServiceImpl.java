package ClibsTest.core.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;

@Component(service = CSVFileServiceInterface.class, immediate = true)
public class CSVFileServiceImpl implements CSVFileServiceInterface {

	@Reference
	ResourceResolverFactory resourceResolverFactory;

	ResourceResolver resourceResolver;

	String csvFile = null;

	private static final Logger log = Logger.getLogger(CSVFileServiceImpl.class);

	public static final String subService = "firstsubservice";

	public static final String csvPath = "/content/dam/ClibsTest/csvfile/Sample-Spreadsheet-10-rows.csv";

	@Activate
	@Modified
	public void activate() throws LoginException {
		log.info("Activating the bundle");
		Map<String, Object> resourceMap = new HashMap<String, Object>();

		resourceMap.put(ResourceResolverFactory.SUBSERVICE, subService);
		resourceResolver = resourceResolverFactory.getServiceResourceResolver(resourceMap);
		log.info(" Resolver Registered");
	}

	@Override
	public String getCSVAsset()  {
		// TODO Auto-generated method stub
        
		try {
		Resource resource = resourceResolver.getResource(csvPath);
		log.info("Getting resource");

		Asset asset = resource.adaptTo(Asset.class);

		// We can create the asset object in two ways
		//using Asset manager
		//by adapting a Asset Resource
		Rendition rendition = asset.getOriginal();
		// It returns the suitable rendition for rendering values
		InputStream input = rendition.adaptTo(InputStream.class);
		// adapting a InputStream class ,the data is in tha binary form.
		if (input != null) {
			
				csvFile = IOUtils.toString(input, StandardCharsets.UTF_8);
				// One of the ways to convert inputStream into String in java.
				return csvFile;
		} else {
			return "Null file";
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "Null file";
		
	}

}
