package com.weuoimi.cyanea;

import com.weuoimi.cyanea.entity.Group;
import com.weuoimi.cyanea.factory.NoteType;
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

    private final Supplier<NoteType> noteType;

    private final Supplier<Optional<Group>> group;

    public String getTitle() {
        return title.get();
    }

    public File getFilePath() {
        return filePath.get();
    }

    public NoteType getNoteType() {
        return noteType.get();
    }

    public Optional<Group> getGroup() {
        return group.get();
    }
}
