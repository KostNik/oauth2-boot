package com.edu.authservice.websecurityconfig.mongodb;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.edu.authservice.repo")
public class MongoConfig {

//    @Autowired
//    private GenericConversionService genericConversionService;
//
//    @Bean
//    public String2GAUserConverter string2MongoUserConverter(){
//        String2GAUserConverter string2MongoUserConverter = new String2GAUserConverter();
//        genericConversionService.addConverter(string2MongoUserConverter);
//        return string2MongoUserConverter;
//    }

}
