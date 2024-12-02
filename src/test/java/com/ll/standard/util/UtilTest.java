package com.ll.standard.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @BeforeAll
    public static void beforeAll() {
        Util.file.mkdir("temp");
    }

    @AfterAll
    public static void afterAll() {
        Util.file.rmdir("temp");
    }

    @Test
    public void createFile() {
        // given
        String filePath = "temp/test.txt";

        // when
        Util.file.touch(filePath);

        // then
        assertThat(
                Util.file.exists(filePath)
        ).isTrue();
    }

    @Test
    public void modifyFile() {
        // given
        String filePath = "temp/test.txt";

        // when
        Util.file.set(filePath, "내용");

        // then
        assertThat(
                Util.file.get(filePath, "")
        ).isEqualTo("내용");
    }

    @Test
    public void deleteFile() {
        // given
        String filePath = "temp/test.txt";

        // when
        Util.file.touch(filePath);
        Util.file.delete(filePath);

        // then
        assertThat(
                Util.file.notExists(filePath)
        ).isTrue();
    }

    @Test
    public void createDirFile() {
        // given
        String filePath = "temp/temp/test.txt";

        // when
        Util.file.touch(filePath);

        // then
        assertThat(
                Util.file.exists(filePath)
        ).isTrue();
    }
}
