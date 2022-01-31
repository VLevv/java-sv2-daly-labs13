package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LettersTest {
    @Test
    void testString(){
        Letters letters = new Letters();
        Map<String,Integer> testMap=letters.mapper("albatrosz");
        assertEquals(2,testMap.get("a"));
        assertEquals(1,testMap.get("o"));
    }
}