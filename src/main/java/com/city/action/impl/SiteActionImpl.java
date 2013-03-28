package com.city.action.impl;

/** 
 * All crud operation implement here.
 * following coding stander maintain transeciton in appliction.  
 * @author santosh yevle
 */

import org.springframework.stereotype.Service;

import com.city.action.ISiteAction;
import com.city.model.obj.pune.Site;
import com.city.services.data.impl.DataLayerPuneImpl;

@Service
public class SiteActionImpl implements ISiteAction {
	@Override
	public void delete(Long id) {
    	Site frmObject = DataLayerPuneImpl.getInstance().getSite(id);
    	DataLayerPuneImpl.getInstance().delete(frmObject);
		DataLayerPuneImpl.getInstance().flushSession(); // flush+evict from cache to make sure we hit the DB next 
		DataLayerPuneImpl.getInstance().evict(frmObject);
	}
	@Override
	public Site saveOrUpdate(Site frmObject) {
    	
    	DataLayerPuneImpl.getInstance().saveOrUpdate(frmObject);
		DataLayerPuneImpl.getInstance().flushSession(); // flush+evict from cache to make sure we hit the DB next 
		DataLayerPuneImpl.getInstance().evict(frmObject);
		
		return frmObject;
	}
	@Override
	public Site save(Site frmObject) {
    	DataLayerPuneImpl.getInstance().save(frmObject);
		DataLayerPuneImpl.getInstance().flushSession(); // flush+evict from cache to make sure we hit the DB next 
		DataLayerPuneImpl.getInstance().evict(frmObject);
		
		return frmObject;     
	}

}
