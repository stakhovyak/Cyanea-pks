package com.weuoimi.cyanea.params;

import com.weuoimi.cyanea.entity.Group;
import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.util.Optional;
import java.util.function.Supplier;

@Data
@Builder
public class NoteBuilderParams {

    private final Supplier<String> title;

    private final Supplier<File> filePath;

    private final Supplier<Optional<Group>> group;

    public String getTitle() {
        return title.get();
    }

    public File getFilePath() {
        return filePath.get();
    }

    public Optional<Group> getGroup() {
        return group.get();
    }
}
