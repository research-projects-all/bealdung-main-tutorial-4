# bealdung-main-tutorial-4

created from https://github.com/eugenp/tutorials/tree/07d2af75e1e178b6a94fe4434217ed2b4a7ade3b/spring-web-modules/spring-mvc-java for the tutorial https://www.baeldung.com/spring-mvc-tutorial


Update WebConfig to Spring 6
Open:

src/main/java/com/baeldung/spring/web/config/WebConfig.java


import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;


Change them to:

import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;


Inside the class,

@Bean
public SpringResourceTemplateResolver templateResolver() { ... }

@Bean
public SpringTemplateEngine templateEngine() { ... }

@Bean
public ThymeleafViewResolver viewResolver() { ... }


NO  need to change the method bodies or class names; the type names (SpringTemplateEngine, SpringResourceTemplateResolver, ThymeleafViewResolver) are the same in Spring 6 – only the package changed.

this contain custom safe patterns
