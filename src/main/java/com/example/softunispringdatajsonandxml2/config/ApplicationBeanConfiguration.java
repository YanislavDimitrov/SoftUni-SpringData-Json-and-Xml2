package com.example.softunispringdatajsonandxml2.config;

import com.example.softunispringdatajsonandxml2.models.Car;
import com.example.softunispringdatajsonandxml2.models.Customer;
import com.example.softunispringdatajsonandxml2.models.Part;
import com.example.softunispringdatajsonandxml2.models.Sale;
import com.example.softunispringdatajsonandxml2.models.dtos.SaleWithDiscountDto;
import com.google.gson.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Sale, SaleWithDiscountDto> saleWithDiscountDtoTypeMap = mapper.createTypeMap(Sale.class, SaleWithDiscountDto.class);
        Converter<Car, BigDecimal> carPriceConverter = new Converter<Car, BigDecimal>() {
            @Override
            public BigDecimal convert(MappingContext<Car, BigDecimal> mappingContext) {
                BigDecimal total = BigDecimal.ZERO;
                List<Part> parts = mappingContext.getSource().getParts();
                for (Part part : parts) {
                    total = total.add(part.getPrice());
                }
                return total;
            }
        };

//        saleWithDiscountDtoTypeMap.addMappings(m -> m.using(carPriceWithDiscountConverter).map(src -> src, SaleWithDiscountDto::setPriceWithDiscount));
        saleWithDiscountDtoTypeMap.addMappings(m -> m.using(carPriceConverter).map(Sale::getCar, SaleWithDiscountDto::setPrice));
        return mapper;
    }


    @Bean
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting();
        return gsonBuilder.registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
            }
        }).create();
    }
}
