package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P5_1_Merge_TableTest {


    @Test
    void solution() {
        // given
        String[] commands = {"UPDATE 1 1 menu",
                "UPDATE 1 2 category",
                "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean",
                "UPDATE 2 3 rice",
                "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean",
                "UPDATE 3 3 noodle",
                "UPDATE 3 4 instant",
                "UPDATE 4 1 pasta",
                "UPDATE 4 2 italian",
                "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3",
                "MERGE 1 3 1 4",
                "UPDATE korean hansik",
                "UPDATE 1 3 group",
                "UNMERGE 1 4",
                "PRINT 1 3",
                "PRINT 1 4"};
        String[] expected = {"EMPTY", "group"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
    @Test
    void solution2() {
        // given
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        String[] expected = {"d", "EMPTY"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        String[] commands = {"MERGE 1 1 2 2", "MERGE 1 1 3 3", "UPDATE 3 3 A", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3"};
        String[] expected = {"A", "A", "A"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution4() {
        // given
        String[] commands = {"UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"};
        String[] expected = {"EMPTY", "EMPTY", "A", "EMPTY"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution5() {
        // given
        String[] commands = {"UPDATE 1 1 menu", "MERGE 1 1 1 2", "MERGE 1 1 1 3", "MERGE 1 1 1 4", "MERGE 1 2 1 3", "UPDATE 1 1 hansik", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4"};
        String[] expected = {"hansik", "hansik", "hansik", "hansik"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution6() {
        // given
        String[] commands = {"MERGE 1 1 2 2",
                "UPDATE 1 1 A",
                "UNMERGE 1 1",
                "PRINT 1 1",
                "PRINT 2 2"};
        String[] expected = {"A", "EMPTY"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution7() {
        // given
        String[] commands = {"MERGE 1 1 2 2", "PRINT 1 1"};
        String[] expected = {"EMPTY"};

        // when
        P5_1_Merge_Table p5 = new P5_1_Merge_Table();
        String[] answer = p5.solution(commands);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }


    @Test
    void updateUsingIndexes() {
        // given
        int row = 0;
        int col = 0;
        String val = "menu";

        // when
        P5_1_Merge_Table.Table table = new P5_1_Merge_Table.Table();
        table.update(row, col, val);

        // then
        Assertions.assertThat(table.print(row, col)).isEqualTo(val);
    }

    @Test
    void updateMergedCell() {

    }

    @Test
    void updateUsingValues() {
        // given
        int row = 0;
        int col = 0;
        String val1 = "menu";
        String val2 = "category";

        // when
        P5_1_Merge_Table.Table table = new P5_1_Merge_Table.Table();
        table.update(row, col, val1);
        table.update(val1, val2);

        // then
        Assertions.assertThat(table.print(row, col)).isEqualTo(val2);
    }

    @Test
    void merge() {
        // given
        int row = 0;
        int col = 0;
        String val = "menu";

        int row2 = 0;
        int col2 = 1;
        String val2 = "category";

        // when
        P5_1_Merge_Table.Table table = new P5_1_Merge_Table.Table();
        table.update(row, col, val);
        table.update(row2, col2, val2);

        table.merge(row, col, row2, col2);

        // then
        Assertions.assertThat(table.print(row2, col2)).isEqualTo(val);
    }
}
