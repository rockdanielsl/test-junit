package com.example.demoJUnit;

import com.example.demoJUnit.constant.ResponseConstant;
import com.example.demoJUnit.model.Response;
import com.example.demoJUnit.util.FunctionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class FunctionUtilTest {

    @Test
    public void testGetJson() {

        String response = FunctionUtil.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, ResponseConstant.MESSAGE_FAILED, null));

        assertThat(response, is("{\"internalCode\":\""+ResponseConstant.STATUS_CODE_FAILED+"\",\"message\":\""+ResponseConstant.MESSAGE_FAILED+"\",\"payload\":null}"));
        assertThat(response, containsString(ResponseConstant.STATUS_CODE_FAILED));
    }

}
