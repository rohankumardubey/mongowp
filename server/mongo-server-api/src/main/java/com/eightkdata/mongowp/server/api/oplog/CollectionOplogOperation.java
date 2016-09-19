package com.eightkdata.mongowp.server.api.oplog;

import com.eightkdata.mongowp.OpTime;
import com.eightkdata.mongowp.bson.BsonValue;
import com.eightkdata.mongowp.fields.StringField;
import com.eightkdata.mongowp.utils.BsonDocumentBuilder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 *
 */
@Immutable
public abstract class CollectionOplogOperation extends OplogOperation {
    private static final long serialVersionUID = 1L;
    
    private static final StringField NS_FIELD = new StringField("ns");
    private final String collection;

    public CollectionOplogOperation(
            String database,
            String collection,
            OpTime optime,
            long h,
            OplogVersion version,
            boolean fromMigrate) {
        super(database, optime, h, version, fromMigrate);
        this.collection = collection;
    }

    public String getCollection() {
        return collection;
    }

    @Override
    public BsonDocumentBuilder toDescriptiveBson() {
        BsonDocumentBuilder result = super.toDescriptiveBson();
        result.append(NS_FIELD, getDatabase() + '.' + collection);
        return result;
    }

    @Nullable
    public abstract BsonValue<?> getDocId();

}
