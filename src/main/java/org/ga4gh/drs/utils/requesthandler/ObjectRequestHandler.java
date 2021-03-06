package org.ga4gh.drs.utils.requesthandler;

import org.ga4gh.drs.exception.ResourceNotFoundException;
import org.ga4gh.drs.model.DrsObject;
import org.ga4gh.drs.utils.DataSourceLookup;
import org.ga4gh.drs.utils.objectloader.DrsObjectLoader;
import org.springframework.beans.factory.annotation.Autowired;

public class ObjectRequestHandler implements RequestHandler<DrsObject> {

    private String objectId;

    @Autowired
    DataSourceLookup dataSourceLookup;

    public ObjectRequestHandler() {
        
    }

    public ObjectRequestHandler(String objectId) {
        this.objectId = objectId;
    }

    public DrsObject handleRequest() {

        DrsObjectLoader drsObjectLoader = dataSourceLookup.getDrsObjectLoaderFromId(objectId);
        if (drsObjectLoader == null) {
            throw new ResourceNotFoundException("Could not locate data source associated with requested object_id");
        }

        //TODO: complete object handling function
        /*
        if (!drsObjectLoader.exists()) {
            throw new ResourceNotFoundException("No object found for the provided id");
        }

        DrsObject imputedDrsObject = drsObjectLoader.getImputedProperties();
        DrsObject explicitDrsObject = drsObjectLoader.getExplicitProperties();
        DeepObjectMerger.merge(explicitDrsObject, imputedDrsObject);
        return imputedDrsObject;
        */

        return null;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }
    
}
