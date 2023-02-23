package chapter4.abstractions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"chapter4.abstractions.repositories", "chapter4.abstractions.proxies", "chapter4.abstractions.services"})
public class ProjectConfiguration { }