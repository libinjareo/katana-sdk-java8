package com.katana.sdk;

import com.katana.sdk.ActionParamSchema;
import com.katana.utils.MockFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by juane on 2/11/17.
 */
public class ActionParamSchemaTest {

    private ActionParamSchema actionParamSchema;

    @Before
    public void setup() {
        actionParamSchema = new ActionParamSchema();
    }

    @Test
    public void defaultValues() {
        Assert.assertEquals("string", actionParamSchema.getType());
        Assert.assertEquals("csv", actionParamSchema.getArrayFormat());
        Assert.assertFalse(actionParamSchema.isAllowEmpty());
        Assert.assertFalse(actionParamSchema.isRequired());
        Assert.assertFalse(actionParamSchema.isExclusiveMax());
        Assert.assertFalse(actionParamSchema.isExclusiveMin());
        Assert.assertFalse(actionParamSchema.isUniqueItems());
        Assert.assertNotEquals(null, actionParamSchema.getHttpSchema());
    }

    @Test
    public void equalsAndHashcode() {
        MockFactory mockFactory = new MockFactory();
        ActionParamSchema object = mockFactory.getActionParamSchema();
        Assert.assertEquals(object, new ActionParamSchema(object));
        Assert.assertEquals(-1440566884, object.hashCode());
        Assert.assertEquals(
                "ActionParamSchema{type='string', format='uuid', arrayFormat='csv', pattern='[a-zA-Z0-9]+', allowEmpty=false, defaultValue='0', required=true, items='{\"user_id\": \"0\"}', max=100, exclusiveMax=true, min=0, exclusiveMin=true, maxLength=500, minLength=3, maxItems=20, minItems=2, uniqueItems=false, enumeration=[0, 1, 2], multipleOf=5, http=ActionParamHttpSchema{gateway=true, input='path', param='user_id'}}",
                object.toString());
    }

}