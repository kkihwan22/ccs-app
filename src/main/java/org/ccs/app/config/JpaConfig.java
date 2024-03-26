package org.ccs.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.ccs.app")
@EnableJpaAuditing
@Configuration
public class JpaConfig {

}
