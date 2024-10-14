package com.weuoimi.cyanea;

import com.weuoimi.cyanea.entity.Note;
import com.weuoimi.cyanea.entity.Noteable;
import com.weuoimi.cyanea.factory.NoteType;
import com.weuoimi.cyanea.params.NoteBuilderParams;
import com.weuoimi.cyanea.parsers.TypeDefiner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Optional;

@SpringBootTest
public class NoteCreationTests {

    @Test
    void fileIsDetermined() {

        File fileTXT = new File("/temp/100/log.txt");
        File fileMD = new File("/home/user/readme.md");
        File fileORG = new File("/.emacs.d/init/config.org");

        NoteType noteTypeTXT = TypeDefiner.determineType(fileTXT);
        NoteType noteTypeMD = TypeDefiner.determineType(fileMD);
        NoteType noteTypeORG = TypeDefiner.determineType(fileORG);

        Assertions.assertEquals(NoteType.TXT_NOTE, noteTypeTXT, "Expected TXT_NOTE type for the file.");
        Assertions.assertEquals(NoteType.MD_NOTE, noteTypeMD, "Expected MD_NOTE type for the file.");
        Assertions.assertEquals(NoteType.ORG_NOTE, noteTypeORG, "Expected ORG_NOTE type for the file.");
    }

    @Test
    void unsupportedFormatIsHandled() {

        File unsupportedFile = new File("/home/Documents/dogs.png");

        UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            TypeDefiner.determineType(unsupportedFile);
        });
    }

    @Test
    void noteCreation_emptyGroup() {

        var txtNoteParams = NoteBuilderParams.builder()
                .title(() -> "Example TXT Note")
                .filePath(() -> new File("/var/log/xorg/Xorg.0.temp.txt"))
                .group(Optional::empty)
                .build();

        var txtNoteEmptyGroup = TypeDefiner.determineType(txtNoteParams.getFilePath()).create(txtNoteParams);

        Assertions.assertNotNull(txtNoteEmptyGroup, "Noteable should not be null");
        Assertions.assertTrue(txtNoteEmptyGroup instanceof Note, "Expected instance of Note");

        var orgNoteParams = NoteBuilderParams.builder()
                .title(() -> "Example ORG Note")
                .filePath(() -> new File("/home/user/Documents/Notes/ducks.org"))
                .group(Optional::empty)
                .build();

        var orgNoteEmptyGroup = TypeDefiner.determineType(orgNoteParams.getFilePath()).create(orgNoteParams);

        Assertions.assertNotNull(orgNoteEmptyGroup, "Noteable should not be null");
        Assertions.assertTrue(orgNoteEmptyGroup instanceof Note, "Expected instance of Note");

        var mdNoteParams = NoteBuilderParams.builder()
                .title(() -> "Example MD Note")
                .filePath(() -> new File("/Workspace/java-projects/readme.md"))
                .group(Optional::empty)
                .build();

        var mdNoteEmptyGroup = TypeDefiner.determineType(mdNoteParams.getFilePath()).create(mdNoteParams);

        Assertions.assertNotNull(mdNoteEmptyGroup, "Noteable should not be null");
        Assertions.assertTrue(mdNoteEmptyGroup instanceof Note, "Expected instance of Note");
    }


}
