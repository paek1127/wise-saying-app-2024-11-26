package com.ll.standard.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @Test
    public void createFile() {
        // given
        String filePath = "test.txt";

        // when
        Util.file.touch(filePath);

        // then
        assertThat(Util.file.exists(filePath)).isTrue();
    }

    @Test
    public void modifyFile() {
        // given
        String filePath = "test.txt";

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
        String filePath = "test.txt";

        // when
        Util.file.touch(filePath);
        Util.file.delete(filePath);

        // then
        assertThat(
                Util.file.notExists(filePath)
        ).isTrue();
    }
}
