package ClibsTest.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.osgi.service.component.propertytypes.ServiceDescription;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = ServiceResourceInterface.class, immediate = true)
//@ServiceDescription("Description of subservice")
public class ServiceResourceImpl implements ServiceResourceInterface {

	@Reference
	ResourceResolverFactory resourceResolverFactory;
	//ResourceResolverFactory resolverFactory;

	ResourceResolver resourceResolver;

	
	private static final Logger logger = LoggerFactory.getLogger(ServiceResourceImpl.class);

	@Override
	public Map<String, Object> getPageInformation() {
		// TODO Auto-generated method stub
		Map<String, Object> pageInformation = null;

		pageInformation = new HashMap<String, Object>();
		Resource resource = resourceResolver.getResource("/content/ClibsTest");

		pageInformation.put("title", resource.getName());
		pageInformation.put("path", resource.getPath());
		pageInformation.put("childreninformation", resource.hasChildren());

		if (resource.hasChildren()) {
			Iterator<Resource> childrenResources = resource.listChildren();

			List<String> childrenPageNames = new ArrayList<String>();
			while (childrenResources.hasNext()) {
				Resource childrenResource = childrenResources.next();

				childrenPageNames.add(childrenResource.getName());

			}
			pageInformation.put("childreninformation", childrenPageNames);
		}

		return pageInformation;
	}

	@Activate  //It notifies to the component that it was loaded and ready for service.
	@Modified  //can update your local cache value and then you won't require a restart when the data changes.
	public void activate() throws LoginException {

		final String subService = "firstsubservice";
		resourceResolver = getResolver(resourceResolverFactory, subService);

		logger.info("Logger information shows :Activated");

	}

	public ResourceResolver getResolver(ResourceResolverFactory resourceResolverFactory, String subService)
			throws LoginException {
		ResourceResolver resourceResolver = null;

		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put(ResourceResolverFactory.SUBSERVICE, subService);

		resourceResolver = resourceResolverFactory.getServiceResourceResolver(payload);

		return resourceResolver;

	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		String path = "";
		Resource res2 = resourceResolver.getResource("/content/ClibsTest");

		path = res2.getPath();
		return path;
	}

}

