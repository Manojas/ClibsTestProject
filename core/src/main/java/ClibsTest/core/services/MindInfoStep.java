package ClibsTest.core.services;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;


@Component(service=WorkflowProcess.class,immediate=true,
property= {"process.label"+"=MindInfoStep",
		Constants.SERVICE_DESCRIPTION + "=This step takes Mind info",
		Constants.SERVICE_VENDOR + "=Mindtree"
		})
public class MindInfoStep implements WorkflowProcess {

	
	private static final Logger Log=LoggerFactory.getLogger(MindInfoStep.class); 
	@Override
	public void execute(WorkItem workItem, WorkflowSession workFlowSession, MetaDataMap metaData) throws WorkflowException {
		// TODO Auto-generated method stub
		
		try {
			String mindName=metaData.get("MIND_NAME", "String");
			String mindId=metaData.get("MIND_ID", "String");
			Log.info("Mindtree mind name");
			Log.info("Mind name "+mindName);
			
			Log.info("Mind Id "+mindId);
			
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
