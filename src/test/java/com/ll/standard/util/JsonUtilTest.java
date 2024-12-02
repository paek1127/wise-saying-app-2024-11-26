package com.ll.standard.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilTest {
    @Test
    public void mapToJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "이름");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름"
                }
                """.stripIndent().trim());
    }

    @Test
    public void mapToJson2() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    public void mapToJsonNumber() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    public void mapToJsonDouble() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");
        map.put("height", 178.1543221);

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 178.1543221
                }
                """.stripIndent().trim());
    }

    @Test
    public void mapToJsonBoolean() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");
        map.put("height", 178.1543221);
        map.put("married", true);

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 178.1543221,
                    "married": true
                }
                """.stripIndent().trim());
    }

    @Test
    public void jsonToMap() {
        String jsonStr = """
                {
                    "name": "이름",
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map).containsEntry("name", "이름");
    }

    @Test
    public void jsonToMap2() {
        String jsonStr = """
                {
                    "name": "이름",
                    "gender": "남자",
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자");
    }

    @Test
    public void jsonToMapNumber() {
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자");
    }

    @Test
    public void jsonToMapDouble() {
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 178.1543221
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자")
                .containsEntry("height", 178.1543221);
    }
}
