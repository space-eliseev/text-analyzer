package space.eliseev.textanalyzer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;

@Builder
@Data
public class WordDto {

    private final String word;
    private final int count;

    public static final Comparator<WordDto> COMPARE_BY_COUNT = Comparator.comparingInt(WordDto::getCount);
}