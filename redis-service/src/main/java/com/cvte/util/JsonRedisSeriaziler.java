package com.cvte.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * 使用Jackson自定义json序列化工具
 */
public class JsonRedisSeriaziler {
	public static final String EMPTY_JSON = "{}";  
    

      
    protected static ObjectMapper objectMapper = new ObjectMapper();


    /** 
     * java-object as json-string 
     * @param object 
     * @return 
     */  
    public static String seriazileAsString(Object object){
        if (object== null) {  
            return EMPTY_JSON;  
        }  
        try {  
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {  
            throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
        }  
    }  
      
    /** 
     * json-string to java-object 
     * @param str 
     * @return 
     */  
    public static <T> T deserializeAsObject(String str,Class<T> clazz){
        if(str == null || clazz == null){  
            return null;  
        }  
        try{  
            return objectMapper.readValue(str, clazz);
        }catch (Exception ex) {  
            throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
        }  
    }  
}
