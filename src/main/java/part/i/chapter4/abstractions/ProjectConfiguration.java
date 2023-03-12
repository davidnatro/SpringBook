package part.i.chapter4.abstractions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "part.i.chapter4.abstractions.repositories",
        "part.i.chapter4.abstractions.proxies", "part.i.chapter4.abstractions.services" })
public class ProjectConfiguration { }