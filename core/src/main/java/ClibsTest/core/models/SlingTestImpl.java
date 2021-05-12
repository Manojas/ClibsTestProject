package ClibsTest.core.models;



import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables=Resource.class,
adapters=SlingTestInterface.class,
defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class SlingTestImpl implements SlingTestInterface{

	@Inject
	List<String> names;
	//i have changed something.
	@Inject
	String pathBrowser;
	
	@Inject
	@Default(values="true")
	Boolean isIndian;
	//this is boolean
	@Inject
	String gender;
	
	@Inject
	String fileReference;
	
	@Override
	public List<String> getNames() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getPathBrowser() {
		// TODO Auto-generated method stub
		return pathBrowser;
	}

	@Override
	public Boolean getIsIndian() {
		// TODO Auto-generated method stub
		return isIndian;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override	
	public String getFileReference() {
		// TODO Auto-generated method stub
		return fileReference;
	}

}
