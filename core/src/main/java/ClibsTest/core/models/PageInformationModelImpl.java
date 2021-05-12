package ClibsTest.core.models;

import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import ClibsTest.core.services.ServiceResourceInterface;



@Model(adaptables = SlingHttpServletRequest.class, adapters = PageInformationModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class PageInformationModelImpl implements PageInformationModel {

	@OSGiService
	ServiceResourceInterface service;

	@Override
	public Map<String, Object> getPageInformation() {
		// TODO Auto-generated method stub
		return service.getPageInformation();
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return service.getPath();
	}

}

