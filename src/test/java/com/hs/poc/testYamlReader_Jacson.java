package com.hs.poc;

import com.hs.testDataBeans.FilePaths;
import com.hs.testDataBeans.UsersDataBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.File;
import java.io.IOException;

public class testYamlReader_Jacson {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UsersDataBean usersDataBeanObj = mapper.readValue(new File(FilePaths.USERS_DATA), UsersDataBean.class);
        System.out.println(ReflectionToStringBuilder.toString(usersDataBeanObj, ToStringStyle.MULTI_LINE_STYLE));

    }
}
