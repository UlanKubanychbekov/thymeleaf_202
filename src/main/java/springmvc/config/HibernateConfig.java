//package springmvc.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//@Configuration
//@ComponentScan("springmvc")
//@EnableWebMvc
//public class SpringConfig implements WebMvcConfigurer {
//    private final ApplicationContext applicationContext;
//
//    @Autowired
//    public SpringConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        registry.viewResolver(resolver);
//    }
//
//}
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.context.annotation.PropertySource;
////import org.springframework.core.env.Environment;
////import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
////import org.springframework.jdbc.datasource.DriverManagerDataSource;
////import org.springframework.orm.jpa.JpaTransactionManager;
////import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
////import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
////import org.springframework.transaction.annotation.EnableTransactionManagement;
////
////import javax.persistence.EntityManagerFactory;
////import javax.sql.DataSource;
////import java.util.Objects;
////import java.util.Properties;
////@Configuration
////@PropertySource("classpath:database.properties")
////@EnableTransactionManagement
////@ComponentScan("springmvc")
////public class HibernateConfig {
////    // Dependency
////    private final Environment env;
////
////    // Injection
////    public HibernateConfig(Environment env)     {
////        this.env = env;
////    }
////
////    @Bean
////    public DataSource getDataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        System.err.println(Objects.requireNonNull(env.getProperty("database.driver")));
////        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("database.driver")));
////        dataSource.setUrl(env.getProperty("database.url"));
////        dataSource.setUsername(env.getProperty("database.username"));
////        dataSource.setPassword(env.getProperty("database.password"));
////        System.err.println(env.getProperty("database.password"));
////        return dataSource;
////    }
////
////    private static Properties getHibernateProperties() {
////        Properties properties = new Properties();
////        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
////        properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
////            properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
////        return properties;
////    }
////
////    @Bean
////    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
////        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
////        jpaVendorAdapter.setGenerateDdl(true);
////        jpaVendorAdapter.setShowSql(true);
////
////        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
////                new LocalContainerEntityManagerFactoryBean();
////
////        entityManagerFactoryBean.setDataSource(dataSource);
////        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
////        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
////        entityManagerFactoryBean.setPackagesToScan("springmvc");
////        entityManagerFactoryBean.afterPropertiesSet();
////        return entityManagerFactoryBean.getObject();
////    }
////
////    @Bean
////    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
////        JpaTransactionManager transactionManager = new JpaTransactionManager();
////        transactionManager.setEntityManagerFactory(entityManagerFactory);
////        return transactionManager;
////    }
////
////    @Bean
////    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
////        return new PersistenceExceptionTranslationPostProcessor();
////    }
////}