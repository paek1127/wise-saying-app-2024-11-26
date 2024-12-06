package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.standard.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingFileRepositoryTest {
    private final WiseSayingFileRepository wiseSayingRepository = new WiseSayingFileRepository();

    @BeforeEach
    public void beforeEach() {
        Util.file.rmdir(WiseSayingFileRepository.getTableDirPath());
    }

    @AfterEach
    public void afterEach() {
        Util.file.rmdir(WiseSayingFileRepository.getTableDirPath());
    }

    @Test
    @DisplayName("명언 저장")
    public void t1() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "저자1");
        wiseSayingRepository.save(wiseSaying);

        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(wiseSaying.getId());

        assertThat(
                opWiseSaying.get()
        ).isEqualTo(wiseSaying);
    }

    @Test
    @DisplayName("명언 삭제")
    public void t2() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "저자1");
        wiseSayingRepository.save(wiseSaying);

        wiseSayingRepository.deleteById(wiseSaying.getId());

        String filePath = WiseSayingFileRepository.getRowFilePath(wiseSaying.getId());

        assertThat(
                Util.file.exists(filePath)
        ).isFalse();
    }

    @Test
    @DisplayName("명언 단건 조회")
    public void t3() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "저자1");
        wiseSayingRepository.save(wiseSaying);

        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(wiseSaying.getId());

        assertThat(
                opWiseSaying.get()
        ).isEqualTo(wiseSaying);
    }

    @Test
    @DisplayName("명언 다건 조회")
    public void t4() {
        WiseSaying wiseSaying1 = new WiseSaying(0, "명언1", "저자1");
        wiseSayingRepository.save(wiseSaying1);

        WiseSaying wiseSaying2 = new WiseSaying(0, "명언2", "저자2");
        wiseSayingRepository.save(wiseSaying2);

        assertThat(
                wiseSayingRepository.findAll()
        ).containsExactlyInAnyOrder(wiseSaying1,wiseSaying2);
    }

    @Test
    @DisplayName("lastId.txt 생성")
    public void t5() {
        WiseSaying wiseSaying1 = new WiseSaying(0, "명언1", "저자1");
        wiseSayingRepository.save(wiseSaying1);

        int lastId = wiseSayingRepository.getLastId();

        assertThat(lastId).isEqualTo(wiseSaying1.getId());
    }

    @Test
    @DisplayName("명언 수정")
    public void t6() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "저자1");
        wiseSayingRepository.save(wiseSaying);

        wiseSaying.setContent("수정내용1");
        wiseSaying.setAuthor("수정저자1");

        wiseSayingRepository.save(wiseSaying);

        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(wiseSaying.getId());

        assertThat(
                opWiseSaying.get()
        ).isEqualTo(wiseSaying);
    }
}
