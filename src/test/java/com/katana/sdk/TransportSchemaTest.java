package com.katana.sdk;

import com.katana.sdk.TransportSchema;
import com.katana.utils.MockFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by juane on 2/11/17.
 */
public class TransportSchemaTest {

    private TransportSchema transportSchema;

    @Before
    public void setup() {
        transportSchema = new TransportSchema();
    }

    @Test
    public void defaultValues() {
        Assert.assertNotEquals(null, transportSchema.getProperties());
        Assert.assertNotEquals(null, transportSchema.getData());
        Assert.assertNotEquals(null, transportSchema.getRelations());
        Assert.assertNotEquals(null, transportSchema.getLinks());
        Assert.assertNotEquals(null, transportSchema.getErrors());
    }

    @Test
    public void equalsAndHashcode() {
        MockFactory mockFactory = new MockFactory();
        TransportSchema object = mockFactory.getTransportSchema();
        Assert.assertEquals(object, new TransportSchema(object));
        Assert.assertEquals(1723662092, object.hashCode());
        Assert.assertEquals(
                "TransportSchema{properties={foo=123}, data=[{id=ValueSchema{type='integer', value=321}, name=ValueSchema{type='string', value=James}, status=ValueSchema{type='null', value=null}, info=ValueSchema{type='array', value=[{v=Hello World}]}, stats=ValueSchema{type='object', value={count={t=integer, v=12345}}}}], relations=[[1, user, 5], [1, comments, [3, 8]]], links={self=/1.0.0/posts}, errors=[[Unable to process posts, 0, 560 Logic Error]]}",
                object.toString());
    }

}