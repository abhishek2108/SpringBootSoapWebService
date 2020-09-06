package com.abhishek.learning.soapwebservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispathcerServlet(ApplicationContext context){

        MessageDispatcherServlet message = new MessageDispatcherServlet();
        message.setApplicationContext(context);
        message.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(message,"/ws/*");

    }

    @Bean
    public XsdSchema userSchema(){
        return new SimpleXsdSchema(new ClassPathResource("schema/user.xsd"));
    }

    @Bean(name= "user")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("UserPort");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://abhishek.com/learning/producingwebservice");
        defaultWsdl11Definition.setSchema(userSchema);
        return defaultWsdl11Definition;
    }
}
