package ClibsTest.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import ClibsTest.core.services.CSVFileServiceInterface;

@Model(adaptables=SlingHttpServletRequest.class, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class CSVFileImportImpl implements CSVFileImpotInterface{

	@OSGiService
	CSVFileServiceInterface csvInt;
	
	@Override
	public String getCSVAsset() {
		// TODO Auto-generated method stub
		return csvInt.getCSVAsset();
	}

}
