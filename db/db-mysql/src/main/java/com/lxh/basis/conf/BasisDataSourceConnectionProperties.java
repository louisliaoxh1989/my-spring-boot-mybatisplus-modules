package com.lxh.basis.conf;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.lxh.DataSourceConnectionProperties;
/**
 * Created by Ason on 2017/10/31.
 */
@Configuration
@ConfigurationProperties(prefix = "basis.connection")
public class BasisDataSourceConnectionProperties extends DataSourceConnectionProperties {

}
