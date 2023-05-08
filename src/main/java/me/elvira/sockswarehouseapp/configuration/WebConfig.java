package me.elvira.sockswarehouseapp.configuration;

import me.elvira.sockswarehouseapp.componets.SizeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addFormatters(FormatterRegistry registry){
        registry.addConverter( new SizeConverter());
    }
}
