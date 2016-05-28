import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.parallec.core.HostsSourceType;
import io.parallec.core.ParallecResponseHandler;
import io.parallec.core.ParallelClient;
import io.parallec.core.ResponseOnSingleTask;


public enum Utils_Parallec_Manger {
	
	singleton;
	
	ParallelClient pc ;
	
	List<ResponseOnSingleTask> responseSontents;
	
	private Utils_Parallec_Manger(){
		this.pc = new ParallelClient();
		this.responseSontents = new ArrayList<ResponseOnSingleTask>();
	}
	
	Logger logger = LoggerFactory.getLogger(Utils_Parallec_Manger.class);
	
	public void prepareHttpGet(){
        ParallelClient pc = new ParallelClient();
        pc.prepareHttpGet("")
                .setConcurrency(1000)
                .setTargetHostsFromLineByLineText("http://www.parallec.io/userdata/sample_target_hosts_top100_old.txt",HostsSourceType.URL)
                .execute(new ParallecResponseHandler() {
                    public void onCompleted(ResponseOnSingleTask res, Map<String, Object> responseContext) {
                    	responseSontents.add(res);
                    }
                });
        pc.releaseExternalResources();
        
        
        if(pc.isClosed.get()){
            logger.info("----------------------------------------------");
        	for (ResponseOnSingleTask res : responseSontents) {
				logger.info("url = " + res.getHost()  + " , "
						  + "statusCode = " + res.getStatusCode() + ", "
						  + "statusCodeInt = " + res.getStatusCodeInt() + " , "
						  + "length = " + res.getResponseContent().length());
				
			}
            logger.info("----------------------------------------------");
        }

	}
	
	public static void main(String[] args) {
		Utils_Parallec_Manger.singleton.prepareHttpGet();
	}
	
}
