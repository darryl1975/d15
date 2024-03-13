package sg.edu.nus.iss.day15demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day15demo.utils.Util;

@Repository
public class TestRepo {
    
    @Autowired
    @Qualifier(Util.REDIS_ONE)
    RedisTemplate<String, String> redisTemplate;

    // slide 24
    public void storeValueData(String key, String value) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        valueOps.set(key, value);
    }

    // slide 25
    public String retrieveValueData(String key) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        return valueOps.get(key).toString();
    }

    // slide 26
    public void incrementValueData(String key, Long valueToIncrease) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        valueOps.increment(key, valueToIncrease);
    }

    // slide 27 & 28
    public Boolean deleteKey(String key) {
        Boolean isKeyPresent = redisTemplate.hasKey(key);
        Boolean isDeleted = false;

        if (isKeyPresent) {
            isDeleted = redisTemplate.delete(key);
        }

        return isDeleted;
    }

    // slide 30
    public void addToList(String key, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.rightPush(key, value);
    }

    // slide 29
    public List<String> getList(String key) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.range(key, 0, -1);
    }

    // slide 29
    public Long getListSize(String key) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();

        return listOps.size(key);
    }
}
